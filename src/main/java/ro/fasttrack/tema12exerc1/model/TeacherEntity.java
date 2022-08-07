package ro.fasttrack.tema12exerc1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TeacherEntity
{
    @Id String id;
    String name;
    String specialisation;
    String assignedClass;
    Boolean isAdmin;

    public TeacherEntity() {}

    public TeacherEntity(String id, String name, String specialisation, String assignedClass, Boolean isAdmin)
    {
        this.id = id;
        this.name = name;
        this.specialisation = specialisation;
        this.assignedClass = assignedClass;
        this.isAdmin = isAdmin;
    }

    public String getId() { return this.id; }
    public String getName() { return this.name; }
    public String getSpecialisation() { return this.specialisation; }
    public String getAssignedClass() { return this.assignedClass; }
    public Boolean getIsAdmin() { return this.isAdmin; }
}
