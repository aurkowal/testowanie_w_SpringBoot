package pl.coderslab.testowanie_serwisu;

import org.springframework.stereotype.Service;
import pl.coderslab.testowanie_repozytorium.Student;
import pl.coderslab.testowanie_repozytorium.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> listAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student findByFirstName(String firstName) {
        return repository.findOneByFirstName(firstName);
    }

    @Override
    public Student addStudent(Student student) {
        return repository.save(student);
    }


}
