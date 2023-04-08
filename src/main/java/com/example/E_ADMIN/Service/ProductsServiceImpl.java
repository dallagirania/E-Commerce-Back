package com.example.E_ADMIN.Service;
import com.example.E_ADMIN.Entite.Products;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import com.example.E_ADMIN.Repository.ProductsRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    ProductsRepository prodRrpository;

    @Override
    public Products ajouterProducts(Products prod) {
        return prodRrpository.save(prod);
    }

    @Override
    public Products modifierProducts(Products prod) {
        return prodRrpository.save(prod);
    }

    @Override
    public List<Products> lstProducts() {
        return prodRrpository.findAll();
    }

    @Override
    public Optional<Products> getProductsById(Long id) {
        return prodRrpository.findById(id);
    }

    @Override
    public void supprimerProducts(Long id) {
        prodRrpository.deleteById(id);

    }
}
