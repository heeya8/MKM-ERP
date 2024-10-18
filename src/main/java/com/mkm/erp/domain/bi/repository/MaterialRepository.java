package com.mkm.erp.domain.bi.repository;

import com.mkm.erp.domain.bi.entity.Material;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MaterialRepository extends JpaRepository<Material, String> {
    Page<Material> findAllByIdOrderByModifiedAtDesc(Long id, Pageable pageable);
    Optional<Material> findById(Long id);
    // 가장 큰 품목코드 값을 찾는 메서드
    @Query("SELECT MAX(m.itemCode) FROM Material m WHERE m.itemCode LIKE 'M%'")
    String findMaxItemCode();

    Optional<Material> findByName(String name); // 자재 이름으로 조회하는 메서드 추가
}
