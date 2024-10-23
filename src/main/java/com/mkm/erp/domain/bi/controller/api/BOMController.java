package com.mkm.erp.domain.bi.controller.api;

import com.mkm.erp.domain.bi.dto.request.BOMRequest; // BOMRequest DTO import
import com.mkm.erp.domain.bi.dto.response.BOMResponse; // BOMResponse DTO import
import com.mkm.erp.domain.bi.dto.response.ResponseDto;
import com.mkm.erp.domain.bi.service.BOMService; // BOMService import
import com.mkm.erp.domain.common.annotation.Auth;
import com.mkm.erp.domain.common.dto.AuthUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/information")
public class BOMController {

    private final BOMService bomService; // BOMService 주입

    @GetMapping("/boms")
    public ResponseEntity<ResponseDto<BOMResponse>> getBOMs(
            @Auth AuthUser authUser,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(bomService.getBOMs(page, size));
    }

    @PostMapping("/boms")
    public ResponseEntity<String> createBOM(@Auth AuthUser authUser, @RequestBody BOMRequest request) {
        bomService.createBOM(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("BOM이 생성되었습니다.");
    }

    @PatchMapping("/boms/{id}")
    public ResponseEntity<Void> updateBOM(@Auth AuthUser authUser, @PathVariable Long id, @RequestBody BOMRequest request) {
        bomService.updateBOM(id, request);
        return ResponseEntity.ok().build(); // 200 OK 반환
    }

    @DeleteMapping("/boms/{id}")
    public ResponseEntity<Void> deleteBOM(@Auth AuthUser authUser, @PathVariable Long id) {
        bomService.deleteBOM(id);
        return ResponseEntity.noContent().build();
    }
}
