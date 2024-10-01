package com.mkm.erp.bi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Materials {

    // Primary Key로 설정된 품목코드
    @Id
    @Column(name = "id", length = 50, nullable = false)
    private String id;

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
}
