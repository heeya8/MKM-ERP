package com.mkm.erp.domain.bi.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BOMResponse {
    private Long id; // BOM ID
    private Long productId; // 모품목 ID
    private List<RecipeResponse> recipes; // 레시피 리스트

    @Getter
    @Setter
    @NoArgsConstructor
    public static class RecipeResponse {
        private Long id; // 레시피 ID
        private String childId; // 자품목 이름
        private int quantity; // 필요 수량
    }
}
