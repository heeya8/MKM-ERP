package com.mkm.erp.domain.auth.service;

import com.mkm.erp.config.JwtUtil;
import com.mkm.erp.config.PasswordEncoder;
import com.mkm.erp.domain.auth.dto.request.SigninRequest;
import com.mkm.erp.domain.auth.dto.request.SignupRequest;
import com.mkm.erp.domain.common.exception.InvalidRequestException;
import com.mkm.erp.domain.user.entity.User;
import com.mkm.erp.domain.user.entity.UserRole;
import com.mkm.erp.domain.user.repository.UserRepository;
import jakarta.security.auth.message.AuthException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    @Transactional
    public void signup(SignupRequest signupRequest, HttpServletResponse httpResponse) {

        // 이메일 중복 여부 확인
        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            throw new InvalidRequestException("이미 존재하는 이메일입니다.");
        }

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(signupRequest.getPassword());

        // 역할 설정
        UserRole userRole = UserRole.of(signupRequest.getUserRole());

        // 새로운 사용자 생성
        User newUser = new User(
                signupRequest.getEmail(),
                signupRequest.getName(),
                encodedPassword,
                userRole
        );

        // 사용자 저장
        User savedUser = userRepository.save(newUser);

        // JWT 생성 및 쿠키로 저장
        jwtUtil.createToken(savedUser.getId(), savedUser.getEmail(), savedUser.getNickname(), userRole, httpResponse);
    }


    public void signin(SigninRequest signinRequest, HttpServletResponse httpResponse) {
        User user = userRepository.findByEmail(signinRequest.getEmail()).orElseThrow(
                () -> new InvalidRequestException("가입되지 않은 유저입니다."));

        // 로그인 시 이메일과 비밀번호가 일치하지 않을 경우 401을 반환
        if (!passwordEncoder.matches(signinRequest.getPassword(), user.getPassword())) {
            try {
                throw new AuthException("잘못된 비밀번호입니다.");
            } catch (AuthException e) {
                throw new RuntimeException(e);
            }
        }

        jwtUtil.createToken(user.getId(), user.getEmail(), user.getNickname(), user.getUserRole(), httpResponse);
    }
}
