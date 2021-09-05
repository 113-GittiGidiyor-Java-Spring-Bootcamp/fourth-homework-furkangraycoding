package dev.patika.fourthhomework.model;

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
public class Student extends AbstractBaseEntity{

    private String name;
    private String birthDate;
    private String address;
    private String gender;

    @ManyToMany
    private List<dev.patika.fourthhomework.model.Course> studentCourses = new ArrayList<>();

}
