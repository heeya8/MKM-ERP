package com.mkm.erp.domain.auth.controller.view;

import com.mkm.erp.domain.bi.dto.response.CompanyResponse;
import com.mkm.erp.domain.bi.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/information")
public class CompanyViewController {

    private final CompanyService companyService;

    @GetMapping("/company")
    public String loadCompanyPage(Model model) {
        CompanyResponse company = companyService.getCompany();
        model.addAttribute("name", company.getName());
        model.addAttribute("owner", company.getOwner());
        model.addAttribute("businessNum", company.getBusinessNum());
        model.addAttribute("email", company.getEmail());
        model.addAttribute("phone", company.getPhone());
        model.addAttribute("address", company.getAddress());
        return "company";
    }
}
