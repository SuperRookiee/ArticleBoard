package com.articleboard.user.service;

import com.articleboard.global.exception.CustomException;
import com.articleboard.user.dto.UserRequestDto;
import com.articleboard.user.entity.User;
import com.articleboard.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new CustomException("유저 없음"));
    }

    @Transactional
    public void register(UserRequestDto request) {
        if (userRepository.existsByUserName(request.getUserName())) {
            throw new CustomException("이미 존재하는 사용자입니다");
        }
        userRepository.save(User.create(
                request.getUserName(),
                passwordEncoder.encode(request.getUserPassword()),
                request.getNicknameType(),
                request.getNickname()
        ));
    }
}
