package dev.patika.fourthhomework.dto;

import dev.patika.fourthhomework.model.AbstractBaseEntity;
import dev.patika.fourthhomework.model.Course;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
public class StudentDTO{
    @ApiModelProperty(hidden = true )
    private int id;
    @ApiModelProperty(example = "Ogrencı")
    private String name;
    @ApiModelProperty(example = "1980")
    private int birthDate;
    @ApiModelProperty(example = "Ogrenci adres")
    private String address;
    @ApiModelProperty(example = "male")
    private String gender;
    private List<Course> studentCourses = new ArrayList<>();

}
