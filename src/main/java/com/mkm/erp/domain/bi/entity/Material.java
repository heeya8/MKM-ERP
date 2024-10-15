package com.mkm.erp.domain.bi.entity;

import com.mkm.erp.domain.bi.dto.request.MaterialRequest;
import com.mkm.erp.domain.common.entity.Timestamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "material")  // 명확하게 테이블 이름을 설정
@Setter
@Getter
@NoArgsConstructor
public class Material extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_code", unique = true, nullable = false)
    private String itemCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "unit", nullable = false)
    private UnitType unit;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "quantity")
    private int quantity = 0;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subcategory_id", nullable = false)
    private Subcategory subcategory; // 소분류와의 관계

    public Material(MaterialRequest request, Subcategory subcategory) {
        this.unit = UnitType.valueOf(request.getUnit());
        this.name = request.getName();
        this.quantity = request.getQuantity();
        this.subcategory = subcategory; // 소분류와 연결
    }

    public enum UnitType {
        G, KG, ML, L, EA, PACK, BAG, BOX
    }
}
