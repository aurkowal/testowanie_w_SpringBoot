package pl.coderslab.testowanie_repozytorium;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void find_by_first_name_then_return_student() {
        // given
        Student student = new Student();
        student.setFirstName("John");
        entityManager.persist(student);
        // when
        Student result = studentRepository.findOneByFirstName("John");
        // then
        assertEquals(student.getFirstName(), result.getFirstName());
    }

    @Test
    public void given_mark_then_john_should_be_null() {
        // given
        Student student = new Student();
        student.setFirstName("Mark");
        entityManager.persist(student);
        // when
        Student result = studentRepository.findOneByFirstName("John");
        // then
        assertNull(result);
    }

    @Test
    public void find_by_some_letters_then_return_student() {
        // given
        Student jo = entityManager.persistAndFlush(new Student("jo","abc"));
        Student john = entityManager.persistAndFlush(new Student("john", "xyz"));
        // when
        List<Student> result = studentRepository.findBySome("jo");
        // then
        assertTrue(result.contains(jo));
        assertTrue(result.contains(john));

    }


}