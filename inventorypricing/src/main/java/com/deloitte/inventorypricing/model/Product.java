package com.deloitte.inventorypricing.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer productId;

    @Column(name = "NAME")
    private String productName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "BARCODE")
    private String barcode;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "MINQUANTITY")
    private Double minquantity;

}
