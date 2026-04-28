package pl.coderslab.testowanie_serwisu;

import pl.coderslab.testowanie_repozytorium.Student;

import java.util.List;

public interface StudentService {

    List<Student> listAllStudents();

    Student findByFirstName(String firstName);

    Student addStudent(Student student);

}
