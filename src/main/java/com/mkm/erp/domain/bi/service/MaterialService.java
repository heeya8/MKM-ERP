package com.mkm.erp.domain.bi.service;

import com.mkm.erp.domain.bi.dto.request.MaterialRequest;
import com.mkm.erp.domain.bi.dto.response.MaterialResponse;
import com.mkm.erp.domain.bi.dto.response.ResponseDto;
import com.mkm.erp.domain.bi.entity.Material;
import com.mkm.erp.domain.bi.exception.ResourceNotFoundException;
import com.mkm.erp.domain.bi.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MaterialService {

    private final MaterialRepository materialRepository;

    // 원자재 CRUD - 페이징 처리된 원자재 목록을 반환
    public ResponseDto<MaterialResponse> getMaterials(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size); // 페이지 인덱스는 0부터 시작하므로 -1
        Page<Material> materialsPage = materialRepository.findAll(pageable);

        return new ResponseDto<>(
                materialsPage.getContent().stream()
                        .map(material -> new MaterialResponse(
                                material.getId(),
                                material.getName(),
                                material.getQuantity(),
                                material.getUnit().toString()
                        ))
                        .collect(Collectors.toList()),  // content 변환
                materialsPage.getNumber() + 1,          // 현재 페이지 번호 (0-based에서 1-based로)
                materialsPage.getSize(),                // 페이지 크기
                materialsPage.getTotalElements(),       // 전체 요소 수
                materialsPage.getTotalPages(),          // 전체 페이지 수
                materialsPage.isLast()                  // 마지막 페이지 여부
        );
    }

    @Transactional
    public void createMaterial(MaterialRequest request) {
        Material material = new Material(request);
        materialRepository.save(material);
    }

    @Transactional
    public void updateMaterial(Long id, MaterialRequest request) {
        Optional<Material> existingMaterial = materialRepository.findById(id);
        if (existingMaterial.isPresent()) {
            Material material = existingMaterial.get();
            material.setName(request.getName());
            material.setQuantity(request.getQuantity());
            material.setUnit(Material.UnitType.valueOf(request.getUnit()));

            materialRepository.save(material);
        } else {
            throw new ResourceNotFoundException("자재를 찾을 수 없습니다. ID: " + id);
        }
    }

    @Transactional
    public void deleteMaterial(Long id) {
        // 기존 자재가 존재하는지 확인 후 삭제
        if (materialRepository.existsById(String.valueOf(id))) {
            materialRepository.deleteById(String.valueOf(id));
        } else {
            throw new ResourceNotFoundException("자재를 찾을 수 없습니다. ID: " + id);
        }
    }
}