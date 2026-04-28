package pl.coderslab.testowanie_serwisu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.coderslab.testowanie_repozytorium.Product;
import pl.coderslab.testowanie_repozytorium.ProductRepository;
import pl.coderslab.testowanie_repozytorium.StudentRepository;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    private ProductService service;
    private ProductRepository repository;

    @BeforeEach
    public void setUp() {
        repository = mock(ProductRepository.class);
        service = new ProductServiceImpl(repository);
    }

    @Test
    public void getAllProductsTest() {
        Product product1 = new Product("apple", "abc", true);
        Product product2 = new Product("orange", "abc", true);

        when(repository.findAll()).thenReturn(List.of(product1,product2));
        List<Product> products = service.listAllProducts();
        assertEquals(products, List.of(product1, product2));
    }

    @Test
    public void findByNameTest() {
        Product product1 = new Product("apple", "abc", true);

        when(repository.findByName("apple")).thenReturn(product1);
        Product result = service.findByName("apple");
        assertEquals(product1, result);
    }

    @Test
    public void addProductTest() {
        Product product1 = new Product("apple", "abc", true);

        when(repository.save(product1)).thenAnswer(args -> {
            Product prod = args.getArgument(0);
            prod.setId(1L);
            return prod;
        });
        Product result = service.addProduct(product1);
        assertEquals(result, product1);
    }

    @Test
    public void editProductTest() {
        Product product1 = new Product("apple", "abc", true);
        product1.setId(1L);

        when(repository.save(product1)).thenReturn(product1);
        Product update = service.editProduct(1L, product1);

        assertThat(update.getName()).isEqualTo(product1.getName());
    }

    @Test
    public void deleteProductTest() {
        Product product1 = new Product("apple", "abc", true);
        Product product2 = new Product("orange", "abc", true);
        product1.setId(1L);
        doNothing().when(repository).deleteById(1L);
        List<Product> products = repository.findAll();
        assertEquals(products, List.of());
        assertDoesNotThrow(() -> service.deleteProduct(1L));

    }


}