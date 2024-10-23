package com.mkm.erp.domain.auth.controller.api;

import com.mkm.erp.domain.auth.dto.request.SigninRequest;
import com.mkm.erp.domain.auth.dto.request.SignupRequest;
import com.mkm.erp.domain.auth.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth") // 공통 경로 설정
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest signupRequest, HttpServletResponse servletResponse) {
        authService.signup(signupRequest, servletResponse); // 회원가입 처리
        return ResponseEntity.ok("회원가입이 완료되었습니다."); // 성공 메시지 반환
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signin(@RequestBody SigninRequest signinRequest, HttpServletResponse httpResponse) {
        authService.signin(signinRequest, httpResponse); // 로그인 처리
        return ResponseEntity.ok("로그인이 완료되었습니다.");
    }
}