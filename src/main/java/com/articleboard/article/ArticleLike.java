package com.articleboard.article;

import com.articleboard.user.User;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class ArticleLike implements Serializable {

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

    public ArticleLike() {}

    public ArticleLike(Article article, User user) {
        this.article = article;
        this.user = user;
    }
}
