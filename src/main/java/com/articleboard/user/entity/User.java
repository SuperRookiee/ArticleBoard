package com.articleboard.user.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;

    private String userPassword;

    private String fixedName;

    private String temporaryName;

    @Enumerated(EnumType.STRING)
    private nicknameType nicknameType;

    @Enumerated(EnumType.STRING)
    private userRole role;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private userStatus status;
}
