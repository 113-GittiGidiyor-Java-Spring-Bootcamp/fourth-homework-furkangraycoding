package dev.patika.fourthhomework.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor

@JsonTypeName("PermanentInstructor")
public class PermanentInstructorDTO extends InstructorDTO {
    @ApiModelProperty(example = "6100")
    private double fixedSalary;


}
