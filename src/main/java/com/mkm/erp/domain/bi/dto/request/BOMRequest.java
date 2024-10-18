package com.mkm.erp.domain.bi.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class BOMRequest {
    private Long productId; // 모품목 ID
    private List<RecipeRequest> recipes;

    @Getter
    @NoArgsConstructor
    public static class RecipeRequest {
        private String childId; // 자품목 ID로 변경
        private int quantity; // 필요 수량
    }
}
