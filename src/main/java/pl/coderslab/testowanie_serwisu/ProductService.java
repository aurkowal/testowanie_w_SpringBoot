package pl.coderslab.testowanie_serwisu;

import pl.coderslab.testowanie_repozytorium.Product;

import java.util.List;

public interface ProductService {
    Product findByName(String name);
    Product addProduct(Product product);
    Product editProduct(Long id, Product product);
    void  deleteProduct(Long id);
    List<Product> listAllProducts();
    Product findById(Long id);

}
