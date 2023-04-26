package com.productapp.country.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.boot.context.properties.bind.Name;

import lombok.Builder;
import lombok.Data;


@Entity
@Table(name = "export_product")
@Data
@Builder
public class ExportProduct {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "export_product_id")
    Integer id;

    String product;

    String country;

    String status;

    @PrePersist
    private void beforeAdd(){
        this.setStatus("ACT");
    }
    
}
