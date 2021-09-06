package dev.patika.fourthhomework.service;



import dev.patika.fourthhomework.dto.LoggerDTO;
import dev.patika.fourthhomework.mappers.LoggerMapper;

import dev.patika.fourthhomework.model.Logger;

import dev.patika.fourthhomework.repository.LoggerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

        Logger logger=loggerMapper.mapFromLoggerDTOtoLogger(loggerDTO);
        return loggerRepository.save(logger);
    }









}
