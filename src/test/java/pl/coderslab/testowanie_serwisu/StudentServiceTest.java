package pl.coderslab.testowanie_serwisu;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.coderslab.testowanie_repozytorium.Student;
import pl.coderslab.testowanie_repozytorium.StudentRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StudentServiceTest {

    private StudentService service;
    private StudentRepository repository;

    @BeforeEach
    public void setUp() {
        repository = mock(StudentRepository.class);
        service = new StudentServiceImpl(repository);
    }

    @Test
    public void when_searching_john_then_return_object() {
        // given
        Student john = new Student("John", "Snow");
        when(repository.findOneByFirstName("John")).thenReturn(john);
        // when
        Student student = service.findByFirstName("John");
        // then
        assertEquals("John", student.getFirstName());
    }

    @Test
    public void when_save_student_then_it_is_returned_correctly() {
        // given
        Student student = new Student("John", "Snow");
        when(repository.save(student)).thenReturn(student);
        // when
        Student result = service.addStudent(student);
        // then
        assertNotNull(result);
        assertEquals(student.getFirstName(), result.getFirstName());
    }

    @Test
    public void listAllStudentsTest() {
        // given
        Student student = new Student("John", "Snow");
        Student student1 = new Student("James", "Potter");

        when(repository.findAll()).thenReturn(List.of(student, student1));
        // when
        List<Student> result = repository.findAll();
        // then
        assertNotNull(result);
        assertEquals(result, List.of(student, student1));
    }





}
