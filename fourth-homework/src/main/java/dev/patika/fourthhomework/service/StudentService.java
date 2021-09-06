package dev.patika.fourthhomework.service;


import dev.patika.fourthhomework.dto.StudentDTO;
import dev.patika.fourthhomework.exceptions.StudentAgeNotValidException;
import dev.patika.fourthhomework.mappers.StudentMapper;
import dev.patika.fourthhomework.model.Logger;
import dev.patika.fourthhomework.model.Student;
import dev.patika.fourthhomework.repository.LoggerRepository;
import dev.patika.fourthhomework.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {


    private final StudentRepository studentRepository;
    private final LoggerRepository loggerRepository;
    private final StudentMapper studentMapper;


    @Transactional(readOnly = true)
    public List<Student> findAll() {
        List<Student> stuList = new ArrayList<>();
        Iterable<Student> studentIter = studentRepository.findAll();
        studentIter.iterator().forEachRemaining(stuList::add);
        return stuList;
    }


    @Transactional(readOnly = true)
    public Student findById(int id) {
        return studentRepository.findById(id).get();
    }


    @Transactional
    public Student save(StudentDTO studentDTO) {
        int year = Year.now().getValue();;
        boolean isExist =true;
        int dif=Math.abs(studentDTO.getBirthDate() - year);
        if ( dif>=18 &&	dif<=40 ){
            isExist=false;
        }


        String Error_mesage= " ";
        if(isExist){
            Error_mesage="Student birthdate cant accepted : " + studentDTO.getBirthDate();

            Logger log = new Logger(LocalDate.now(), Error_mesage);
            loggerRepository.save(log);

            throw new StudentAgeNotValidException(Error_mesage);}





        Student student=studentMapper.mapFromStudentDTOtoStudent((studentDTO));
        return studentRepository.save(student);
    }


    @Transactional
    public void delete(StudentDTO studentDTO) {
        Student student=studentMapper.mapFromStudentDTOtoStudent((studentDTO));
        studentRepository.delete(student);

    }


    @Transactional
    public void deleteById(int id) {
        studentRepository.deleteById(id);

    }


    @Transactional
    public Student update(StudentDTO studentDTO) {
        Student student=studentMapper.mapFromStudentDTOtoStudent((studentDTO));
        return studentRepository.save(student);
    }


    @Transactional
    public void updateById(StudentDTO studentDTO, int id) {
        Student student=studentMapper.mapFromStudentDTOtoStudent((studentDTO));
        Student student1 = this.findById(id);
        student1.setAddress(student.getAddress());
        student1.setName(student.getName());
        student1.setBirthDate(student.getBirthDate());
        student1.setGender(student.getGender());
        studentRepository.save(student1);
    }


    @Transactional(readOnly = true)
    public List<?> getStudentGender(){

        return studentRepository.getStudentGender();
    }

    @Transactional
    public void deleteAllByName(String name){
        studentRepository.deleteAllByName(name);

    }

    @Transactional(readOnly = true)
    public List<Student> findAllByName(String name) {
        List<Student> studentList = new ArrayList<>();
        Iterable<Student> studentIter = studentRepository.findAllByName(name);
        studentIter.iterator().forEachRemaining(studentList::add);
        return studentList;
    }




}
