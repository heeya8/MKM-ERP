package com.mkm.erp.domain.bi.entity;

import com.mkm.erp.domain.common.entity.Timestamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "BOM")  // 명확하게 테이블 이름을 설정
@Setter
@Getter
@NoArgsConstructor
public class BOM extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Product와의 일대일 관계 설정 및 외래 키 명시
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product product;

    // Recipe(자품목)와의 일대다 관계 설정
    @OneToMany(mappedBy = "bom", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recipe> recipes;

    public BOM(Product product) {
        this.product = product;
    }
}
