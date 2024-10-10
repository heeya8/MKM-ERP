package com.mkm.erp.domain.bi.service;

import com.mkm.erp.domain.bi.dto.request.CompanyRequest;
import com.mkm.erp.domain.bi.dto.response.CompanyResponse;
import com.mkm.erp.domain.bi.dto.response.ResponseDto;
import com.mkm.erp.domain.bi.entity.Company;
import com.mkm.erp.domain.bi.exception.ResourceNotFoundException;
import com.mkm.erp.domain.bi.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    // 조회
    public ResponseDto<CompanyResponse> getCompanies(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size); // 페이지 인덱스는 0부터 시작하므로 -1
        Page<Company> companiesPage = companyRepository.findAll(pageable);

        return new ResponseDto<>(
                companiesPage.getContent().stream()
                        .map(company -> new CompanyResponse(
                                company.getId(),
                                company.getName(),
                                company.getAddress(),
                                company.getEmail(),
                                company.getBusiness_num()
                        ))
                        .collect(Collectors.toList()),  // content 변환
                companiesPage.getNumber() + 1,          // 현재 페이지 번호 (0-based에서 1-based로)
                companiesPage.getSize(),                // 페이지 크기
                companiesPage.getTotalElements(),       // 전체 요소 수
                companiesPage.getTotalPages(),          // 전체 페이지 수
                companiesPage.isLast()                  // 마지막 페이지 여부
        );
    }

    // 등록
    @Transactional
    public void createCompany(CompanyRequest request) {
        Company company = new Company(request);
        companyRepository.save(company);
    }

    // 수정
    @Transactional
    public void updateCompany(Long id, CompanyRequest request) {
        Optional<Company> existingCompany = companyRepository.findById(id);
        if (existingCompany.isPresent()) {
            Company company = existingCompany.get();
            company.setName(request.getName());
            company.setAddress(request.getAddress());
            company.setEmail(request.getEmail());
            company.setBusiness_num(request.getBusiness_num());

            companyRepository.save(company);
        } else {
            throw new ResourceNotFoundException("회사를 찾을 수 없습니다. ID: " + id);
        }
    }

    // 삭제
    @Transactional
    public void deleteCompany(Long id) {
        // 기존 자재가 존재하는지 확인 후 삭제
        if (companyRepository.existsById(String.valueOf(id))) {
            companyRepository.deleteById(String.valueOf(id));
        } else {
            throw new ResourceNotFoundException("회사를 찾을 수 없습니다. ID: " + id);
        }
    }
}
