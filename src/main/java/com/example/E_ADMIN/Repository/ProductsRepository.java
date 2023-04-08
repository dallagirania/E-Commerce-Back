package com.example.E_ADMIN.Repository;
import com.example.E_ADMIN.Entite.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductsRepository extends JpaRepository<Products,Long>{
}
