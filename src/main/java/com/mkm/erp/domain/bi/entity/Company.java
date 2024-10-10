package com.mkm.erp.domain.bi.entity;

import com.mkm.erp.domain.bi.dto.request.CompanyRequest;
import com.mkm.erp.domain.common.entity.Timestamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "company")  // 명확하게 테이블 이름을 설정
@Setter
@Getter
@NoArgsConstructor
public class Company extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column(name = "address", length = 50, nullable = false)
    private String address;
    @Column(name = "email", length = 50, nullable = false)
    private String email;
    @Column(name = "business_num", length = 50, nullable = false)
    private String business_num;

    public Company(CompanyRequest request) {
        this.name = request.getName();
        this.address = request.getAddress();
        this.email = request.getEmail();
        this.business_num = request.getBusiness_num();
    }
}
