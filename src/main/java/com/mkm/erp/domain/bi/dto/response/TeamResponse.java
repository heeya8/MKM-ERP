package com.mkm.erp.domain.bi.dto.response;

import com.mkm.erp.domain.bi.entity.Team.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TeamResponse {
    private Long id;
    private String name;
    private String lead;
    private Status active;
    private LocalDateTime createdAt;
}
