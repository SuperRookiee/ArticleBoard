package com.articleboard.article.entity;

import com.articleboard.user.entity.User;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class ArticleDislike implements Serializable {

    @EmbeddedId
    private ArticleLikeId id;

    @MapsId("articleNo")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_no")
    private Article article;

    @MapsId("userNo")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no")
    private User user;

    public ArticleDislike() {}

    public ArticleDislike(Article article, User user) {
        this.article = article;
        this.user = user;
    }
}
