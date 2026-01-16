package com.articleboard.article.entity;

import com.articleboard.user.entity.User;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;

@Entity
@Table(name = "article")
@SQLRestriction("deleted_at IS NULL")
@SQLDelete(sql = "UPDATE article SET deleted_at = NOW() WHERE article_no = ?")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no")
    private User user;
}
