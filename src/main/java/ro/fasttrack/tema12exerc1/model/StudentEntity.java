package ro.fasttrack.tema12exerc1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class StudentEntity
{
    @Id String id;
    String name;
    String attendingClass;

    public StudentEntity() {}

    public StudentEntity(String id, String name, String attendingClass)
    {
        this.id = id;
        this.name = name;
        this.attendingClass = attendingClass;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getAttendingClass() { return attendingClass; }

}
