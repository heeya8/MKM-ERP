package com.mkm.erp.domain.bi.dto.request;

import com.mkm.erp.domain.bi.entity.Team.Status;
import lombok.Data;

@Data
public class TeamRequest {
    private String name;
    private String lead;
    private Status active;  // ACTIVE or INACTIVE
}
