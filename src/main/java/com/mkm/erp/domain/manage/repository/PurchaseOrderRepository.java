package com.mkm.erp.domain.manage.repository;

import com.mkm.erp.domain.manage.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
}
