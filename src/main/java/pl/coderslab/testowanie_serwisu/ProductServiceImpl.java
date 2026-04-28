package pl.coderslab.testowanie_serwisu;

import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.coderslab.testowanie_repozytorium.Product;
import pl.coderslab.testowanie_repozytorium.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product editProduct(Long id, Product product) {
        Assert.isTrue(id.equals(product.getId()), "Ids have to be the same");
        return productRepository.save(product);

    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }
}
