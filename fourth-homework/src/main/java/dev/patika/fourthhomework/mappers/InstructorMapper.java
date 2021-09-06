package dev.patika.fourthhomework.mappers;

import dev.patika.fourthhomework.dto.InstructorDTO;
import dev.patika.fourthhomework.model.Instructor;
import org.mapstruct.Mapper;

@Mapper
public interface InstructorMapper {

    Instructor mapFromInstructorDTOtoInstructor(InstructorDTO dto);
    Instructor mapFromInstructortoInstructorDTO(Instructor instructor);

}
