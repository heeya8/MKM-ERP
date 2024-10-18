package com.mkm.erp.domain.manage.repository;

import com.mkm.erp.domain.bi.entity.Product;
import com.mkm.erp.domain.manage.entity.ProductionPlan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductionPlanRepository extends JpaRepository<ProductionPlan, Long> {
    Page<ProductionPlan> findAllByIdOrderByModifiedAtDesc(Long id, Pageable pageable);
    Optional<ProductionPlan> findById(Long id);
}
