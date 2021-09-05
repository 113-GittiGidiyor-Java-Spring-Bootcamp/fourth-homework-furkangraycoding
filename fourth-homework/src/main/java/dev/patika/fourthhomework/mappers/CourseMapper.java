package dev.patika.fourthhomework.mappers;

import dev.patika.fourthhomework.dto.CourseDTO;
import dev.patika.fourthhomework.model.Course;
import org.mapstruct.Mapper;

@Mapper
public interface CourseMapper {

    Course mapFromCourseDTOtoCourse(CourseDTO dto);
    Course mapFromCoursetoCourseDTO(Course course);

}
