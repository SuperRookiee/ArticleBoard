package com.articleboard.article.repository;

import com.articleboard.article.entity.ArticleDislike;
import com.articleboard.article.entity.ArticleDislikeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDislikeRepository extends JpaRepository<ArticleDislike, ArticleDislikeId> {

    boolean existsByArticle_ArticleIdAndUser_UserId(Long articleId, Long userId);

    Long countByArticle_ArticleId(Long articleId);
}
