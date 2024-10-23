package com.mkm.erp.domain.manage.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage/work")
public class ProductionPlanViewController {

    @GetMapping("/plans")
    public String loadProductionPlanPage(Model model) {
        return "production_plan";
    }
}
