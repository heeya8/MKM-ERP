package com.mkm.erp.domain.bi.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
public class BOMRequest {
    private Long productId; // 모품목 ID
    private List<RecipeRequest> recipes; // 레시피 리스트

    @Getter
    @Setter
    @NoArgsConstructor
    public static class RecipeRequest {
        private String childId; // 자품목 ID
        private int quantity; // 필요 수량
    }
}
