package de.fhdo.sep.exam.service;

import de.fhdo.sep.exam.domain.Exam;
import de.fhdo.sep.exam.repo.ExamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {
    private final ExamRepo examRepo;

    @Autowired
    public ExamService(ExamRepo examRepo) {
        this.examRepo = examRepo;
    }

    public Exam createExam(Exam exam) {
        return examRepo.save(exam);
    }

    public List<Exam> readAllExams() {
        return examRepo.findAll();
    }
}
