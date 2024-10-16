package com.mkm.erp.domain.bi.entity;

import com.mkm.erp.domain.bi.dto.request.ProductRequest;
import com.mkm.erp.domain.common.entity.Timestamped;
import com.mkm.erp.domain.manage.entity.ProductionPlan;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product extends Timestamped {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "item_code", unique = true, nullable = false)
    private String itemCode;

    // 단위 필드, Enum으로 지정
    @Enumerated(EnumType.STRING)
    @Column(name = "unit", nullable = false)
    private UnitType unit;

    // 품목명 필드
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    // 수량 필드
    @Column(name = "quantity")
    private int quantity = 0;

    // BOM과의 양방향 관계 설정
    @OneToOne(mappedBy = "product")  // BOM 엔티티의 product 필드와 연결
    private BOM bom;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subcategory_id", nullable = false)
    private Subcategory subcategory; // 소분류와의 관계

    // ProductionPlan과의 관계 추가
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductionPlan> productionPlans;

    public Product(ProductRequest request) {
        this.unit = UnitType.valueOf(request.getUnit());
        this.name = request.getName();
        this.quantity = request.getQuantity();
    }
}
