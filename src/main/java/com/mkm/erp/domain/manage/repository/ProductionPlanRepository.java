package com.mkm.erp.domain.manage.repository;

import com.mkm.erp.domain.manage.entity.ProductionPlan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductionPlanRepository extends JpaRepository<ProductionPlan, Long> {
    Page<ProductionPlan> findAllByIdOrderByModifiedAtDesc(Long id, Pageable pageable);
    Optional<ProductionPlan> findById(Long id);
    @Query("SELECT pp FROM ProductionPlan pp JOIN pp.product p WHERE p.name LIKE %:name%")
    Page<ProductionPlan> findByProductNameContaining(@Param("name") String name, Pageable pageable);
}
