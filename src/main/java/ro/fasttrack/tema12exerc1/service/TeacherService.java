package ro.fasttrack.tema12exerc1.service;

import org.springframework.stereotype.Service;
import ro.fasttrack.tema12exerc1.model.TeacherEntity;
import ro.fasttrack.tema12exerc1.repository.TeacherRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService
{
    private final TeacherRepository repo;

    public TeacherService(TeacherRepository repo)
    {
        this.repo = repo;
    }

    public List<TeacherEntity> getAll() { return repo.findAll(); }

    public Optional<TeacherEntity> getById(String id) { return repo.findById(id); }

    public Optional<TeacherEntity> add(TeacherEntity teacher) { return Optional.of(repo.save(teacher)); }

    public Optional<TeacherEntity> delete(String id)
    {
        Optional<TeacherEntity> optTeacher = repo.findById(id);
        if(optTeacher.isPresent())
            repo.delete(optTeacher.get());
        return optTeacher;
    }
}
