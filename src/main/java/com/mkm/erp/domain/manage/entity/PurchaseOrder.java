package com.mkm.erp.domain.manage.entity;

import com.mkm.erp.domain.common.entity.Timestamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "purchase_order")
@Getter
@Setter
@NoArgsConstructor
public class PurchaseOrder extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "material_code", nullable = false)
    private String materialName;

    @Column(name = "order_quantity", nullable = false)
    private int orderQuantity;

    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;

    public PurchaseOrder(String materialCode, int orderQuantity, LocalDate orderDate) {
        this.materialName = materialName;
        this.orderQuantity = orderQuantity;
        this.orderDate = orderDate;
    }
}
