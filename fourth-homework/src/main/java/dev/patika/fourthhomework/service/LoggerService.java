package dev.patika.fourthhomework.service;



import dev.patika.fourthhomework.dto.LoggerDTO;
import dev.patika.fourthhomework.mappers.LoggerMapper;

import dev.patika.fourthhomework.model.Logger;

import dev.patika.fourthhomework.repository.LoggerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoggerService {


    private final LoggerRepository loggerRepository;
    private final LoggerMapper loggerMapper;


    @Transactional(readOnly = true)
    public List<Logger> findAll() {
        List<Logger> loglist = new ArrayList<>();
        Iterable<Logger> loggersiter = loggerRepository.findAll();
        loggersiter.iterator().forEachRemaining(loglist::add);
        return loglist;
    }


    @Transactional
    public Logger save(LoggerDTO loggerDTO) {
        // Mapper problem will be fixed
        Logger logger=new Logger();
        logger.setMessage(loggerDTO.getThrowMessage());
        logger.setDate(loggerDTO.getThrowDate());
        logger.setStatus(loggerDTO.getThrowStatusCode());
        return loggerRepository.save(logger);
    }

    @Transactional(readOnly = true)
    public List<Logger> findAllByStatus(int status) {
        List<Logger> loglist = new ArrayList<>();
        Iterable<Logger> loggersiter = loggerRepository.findByStatus(status);
        loggersiter.iterator().forEachRemaining(loglist::add);
        return loglist;
    }

    @Transactional(readOnly = true)
    public List<Logger> getByTimestampBetween(LocalDate date) {
        List<Logger> loglist = new ArrayList<>();
        Iterable<Logger> loggersiter = loggerRepository.findByDate(date);
        loggersiter.iterator().forEachRemaining(loglist::add);
        return loglist;
    }









}
