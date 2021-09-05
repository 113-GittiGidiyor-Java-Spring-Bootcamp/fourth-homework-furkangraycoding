package dev.patika.fourthhomework.repository;

import dev.patika.fourthhomework.model.Instructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Integer> {

    @Query("FROM Instructor ORDER BY fixed_salary DESC")
    List<Instructor> getMaxSalary();

    @Query("FROM Instructor WHERE hourly_salary IS NOT NULL ORDER BY hourly_salary ASC")
    List<Instructor> getMinSalary();

    List<Instructor> deleteAllByName(String name);
    List<Instructor> findAllByName(String name);
}
