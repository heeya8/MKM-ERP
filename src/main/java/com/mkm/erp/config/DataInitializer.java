package com.mkm.erp.config;

import com.mkm.erp.domain.bi.entity.Category;
import com.mkm.erp.domain.bi.entity.Subcategory;
import com.mkm.erp.domain.bi.repository.CategoryRepository;
import com.mkm.erp.domain.bi.repository.SubcategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    @Bean
    CommandLineRunner init(CategoryRepository categoryRepository, SubcategoryRepository subcategoryRepository) {
        return args -> {
            // 대분류 삽입
            Category product = categoryRepository.findByName("생산품")
                    .orElseGet(() -> categoryRepository.save(new Category(null, "생산품")));
            Category material = categoryRepository.findByName("원자재")
                    .orElseGet(() -> categoryRepository.save(new Category(null, "원자재")));

            // 생산품 소분류 삽입
            subcategoryRepository.findByName("한식").orElseGet(() -> subcategoryRepository.save(new Subcategory(null, product, "한식")));
            subcategoryRepository.findByName("중식").orElseGet(() -> subcategoryRepository.save(new Subcategory(null, product, "중식")));
            subcategoryRepository.findByName("일식").orElseGet(() -> subcategoryRepository.save(new Subcategory(null, product, "일식")));
            subcategoryRepository.findByName("양식").orElseGet(() -> subcategoryRepository.save(new Subcategory(null, product, "양식")));
            subcategoryRepository.findByName("기타").orElseGet(() -> subcategoryRepository.save(new Subcategory(null, product, "기타")));

            // 원자재 소분류 삽입
            subcategoryRepository.findByName("육류").orElseGet(() -> subcategoryRepository.save(new Subcategory(null, material, "육류")));
            subcategoryRepository.findByName("해산물").orElseGet(() -> subcategoryRepository.save(new Subcategory(null, material, "해산물")));
            subcategoryRepository.findByName("채소").orElseGet(() -> subcategoryRepository.save(new Subcategory(null, material, "채소")));
            subcategoryRepository.findByName("곡물").orElseGet(() -> subcategoryRepository.save(new Subcategory(null, material, "곡물")));
            subcategoryRepository.findByName("조미료").orElseGet(() -> subcategoryRepository.save(new Subcategory(null, material, "조미료")));
            subcategoryRepository.findByName("기타").orElseGet(() -> subcategoryRepository.save(new Subcategory(null, material, "기타")));
        };
    }
}
