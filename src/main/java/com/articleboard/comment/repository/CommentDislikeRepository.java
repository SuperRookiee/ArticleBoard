package com.articleboard.comment.repository;

import com.articleboard.comment.entity.CommentDislike;
import com.articleboard.comment.entity.CommentDislikeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDislikeRepository extends JpaRepository<CommentDislike, CommentDislikeId> {

    boolean existsByComment_IdAndUser_UserNo(Long commentId, Long userNo);

    Long countByComment_Id(Long commentId);

}
