package ro.fasttrack.tema12exerc1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrack.tema12exerc1.model.StudentEntity;

public interface StudentRepository extends MongoRepository<StudentEntity, String>
{

}
