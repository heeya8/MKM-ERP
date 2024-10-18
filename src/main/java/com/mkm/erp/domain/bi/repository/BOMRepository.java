package com.mkm.erp.domain.bi.repository;

import com.mkm.erp.domain.bi.entity.BOM;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BOMRepository extends JpaRepository<BOM, Long> { // Long 타입으로 수정
    Optional<BOM> findById(Long id); // Long 타입으로 유지
    Optional<BOM> findByProductId(Long productId);
}
