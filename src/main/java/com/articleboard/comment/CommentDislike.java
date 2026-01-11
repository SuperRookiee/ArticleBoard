package com.articleboard.comment;

import com.articleboard.user.User;
import jakarta.persistence.*;

@Entity
public class CommentDislike {

    @EmbeddedId
    private CommentDislikeId id;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Comment comment;

    @MapsId("userNo")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no")
    private User user;

    public CommentDislike() {}

    public CommentDislike(Comment comment, User user) {
        this.comment = comment;
        this.user = user;
    }
}
