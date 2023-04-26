package de.fhdo.sep.exam.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "StudentService")
public interface ExamFeignClient {
    @GetMapping("/resources/students/{exam}")
    List<String> getStudentNamesForExam(@PathVariable("exam") String exam);
}
