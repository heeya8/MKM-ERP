package com.mkm.erp.domain.auth.controller;

import com.mkm.erp.domain.auth.dto.request.SigninRequest;
import com.mkm.erp.domain.auth.dto.request.SignupRequest;
import com.mkm.erp.domain.auth.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody SignupRequest signupRequest, HttpServletResponse servletResponse) {
        authService.signup(signupRequest, servletResponse); // 회원가입 처리
        return ResponseEntity.ok("회원가입이 완료되었습니다."); // 성공 메시지 반환
    }

    @PostMapping("/auth/signin")
    public ResponseEntity<String> signin(@Valid @RequestBody SigninRequest signinRequest, HttpServletResponse httpResponse) {
        authService.signin(signinRequest, httpResponse);
        return ResponseEntity.ok("로그인이 완료되었습니다.");
    }
}
