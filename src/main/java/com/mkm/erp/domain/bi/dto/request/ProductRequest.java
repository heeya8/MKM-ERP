// ProductRequest.java
package com.mkm.erp.domain.bi.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ProductRequest {

    @NotBlank(message = "품목명은 필수 입력 항목입니다.")
    @Size(max = 50, message = "품목명은 50자 이내여야 합니다.")
    private String name;

    @Min(value = 0, message = "수량은 0 이상이어야 합니다.")
    private int quantity;

    @NotNull(message = "단위는 필수 입력 항목입니다.")
    private String unit;

    @NotBlank(message = "소분류 이름은 필수 입력 항목입니다.")
    private String subcategoryName;  // 소분류 이름 추가
}
