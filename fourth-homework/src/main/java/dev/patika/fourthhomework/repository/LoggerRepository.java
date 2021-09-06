package dev.patika.fourthhomework.repository;


import dev.patika.fourthhomework.model.Logger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepository extends CrudRepository<Logger, Integer> {


}
