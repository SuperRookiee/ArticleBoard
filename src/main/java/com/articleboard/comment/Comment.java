package com.articleboard.comment;

import com.articleboard.article.Article;
import com.articleboard.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String writer;

    private String content;

    private LocalDateTime createdAt;

    private Long parent;

    private Boolean isDeleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userNo")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "articleNo")
    private Article article;


}
