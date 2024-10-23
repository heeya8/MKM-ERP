package com.mkm.erp.domain.bi.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeamViewController {

    @GetMapping("/information/team")
    public String loadTeamPage(Model model) {
        return "productionTeamRegistration";
    }
}
