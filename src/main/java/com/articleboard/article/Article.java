package com.articleboard.article;

import com.articleboard.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleNo;

    private String title;

    private String content;

    private String writer;

    private Long viewCount;

    private Boolean isNotice;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    private Long likeCount;

    private Long dislikeCount;

    private Long commentCount;

    private Boolean isDeleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userNo")
    private User user;
}
