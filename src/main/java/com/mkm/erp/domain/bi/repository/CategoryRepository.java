package com.mkm.erp.domain.bi.repository;

import com.mkm.erp.domain.bi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // 대분류 이름으로 대분류 엔티티를 찾는 메서드
    Optional<Category> findByName(String name);
}
