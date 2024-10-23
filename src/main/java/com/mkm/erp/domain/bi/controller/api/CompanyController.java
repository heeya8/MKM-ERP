package com.mkm.erp.domain.bi.controller;

import com.mkm.erp.domain.bi.dto.request.CompanyRequest;
import com.mkm.erp.domain.bi.dto.response.CompanyResponse;
import com.mkm.erp.domain.bi.dto.response.ResponseDto;
import com.mkm.erp.domain.bi.service.CompanyService;
import com.mkm.erp.domain.common.annotation.Auth;
import com.mkm.erp.domain.common.dto.AuthUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/information")
public class CompanyController {

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


    @GetMapping("/companies")
    public ResponseEntity<ResponseDto<CompanyResponse>> getCompanies(
            @Auth AuthUser authUser,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(companyService.getCompanies(page, size));
    }

    @PostMapping("/companies")
    public ResponseEntity<String> createCompany(@Auth AuthUser authUser, @RequestBody CompanyRequest request) {
        companyService.createCompany(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("회사가 등록되었습니다.");
    }

    @PatchMapping("/companies/{id}")
    public ResponseEntity<Void> updateCompany(@Auth AuthUser authUser, @PathVariable Long id, @RequestBody CompanyRequest request) {
        companyService.updateCompany(id, request);
        return ResponseEntity.ok().build(); // 200 OK 반환
    }

    @DeleteMapping("/companies/{id}")
    public ResponseEntity<Void> deleteCompany(@Auth AuthUser authUser, @PathVariable Long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }
}
