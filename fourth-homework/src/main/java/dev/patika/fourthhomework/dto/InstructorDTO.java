package dev.patika.fourthhomework.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dev.patika.fourthhomework.model.Course;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PermanentInstructorDTO.class, name = "PermanentInstructor"),
        @JsonSubTypes.Type(value = VisitingResearcherDTO.class, name = "VisitingResearcher")
})
@Inheritance(strategy = InheritanceType.JOINED)
public class InstructorDTO {
    @ApiModelProperty(hidden = true)
    private int id;
    @ApiModelProperty(example = "Furkan")
    private String name;
    @ApiModelProperty(example = "Furkan adres")
    private String address;
    @ApiModelProperty(example = "1234")
    private int phoneNumber;
    private List<Course> InstructorCoursesList = new ArrayList<>();

}
