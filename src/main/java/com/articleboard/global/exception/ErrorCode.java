package com.articleboard.global.exception;

import org.springframework.http.HttpStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "유저 없음"),
    DUPLICATE_USER(HttpStatus.CONFLICT, "이미 존재하는 사용자입니다"),

    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "게시글 없음"),
    INVALID_SEARCH_TYPE(HttpStatus.BAD_REQUEST, "잘못된 검색 타입"),

    COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "댓글 없음"),

    FORBIDDEN(HttpStatus.FORBIDDEN, "권한 없음");

    private final HttpStatus status;
    private final String message;
}
