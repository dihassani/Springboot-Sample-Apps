package com.demo.productrates.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int productId;

    @Column(name="NAME")
    private String productName;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name = "BARCODE")
    private String barcode;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "MINQUANTITY")
    private Double minquantity;
}
