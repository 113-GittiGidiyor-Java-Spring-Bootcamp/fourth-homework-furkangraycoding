package dev.patika.fourthhomework.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = dev.patika.fourthhomework.model.PermanentInstructor.class, name = "PermanentInstructor"),
        @JsonSubTypes.Type(value = dev.patika.fourthhomework.model.VisitingResearcher.class, name = "VisitingResearcher")
})
@Inheritance(strategy = InheritanceType.JOINED)
public class Instructor  extends  AbstractBaseEntity{

    private String name;
    private String address;
    private int phoneNumber;

    @OneToMany(mappedBy = "instructor")
    private List<dev.patika.fourthhomework.model.Course> InstructorCoursesList = new ArrayList<>();

}