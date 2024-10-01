package com.mkm.erp.bi.repository;

import com.mkm.erp.bi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
