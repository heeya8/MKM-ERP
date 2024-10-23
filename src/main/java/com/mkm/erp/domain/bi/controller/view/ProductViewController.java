package com.mkm.erp.domain.bi.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/information")
public class ProductViewController {

    @GetMapping("/product")
    public String loadProductPage(Model model) {
        return "product";
    }
}