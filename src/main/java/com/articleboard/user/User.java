package com.articleboard.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;

    private String userId;

    private String userPassword;

    private String fixedName;

    private String temporaryName;

    private nicknameType nicknameType;

    private userRole role;

    private LocalDateTime createdAt;

    private userStatus status;
}
