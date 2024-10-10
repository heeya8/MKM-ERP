package com.mkm.erp.domain.bi.repository;

import com.mkm.erp.domain.bi.entity.BOM;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BOMRepository extends JpaRepository<BOM, String> {
    Page<BOM> findAllByIdOrderByModifiedAtDesc(Long id, Pageable pageable);
    Optional<BOM> findById(Long id);
}
