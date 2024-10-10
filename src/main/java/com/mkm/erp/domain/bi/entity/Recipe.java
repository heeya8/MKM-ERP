package com.mkm.erp.domain.bi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Recipe")  // 명확하게 테이블 이름을 설정
@Setter
@Getter
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // BOM과의 다대일 관계 설정
    @ManyToOne
    @JoinColumn(name = "bom_id", nullable = false)
    private BOM bom;

    @Column(name = "child_id", nullable = false)
    private String childId; // 자품목 ID

    @Column(name = "quantity", nullable = false)
    private int quantity; // 필요 수량

    public Recipe(BOM bom, String childId, int quantity) {
        this.bom = bom;
        this.childId = childId;
        this.quantity = quantity;
    }
}
