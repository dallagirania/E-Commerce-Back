package com.example.E_ADMIN.RestController;
import com.example.E_ADMIN.Entite.Products;
import com.example.E_ADMIN.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/products")

public class ProductsRestController {
    @Autowired
    ProductsService productsService;

    @RequestMapping(method = RequestMethod.POST)
    public Products ajouterproducts(@RequestBody Products contact){
        return productsService.ajouterProducts(contact);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Products modifierproducts(@PathVariable("id")Long id, @RequestBody Products contact){
        Products newProducts=productsService.modifierProducts(contact);
        return newProducts;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void supprimerproducts(@PathVariable("id")Long id){
        productsService.supprimerProducts(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Optional<Products> getproductsById(@PathVariable("id")Long id){
        Optional<Products>Product=productsService.getProductsById(id);
        return Product;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Products> lstproducts(){
        return productsService.lstProducts();
    }
}

