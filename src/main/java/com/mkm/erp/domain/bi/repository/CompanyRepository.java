package com.mkm.erp.domain.bi.repository;

import com.mkm.erp.domain.bi.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, String> {
    Page<Company> findAllByIdOrderByModifiedAtDesc(Long id, Pageable pageable);
    Optional<Company> findById(Long id);
}
