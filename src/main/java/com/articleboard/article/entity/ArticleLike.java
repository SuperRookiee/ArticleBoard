package com.articleboard.article.entity;

import com.articleboard.user.entity.User;
import jakarta.persistence.*;

@Entity
public class ArticleLike {

    @EmbeddedId
    private ArticleLikeId id;

    @MapsId("articleId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private ArticleLike(Article article, User user) {
        this.id = ArticleLikeId.of(article.getArticleId(), user.getUserId());
        this.article = article;
        this.user = user;
    }

    protected ArticleLike() {
    }

    public static ArticleLike createArticleLike(Article article, User user) {
        return new ArticleLike(article, user);
    }
}
