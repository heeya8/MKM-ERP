package com.mkm.erp.domain.bi.entity;

import com.mkm.erp.domain.bi.dto.request.ProductRequest;
import com.mkm.erp.domain.common.entity.Timestamped;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product extends Timestamped {

    // Primary Key로 설정된 품목코드
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

    // 단위에 대한 Enum 정의
    public enum UnitType {
        // 무게 단위
        G,
        KG,
        // 부피 단위
        ML,
        L,        // l (리터)

        // 개수 단위
        EA,       // 개 (개별 포장된 원자재나 제품)
        PACK,     // 팩 (포장 단위)
        BAG,      // 봉지 (밀봉 포장된 상품)
        BOX,      // 상자 (대량 포장 단위)
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subcategory_id", nullable = false)
    private Subcategory subcategory; // 소분류와의 관계

    public Product(ProductRequest request) {
        this.unit = UnitType.valueOf(request.getUnit());
        this.name = request.getName();
        this.quantity = request.getQuantity();
    }
}
