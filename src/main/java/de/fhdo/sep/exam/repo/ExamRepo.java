package de.fhdo.sep.exam.repo;

import de.fhdo.sep.exam.domain.Exam;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepo extends MongoRepository<Exam, String> {
}
