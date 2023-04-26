package de.fhdo.sep.student.rest.api;

import de.fhdo.sep.student.domain.Student;
import de.fhdo.sep.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/resources")
public class StudentRestApi {
    private final StudentService studentService;

    @Autowired
    public StudentRestApi(StudentService studentService) {
        this.studentService = studentService;
    }

    @PutMapping("/student")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/students")
    public List<Student> readAllStudents() {
        return studentService.readAllStudents();
    }

    @GetMapping("/students/{exam}")
    public List<String> getStudentsForExam(@PathVariable String exam) {
        return studentService.readAllStudents().stream()
                .filter(v -> v.getExams().contains(exam)).map(Student::getName).collect(Collectors.toList());
    }
}
