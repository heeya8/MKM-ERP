package com.mkm.erp.domain.bi.repository;

import com.mkm.erp.domain.bi.entity.Material;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MaterialRepository extends JpaRepository<Material, String> {
    Page<Material> findAllByIdOrderByModifiedAtDesc(Long id, Pageable pageable);
    Optional<Material> findById(Long id);
}
