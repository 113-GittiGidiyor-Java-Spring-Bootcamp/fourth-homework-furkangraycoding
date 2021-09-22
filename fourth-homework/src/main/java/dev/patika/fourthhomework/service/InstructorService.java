package dev.patika.fourthhomework.service;

import dev.patika.fourthhomework.dto.InstructorDTO;
import dev.patika.fourthhomework.exceptions.InstructorIsAlreadyExistException;
import dev.patika.fourthhomework.mappers.InstructorMapper;
import dev.patika.fourthhomework.model.Instructor;
import dev.patika.fourthhomework.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService {

    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;


    @Transactional(readOnly = true)
    public List<Instructor> findAll() {
        List<Instructor> insList = new ArrayList<>();
        Iterable<Instructor> instructorIter = instructorRepository.findAll();
        instructorIter.iterator().forEachRemaining(insList::add);
        return insList;
    }


    @Transactional(readOnly = true)
    public Instructor findById(int id) {
        return instructorRepository.findById(id).get();
    }


    @Transactional
    public Instructor save(InstructorDTO instructordto) {

        boolean isExist= instructorRepository.selectExistInstructor(instructordto.getPhoneNumber());
        if(isExist){
            throw new InstructorIsAlreadyExistException("Instructor Is Already Exist With Same Phone Number!");}

        Instructor instructor=instructorMapper.mapFromInstructorDTOtoInstructor(instructordto);
        return instructorRepository.save(instructor);
    }


    @Transactional
    public void delete(InstructorDTO instructordto) {
        Instructor instructor=instructorMapper.mapFromInstructorDTOtoInstructor(instructordto);
        instructorRepository.delete(instructor);

    }


    @Transactional
    public void deleteById(int id) {
        instructorRepository.deleteById(id);

    }


    @Transactional
    public Instructor update(InstructorDTO instructordto) {
        Instructor instructor=instructorMapper.mapFromInstructorDTOtoInstructor(instructordto);
        return instructorRepository.save(instructor);
    }


    @Transactional
    public void updateById(InstructorDTO instructordto, int id) {
        Instructor instructor=instructorMapper.mapFromInstructorDTOtoInstructor(instructordto);
        Instructor instructor1 = this.findById(id);
        instructor1.setAddress(instructor.getAddress());
        instructor1.setName(instructor.getName());
        instructor1.setPhoneNumber(instructor.getPhoneNumber());
        instructor1.setInstructorCoursesList(instructor.getInstructorCoursesList());
        instructorRepository.save(instructor1);
    }

    @Transactional(readOnly = true)
    public List<Instructor> getMaxSalary() {

        List<Instructor>  result= instructorRepository.getMaxSalary();

        List<Instructor> out = new ArrayList<>();;
        for(int i = 0; i < 3; i++) {
            out.add(result.get(i));
        }
        return out;
    }
    @Transactional(readOnly = true)
    public List<Instructor> getMinSalary() {

        List<Instructor>  result= instructorRepository.getMinSalary();

        List<Instructor> out = new ArrayList<>();;
        for(int i = 0; i < 3; i++) {
            out.add(result.get(i));
        }
        return out;
    }


    @Transactional
    public void deleteAllByName(String name) {
        instructorRepository.deleteAllByName(name);
    }



    @Transactional(readOnly = true)
    public List<Instructor> findAllByName(String name) {
        List<Instructor> instructorList = new ArrayList<>();
        Iterable<Instructor> instructorIter = instructorRepository.findAllByName(name);
        instructorIter.iterator().forEachRemaining(instructorList::add);
        return instructorList;
    }


}
