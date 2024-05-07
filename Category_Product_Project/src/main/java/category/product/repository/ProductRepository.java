package category.product.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import category.product.entityClasses.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
