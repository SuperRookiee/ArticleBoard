package com.articleboard.comment.entity;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class CommentLikeId {

    private Long id;
    private Long userNo;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CommentLikeId that = (CommentLikeId) o;
        return Objects.equals(id, that.id) && Objects.equals(userNo, that.userNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userNo);
    }
}
