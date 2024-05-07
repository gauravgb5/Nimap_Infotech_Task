package category.product.controllerClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import category.product.entityClasses.Product;
import category.product.serviceClasses.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProduct(@RequestParam int page)
    {
        return   productService.retrieveAllProduct(page);
    }

    @GetMapping("/products/{id}")
    public Optional<Product> getOneProduct(@PathVariable int id)
    {
        return  productService.retrieveOneProduct(id);
    }

    @PostMapping("/products")
    public Product savedProduct(@RequestBody Product product)
    {
        return productService.saveProduct(product);
    }
    @PutMapping("/products/{id}")
    public Product updatedProduct(@PathVariable int id,@RequestBody Product product)
    {
        return  productService.updateProduct(id,product);
    }

    @DeleteMapping("/products/{id}")
    public  void deletedProduct(@PathVariable int id)
    {
        productService.deleteProduct(id);
    }

}
