package com.mkm.erp.domain.bi.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/information")
public class BOMViewController {

    @GetMapping("/bom/register")
    public String loadBomRegisterPage(Model model) {
        return "bomRegistration";
    }

    @GetMapping("/bom/inquiry")
    public String loadBomInquiryPage(Model model) {
        return "bomInquiry";
    }
}
