package com.articleboard.comment.entity;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class CommentDislikeId {

    private Long id;
    private Long userId;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CommentDislikeId that = (CommentDislikeId) o;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId);
    }
}
