package com.mkm.erp.domain.auth.service;

import com.mkm.erp.config.JwtUtil;
import com.mkm.erp.config.PasswordEncoder;
import com.mkm.erp.domain.auth.dto.request.SigninRequest;
import com.mkm.erp.domain.auth.dto.request.SignupRequest;
import com.mkm.erp.domain.auth.dto.response.SigninResponse;
import com.mkm.erp.domain.auth.dto.response.SignupResponse;
import com.mkm.erp.domain.common.exception.InvalidRequestException;
import com.mkm.erp.domain.user.entity.User;
import com.mkm.erp.domain.user.entity.UserRole;
import com.mkm.erp.domain.user.repository.UserRepository;
import jakarta.security.auth.message.AuthException;
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
    public SignupResponse signup(SignupRequest signupRequest) {

        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            throw new InvalidRequestException("이미 존재하는 이메일입니다.");
        }

        String encodedPassword = passwordEncoder.encode(signupRequest.getPassword());

        UserRole userRole = UserRole.of(signupRequest.getUserRole());

        User newUser = new User(
                signupRequest.getEmail(),
                signupRequest.getName(),
                encodedPassword,
                userRole
        );
        User savedUser = userRepository.save(newUser);

        String bearerToken = jwtUtil.createToken(savedUser.getId(), savedUser.getEmail(), savedUser.getNickname(), userRole);

        return new SignupResponse(bearerToken);
    }

    public SigninResponse signin(SigninRequest signinRequest) {
        User user = userRepository.findByEmail(signinRequest.getEmail()).orElseThrow(
                () -> new InvalidRequestException("가입되지 않은 유저입니다."));

        // 로그인 시 이메일과 비밀번호가 일치하지 않을 경우 401을 반환합니다.
        if (!passwordEncoder.matches(signinRequest.getPassword(), user.getPassword())) {
            try {
                throw new AuthException("잘못된 비밀번호입니다.");
            } catch (AuthException e) {
                throw new RuntimeException(e);
            }
        }

        String bearerToken = jwtUtil.createToken(user.getId(), user.getEmail(), user.getEmail(), user.getUserRole());

        return new SigninResponse(bearerToken);
    }
}
