package com.mkm.erp.domain.bi.repository;

import com.mkm.erp.domain.bi.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {
    Page<Product> findAllByIdOrderByModifiedAtDesc(Long id, Pageable pageable);
    Optional<Product> findById(Long id);
    // 가장 큰 품목코드 값을 찾는 메서드
    @Query("SELECT MAX(p.itemCode) FROM Product p WHERE p.itemCode LIKE 'P%'")
    String findMaxItemCode();
}
