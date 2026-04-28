package pl.coderslab.testowanie_repozytorium;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findOneByFirstName(String firstName);

    @Query("select s from Student s where s.firstName like ?1%")
    List<Student> findBySome(String some);


}