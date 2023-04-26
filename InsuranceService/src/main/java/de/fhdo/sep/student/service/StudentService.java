package de.fhdo.sep.student.service;

import de.fhdo.sep.student.domain.Student;
import de.fhdo.sep.student.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> readAllStudents() {
        return studentRepo.findAll();
    }


}
