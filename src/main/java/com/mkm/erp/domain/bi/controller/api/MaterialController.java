package com.mkm.erp.domain.bi.controller.api;

import com.mkm.erp.domain.bi.dto.request.MaterialRequest;
import com.mkm.erp.domain.bi.dto.response.MaterialResponse;
import com.mkm.erp.domain.bi.dto.response.ResponseDto;
import com.mkm.erp.domain.bi.entity.Material;
import com.mkm.erp.domain.bi.repository.MaterialRepository;
import com.mkm.erp.domain.bi.service.MaterialService;
import com.mkm.erp.domain.common.annotation.Auth;
import com.mkm.erp.domain.common.dto.AuthUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/information")
public class MaterialController {

    private final MaterialService materialService;
    private final MaterialRepository materialRepository;

    @GetMapping("/materials")
    public ResponseEntity<ResponseDto<MaterialResponse>> getMaterials(
            @Auth AuthUser authUser,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String unitType,
            @RequestParam(required = false) String materialName) {
        return ResponseEntity.ok(materialService.getMaterials(page, size, sortBy, unitType, materialName));
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

    @GetMapping("/materials/materialId")
    public ResponseEntity<Map<String, Long>> getMaterialIdByName(@RequestParam String materialName) {
        Long materialId = materialRepository.findByName(materialName)
                .map(Material::getId) // Optional에서 ID를 추출
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 원자재 이름: " + materialName)); // 이름이 없을 경우 예외 처리
        return ResponseEntity.ok(Collections.singletonMap("id", materialId)); // { id: <productId> } 형태로 응답
    }
}