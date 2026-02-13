package com.articleboard.comment.service;

import com.articleboard.article.entity.Article;
import com.articleboard.article.repository.ArticleRepository;
import com.articleboard.comment.dto.CommentRequestDto;
import com.articleboard.comment.dto.CommentResponseDto;
import com.articleboard.comment.entity.Comment;
import com.articleboard.comment.repository.CommentRepository;
import com.articleboard.global.exception.CustomException;
import com.articleboard.user.entity.User;
import com.articleboard.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;

    /*
    @Transactional
    public void createComment(CommentRequestDto dto, Article article, User user) {
        commentRepository.save(Comment.createComment(dto.getContent(), article, user));
    }

    @Transactional
    public void updateComment(Long commentId, CommentRequestDto dto, User user) {
        Comment comment = findComment(commentId);
        comment.update(dto.getContent(), user);
    }

    @Transactional
    public void deleteComment(Long commentId, User user) {
        Comment comment = findComment(commentId);
        comment.validateOwner(user);

        if (comment.getParentId() == null) {
            if (commentRepository.existsByParentId(commentId)) {
                comment.delete();
            } else {
                commentRepository.delete(comment);
            }
        } else {
            commentRepository.delete(comment);

            Comment parent = findComment(comment.getParentId());
            if (parent.getIsDeleted() && !commentRepository.existsByParentId(parent.getId())) {
                commentRepository.delete(parent);
            }
        }
    }
    */

    // TODO: 로그인 구현 후 User user로 변경, findUser() 및 UserRepository 제거
    private final UserRepository userRepository;  // 추가 (추후 로그인 구현 시 제거)
    private final ArticleRepository articleRepository;

    @Transactional
    public Long createComment(CommentRequestDto dto, Long articleId, Long userId) {
        User user = findUser(userId);
        Article article = findArticle(articleId);
        Comment comment = Comment.createComment(dto.getContent(), article, user);

        return commentRepository.save(comment).getCommentId();
    }

    @Transactional
    public void updateComment(Long commentId, CommentRequestDto dto, Long userId) {
        Comment comment = findComment(commentId);
        User user = findUser(userId);
        comment.update(dto.getContent(), user);
    }

    @Transactional
    public void deleteComment(Long commentId, Long userId) {
        Comment comment = findComment(commentId);
        User user = findUser(userId);

        if (comment.getRootId() == null) {
            if (commentRepository.existsByRootId(comment.getCommentId())) {
                comment.softDelete(user);
            } else {
                hardDelete(comment, user);
            }
        } else {
            hardDelete(comment, user);

            Comment root = findComment(comment.getRootId());
            if (root.getIsDeleted() && !commentRepository.existsByRootId(root.getCommentId())) {
                commentRepository.delete(root);
            }
        }
    }

    private void hardDelete(Comment comment, User user) {
        comment.validateOwner(user);
        commentRepository.delete(comment);
    }

    private User findUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new CustomException("유저 없음"));
    }

    private Article findArticle(Long articleId) {
        return articleRepository.findById(articleId)
                .orElseThrow(() -> new CustomException("게시글 없음"));
    }

    public Page<CommentResponseDto> getCommentList(Long articleId, Pageable pageable) {
        return commentRepository.findByArticle_ArticleId(articleId, pageable)
                .map(CommentResponseDto::from);
    }

    private Comment findComment(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new CustomException("댓글 없음"));
    }

    @Transactional
    public Long createChildComment(CommentRequestDto dto, Long userId, Long targetId) {
        User user = findUser(userId);
        Comment target = findComment(targetId);
        return commentRepository.save(Comment.createReply(dto.getContent(), user, target)).getCommentId();
    }
}
