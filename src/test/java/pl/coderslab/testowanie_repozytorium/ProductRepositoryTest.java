package pl.coderslab.testowanie_repozytorium;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void findByNameTest() {
        Product apple = new Product("apple", "jabłka", true);
        Product tomato = new Product("tomato", "pomidor", true);
        Product orange = new Product("orange", "pomarancza", false);
        entityManager.persist(apple);
        entityManager.persist(tomato);
        entityManager.persist(orange);

        Product result = productRepository.findByName("apple");
        assertEquals(result, apple);
    }

    @Test
    public void findAllByAvailableTest() {
        Product apple = new Product("apple", "jabłka", true);
        Product tomato = new Product("tomato", "pomidor", true);
        Product orange = new Product("orange", "pomarancza", false);
        entityManager.persist(apple);
        entityManager.persist(tomato);
        entityManager.persist(orange);

        List<Product> result = productRepository.findAllByAvailable();
        assertEquals(result, List.of(apple, tomato));
    }
}