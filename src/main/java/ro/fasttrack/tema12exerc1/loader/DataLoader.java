package ro.fasttrack.tema12exerc1.loader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ro.fasttrack.tema12exerc1.model.StudentEntity;
import ro.fasttrack.tema12exerc1.model.TeacherEntity;
import ro.fasttrack.tema12exerc1.repository.*;

import static java.util.UUID.randomUUID;

@Component
public class DataLoader implements CommandLineRunner
{
    private final TeacherRepository teacherRepo;
    private final StudentRepository studentRepo;

    public DataLoader(TeacherRepository teacherRepo, StudentRepository studentRepo)
    {
        this.teacherRepo = teacherRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public void run(String... args) throws Exception
    {
        TeacherEntity teacher1 = new TeacherEntity(randomUUID().toString(), "George Filip", "Matematica", "Matematica", true);
        teacherRepo.save(teacher1);

        TeacherEntity teacher2 = new TeacherEntity(randomUUID().toString(), "Andrei Balea", "Informatica", "Java", false);
        teacherRepo.save(teacher2);

        TeacherEntity teacher3 = new TeacherEntity(randomUUID().toString(), "Vasile Baciut", "Limbi straine", "Engleza", false);
        teacherRepo.save(teacher3);

        StudentEntity student1 = new StudentEntity(randomUUID().toString(), "Andreea Danca", "Matematica");
        studentRepo.save(student1);

        StudentEntity student2 = new StudentEntity(randomUUID().toString(), "Valentina Dica", "Java");
        studentRepo.save(student2);

        StudentEntity student3 = new StudentEntity(randomUUID().toString(), "Alex Deleanu", "Java");
        studentRepo.save(student3);

        StudentEntity student4 = new StudentEntity(randomUUID().toString(), "Radu Elciu", "Engleza");
        studentRepo.save(student4);

        StudentEntity student5 = new StudentEntity(randomUUID().toString(), "Valentina Dica", "Java");
        studentRepo.save(student5);

        StudentEntity student6 = new StudentEntity(randomUUID().toString(), "Ana Deleanu", "Java");
        studentRepo.save(student6);

        StudentEntity student7 = new StudentEntity(randomUUID().toString(), "Mihai Erbasu", "Engleza");
        studentRepo.save(student7);

        StudentEntity student8 = new StudentEntity(randomUUID().toString(), "Ioana Filea", "Matematica");
        studentRepo.save(student8);

        StudentEntity student9 = new StudentEntity(randomUUID().toString(), "Olivia Ionascu", "Engleza");
        studentRepo.save(student9);

        StudentEntity student10 = new StudentEntity(randomUUID().toString(), "Mircea Joldea", "Matematica");
        studentRepo.save(student10);
    }
}
