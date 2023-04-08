package com.example.E_ADMIN.Service;
import com.example.E_ADMIN.Entite.Products;
import java.util.List;
import java.util.Optional;

public interface ProductsService {
    Products ajouterProducts(Products product);
    Products modifierProducts(Products product );
    List<Products> lstProducts();
    Optional<Products> getProductsById(Long id);
    void supprimerProducts(Long id);
}



