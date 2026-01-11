package com.articleboard.article;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ArticleLikeId implements Serializable {

    private Long articleNo;
    private Long userNo;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ArticleLikeId that = (ArticleLikeId) o;
        return Objects.equals(articleNo, that.articleNo) && Objects.equals(userNo, that.userNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleNo, userNo);
    }
}
