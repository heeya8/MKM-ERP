package com.mkm.erp.domain.auth.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthViewController {

    @GetMapping("/auth/signup")
    public String signup(Model model) {
        return "signup";
    }
}
