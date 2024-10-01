package com.mkm.erp.bi.service;

import com.mkm.erp.bi.entity.Materials;
import com.mkm.erp.bi.entity.Product;
import com.mkm.erp.bi.repository.MaterialRepository;
import com.mkm.erp.bi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformationService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MaterialRepository materialRepository;

    // 생산품 CRUD
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    // 원자재 CRUD
    public List<Materials> getAllMaterials() {
        return materialRepository.findAll();
    }

    public Optional<Materials> getMaterialById(String id) {
        return materialRepository.findById(id);
    }

    public Materials saveMaterial(Materials material) {
        return materialRepository.save(material);
    }

    public void deleteMaterial(String id) {
        materialRepository.deleteById(id);
    }
}
