package com.mkm.erp.domain.common.controller;

import com.mkm.erp.domain.common.annotation.Auth;
import com.mkm.erp.domain.common.dto.AuthUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "signin";
    }

    @GetMapping("/main")
    public String main(@Auth AuthUser user, Model model) {
        // AuthUser의 이름을 모델에 추가
        model.addAttribute("userName", user.getName());
        return "index";
    }
}
