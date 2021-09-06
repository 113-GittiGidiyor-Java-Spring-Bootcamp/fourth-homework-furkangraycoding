package dev.patika.fourthhomework.mappers;

import dev.patika.fourthhomework.dto.StudentDTO;
import dev.patika.fourthhomework.model.Student;
import org.mapstruct.Mapper;

@Mapper
public interface StudentMapper {

    Student mapFromStudentDTOtoStudent(StudentDTO dto);
    Student mapFromStudenttoStudentDTO(Student student);

}
