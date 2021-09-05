package dev.patika.fourthhomework.service;


import dev.patika.fourthhomework.model.Student;
import dev.patika.fourthhomework.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements BaseService<Student> {


    private final StudentRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        List<Student> stuList = new ArrayList<>();
        Iterable<Student> studentIter = repository.findAll();
        studentIter.iterator().forEachRemaining(stuList::add);
        return stuList;
    }

    @Override
    @Transactional(readOnly = true)
    public Student findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    @Transactional
    public void delete(Student student) {
        repository.delete(student);

    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);

    }

    @Override
    @Transactional
    public Student update(Student student) {
        return repository.save(student);
    }

    @Override
    @Transactional
    public void updateById(Student student, int id) {
        Student student1 = this.findById(id);
        student1.setAddress(student.getAddress());
        student1.setName(student.getName());
        student1.setBirthDate(student.getBirthDate());
        student1.setGender(student.getGender());
        repository.save(student1);
    }


    @Transactional(readOnly = true)
    public List<?> getStudentGender(){

        return repository.getStudentGender();
    }

    @Transactional
    public void deleteAllByName(String name){
        repository.deleteAllByName(name);

    }

    @Transactional(readOnly = true)
    public List<Student> findAllByName(String name) {
        List<Student> studentList = new ArrayList<>();
        Iterable<Student> studentIter = repository.findAllByName(name);
        studentIter.iterator().forEachRemaining(studentList::add);
        return studentList;
    }




}
