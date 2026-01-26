package com.articleboard.comment.entity;

import com.articleboard.user.entity.User;
import jakarta.persistence.*;

@Entity
public class CommentDislike {

    @EmbeddedId
    private CommentDislikeId id;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Comment comment;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public CommentDislike() {}

    public CommentDislike(Comment comment, User user) {
        this.comment = comment;
        this.user = user;
    }
}
