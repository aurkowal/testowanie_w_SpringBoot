package pl.coderslab.testowanie_repozytorium;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);

    @Query("select p from Product p where p.available = true")
    List<Product> findAllByAvailable();

}
