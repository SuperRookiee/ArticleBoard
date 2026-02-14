package com.articleboard.article.entity;

import com.articleboard.user.entity.User;
import jakarta.persistence.*;

@Entity
public class ArticleDislike {

    @EmbeddedId
    private ArticleDislikeId id;

    @MapsId("articleId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private ArticleDislike(Article article, User user) {
        this.id = ArticleDislikeId.of(article.getArticleId(), user.getUserId());
        this.article = article;
        this.user = user;
    }

    protected ArticleDislike() {
    }

    public static ArticleDislike createArticleDislike(Article article, User user) {
        return new ArticleDislike(article, user);
    }
}
