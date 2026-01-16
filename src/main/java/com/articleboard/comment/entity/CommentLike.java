package com.articleboard.comment.entity;

import com.articleboard.user.entity.User;
import jakarta.persistence.*;

@Entity
public class CommentLike {

    @EmbeddedId
    private CommentLikeId id;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Comment comment;

    @MapsId("userNo")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no")
    private User user;

    public CommentLike() {}

    public CommentLike(Comment comment, User user) {
        this.comment = comment;
        this.user = user;
    }
}
