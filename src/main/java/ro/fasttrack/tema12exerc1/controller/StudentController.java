package ro.fasttrack.tema12exerc1.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrack.tema12exerc1.model.StudentEntity;
import ro.fasttrack.tema12exerc1.service.StudentService;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("students")
public class StudentController
{
    private final StudentService service;

    public StudentController(StudentService service) { this.service = service; }

    @GetMapping
    List<StudentEntity> getAll() { return service.getAll(); }

    @GetMapping("{id}")
    StudentEntity getById(@PathVariable String id)
    {
        Optional<StudentEntity> optStudent = service.getById(id);
        return optStudent.orElse(null);
    }

    @PostMapping
    StudentEntity add(@RequestBody StudentEntity student)
    {
        Optional<StudentEntity> optStudent = service.add(student);
        return optStudent.orElse(null);
    }

    @DeleteMapping("{id}")
    StudentEntity delete(@PathVariable String id)
    {
        Optional<StudentEntity> optStudent = service.delete(id);
        return optStudent.orElse(null);
    }
}
