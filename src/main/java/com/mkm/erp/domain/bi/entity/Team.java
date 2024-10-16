package com.mkm.erp.domain.bi.entity;

import com.mkm.erp.domain.bi.dto.request.TeamRequest;
import com.mkm.erp.domain.common.entity.Timestamped;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "team_name", nullable = false, unique = true)
    private String name;

    @Column(name = "team_lead", nullable = false)
    private String lead;

    @Enumerated(EnumType.STRING)
    @Column(name = "active_status", nullable = false)
    private Status active;

    public Team(TeamRequest request) {
        this.name = request.getName();
        this.lead = request.getLead();
        this.active = request.getActive();
    }

    public enum Status {
        ACTIVE, INACTIVE
    }
}
