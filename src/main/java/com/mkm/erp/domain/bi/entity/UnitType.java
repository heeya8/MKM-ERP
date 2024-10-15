package com.mkm.erp.domain.bi.entity;

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