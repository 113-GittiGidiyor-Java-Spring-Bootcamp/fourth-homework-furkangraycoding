package dev.patika.fourthhomework.repository;


import dev.patika.fourthhomework.model.Logger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

import java.util.List;

@Repository
public interface LoggerRepository extends JpaRepository<Logger, Long> {


    List<Logger> findByDate(LocalDate date);

    List<Logger> findByStatus(int status);
}
