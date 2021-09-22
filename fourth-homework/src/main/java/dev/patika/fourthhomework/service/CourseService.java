package dev.patika.fourthhomework.service;


import dev.patika.fourthhomework.dto.CourseDTO;
import dev.patika.fourthhomework.exceptions.CourseIsAlreadyExistException;
import dev.patika.fourthhomework.exceptions.StudentNumberForOneCourseExceededException;
import dev.patika.fourthhomework.mappers.CourseMapper;
import dev.patika.fourthhomework.model.Course;
import dev.patika.fourthhomework.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {


    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;



    @Transactional(readOnly = true)
    public List<Course> findAll() {
        List<Course> courseList = new ArrayList<>();
        Iterable<Course> courseIter = courseRepository.findAll();
        courseIter.iterator().forEachRemaining(courseList::add);
        return courseList;
    }


    @Transactional(readOnly = true)
    public Course findById(int id) {
        return courseRepository.findById(id).get();
    }



    @Transactional
    public Course save(CourseDTO courseDTO) {

        boolean isExist= courseRepository.selectExistCourse(courseDTO.getCourseCode());

        if(isExist){

            throw new CourseIsAlreadyExistException("Course with CourseCode : " + courseDTO.getCourseCode() + " is already exists!");}


        Course course=courseMapper.mapFromCourseDTOtoCourse(courseDTO);

        return courseRepository.save(course);
    }



    @Transactional
    public void delete(CourseDTO courseDTO) {
        Course course=courseMapper.mapFromCourseDTOtoCourse(courseDTO);
        courseRepository.delete(course);

    }


    @Transactional
    public void deleteById(int id) {
        courseRepository.deleteById(id);

    }


    @Transactional
    public Course update(CourseDTO courseDTO) {
        if(courseDTO.getStudentList().size()>20){

            throw new StudentNumberForOneCourseExceededException("This course is limited to 20 people!");}

        Course course=courseMapper.mapFromCourseDTOtoCourse(courseDTO);
        return courseRepository.save(course);
    }


    @Transactional
    public void updateById(CourseDTO courseDTO, int id) {
        Course course=courseMapper.mapFromCourseDTOtoCourse(courseDTO);
        Course course1 = this.findById(id);
        course1.setCourseCode(course.getCourseCode());
        course1.setCourseName(course.getCourseName());
        course1.setCredit(course.getCredit());
        course1.setInstructor(course.getInstructor());
        course1.setStudentList(course.getStudentList());
        courseRepository.save(course1);
    }


    @Transactional
    public void deleteByCourseName(String name) {
        courseRepository.deleteByCourseName(name);
    }

    @Transactional(readOnly = true)
    public List<Course> findAllByCourseName(String name) {
        List<Course> courseList = new ArrayList<>();
        Iterable<Course> courseIter = courseRepository.findAllByCourseName(name);
        courseIter.iterator().forEachRemaining(courseList::add);
        return courseList;
    }


}
