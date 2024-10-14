package com.mkm.erp.domain.bi.repository;

import com.mkm.erp.domain.bi.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
    // 소분류 이름으로 소분류 엔티티를 찾는 메서드
    Optional<Subcategory> findByName(String name);
}
