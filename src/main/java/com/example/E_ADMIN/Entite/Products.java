package com.example.E_ADMIN.Entite;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;


import javax.persistence.*;
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Lob
    private String image;
    private float price ;
    private String categorie;

    public String getCategorie() {
        return categorie;
    }

    public float getPrice() {
        return price;
    }

    private String product_detail;

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getProduct_detail() {
        return product_detail;
    }

    public Long getId() {
        return id;
    }

}

