package com.mkm.erp.bi.controller;

import com.mkm.erp.bi.entity.Product;
import com.mkm.erp.bi.entity.Materials;
import com.mkm.erp.bi.service.InformationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/information")
public class InformationController {

    @Autowired
    private InformationService informationService;

    // 생산품
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return informationService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Optional<Product> product = informationService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return informationService.saveProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        informationService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    // 원자재
    @GetMapping("/materials")
    public List<Materials> getAllMaterials() {
        return informationService.getAllMaterials();
    }

    @GetMapping("/materials/{id}")
    public ResponseEntity<Materials> getMaterialById(@PathVariable String id) {
        Optional<Materials> material = informationService.getMaterialById(id);
        return material.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/materials")
    public Materials createMaterial(@RequestBody Materials material) {
        return informationService.saveMaterial(material);
    }

    @DeleteMapping("/materials/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable String id) {
        informationService.deleteMaterial(id);
        return ResponseEntity.noContent().build();
    }
}
