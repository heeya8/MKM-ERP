package com.mkm.erp.bi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Materials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
}
