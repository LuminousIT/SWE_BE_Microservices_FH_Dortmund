package de.fhdo.sep.exam.service;

import de.fhdo.sep.exam.client.ExamFeignClient;
import de.fhdo.sep.exam.domain.Exam;
import de.fhdo.sep.exam.repo.ExamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {
    private final ExamRepo examRepo;
    private final ExamFeignClient examFeignClient;

    @Autowired
    public ExamService(ExamRepo examRepo, ExamFeignClient examFeignClient) {
        this.examRepo = examRepo;
        this.examFeignClient = examFeignClient;
    }

    public Exam createExam(Exam exam) {
        return examRepo.save(exam);
    }

    public List<Exam> readAllExams() {
        return examRepo.findAll();
    }

    public List<String> getStudentNamesForExam(String examName) {
        return examFeignClient.getStudentNamesForExam(examName);
    }
}
