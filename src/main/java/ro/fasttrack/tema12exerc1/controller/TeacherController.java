package ro.fasttrack.tema12exerc1.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.fasttrack.tema12exerc1.model.TeacherEntity;
import ro.fasttrack.tema12exerc1.service.TeacherService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("teachers")
public class TeacherController
{
    private final TeacherService service;

    public TeacherController(TeacherService service) { this.service = service; }

    @GetMapping
    List<TeacherEntity> getAll() { return service.getAll(); }

    @GetMapping("{id}")
    TeacherEntity getById(@PathVariable String id)
    {
        Optional<TeacherEntity> optTeacher = service.getById(id);
        return optTeacher.orElse(null);
    }

    @PostMapping
    TeacherEntity add(@RequestBody TeacherEntity teacher)
    {
        Optional<TeacherEntity> optTeacher = service.add(teacher);
        return optTeacher.orElse(null);
    }

    @DeleteMapping("{id}")
    TeacherEntity delete(@PathVariable String id)
    {
        Optional<TeacherEntity> optTeacher = service.delete(id);
        return optTeacher.orElse(null);
    }
}
