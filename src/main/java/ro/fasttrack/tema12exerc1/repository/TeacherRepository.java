package ro.fasttrack.tema12exerc1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrack.tema12exerc1.model.TeacherEntity;

public interface TeacherRepository extends MongoRepository<TeacherEntity, String>
{

}
