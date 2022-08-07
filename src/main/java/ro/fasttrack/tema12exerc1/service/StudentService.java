package ro.fasttrack.tema12exerc1.service;

import org.springframework.stereotype.Service;
import ro.fasttrack.tema12exerc1.model.StudentEntity;
import ro.fasttrack.tema12exerc1.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService
{
    private final StudentRepository repo;

    public StudentService(StudentRepository repo)
    {
        this.repo = repo;
    }

    public List<StudentEntity> getAll() { return repo.findAll(); }

    public Optional<StudentEntity> getById(String id) { return repo.findById(id); }

    public Optional<StudentEntity> add(StudentEntity student) { return Optional.of(repo.save(student)); }

    public Optional<StudentEntity> delete(String id)
    {
        Optional<StudentEntity> optStudent = repo.findById(id);
        if(optStudent.isPresent())
            repo.delete(optStudent.get());
        return optStudent;
    }
}
