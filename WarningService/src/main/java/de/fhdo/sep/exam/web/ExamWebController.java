package de.fhdo.sep.exam.web;

import de.fhdo.sep.exam.domain.Exam;
import de.fhdo.sep.exam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExamWebController {
    private final ExamService examService;

    @Autowired
    public ExamWebController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping("/")
    public String EntryPoint(Model model) {
        var exams = examService.readAllExams();
        model.addAttribute("exams", exams);
        var exam = new Exam();
        model.addAttribute("exam", exam);
        return "web";
    }

    @PostMapping("/addExam")
    public String addExam(@ModelAttribute Exam exam, Model model) {
        examService.createExam(exam);
        var exams = examService.readAllExams();
        model.addAttribute("exams", exams);
        return "web";
    }
}
