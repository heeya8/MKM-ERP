package com.mkm.erp.domain.bi.controller.api;

import com.mkm.erp.domain.bi.dto.request.MaterialRequest;
import com.mkm.erp.domain.bi.dto.response.MaterialResponse;
import com.mkm.erp.domain.bi.dto.response.ResponseDto;
import com.mkm.erp.domain.bi.service.MaterialService;
import com.mkm.erp.domain.common.annotation.Auth;
import com.mkm.erp.domain.common.dto.AuthUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/information")
public class MaterialController {

    private final MaterialService materialService;

    @GetMapping("/materials")
    public ResponseEntity<ResponseDto<MaterialResponse>> getMaterials(
            @Auth AuthUser authUser,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String unitType) {
        return ResponseEntity.ok(materialService.getMaterials(page, size, sortBy, unitType));
    }

    @PostMapping("/materials")
    public ResponseEntity<String> createMaterial(@Auth AuthUser authUser, @RequestBody MaterialRequest request) {
        materialService.createMaterial(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("자재가 생성되었습니다.");
    }

    @PatchMapping("/materials/{id}")
    public ResponseEntity<Void> updateMaterial(@Auth AuthUser authUser, @PathVariable Long id, @RequestBody MaterialRequest request) {
        materialService.updateMaterial(id, request);
        return ResponseEntity.ok().build(); // 200 OK 반환
    }

    @DeleteMapping("/materials/{id}")
    public ResponseEntity<Void> deleteMaterial(@Auth AuthUser authUser, @PathVariable Long id) {
        materialService.deleteMaterial(id);
        return ResponseEntity.noContent().build();
    }
}