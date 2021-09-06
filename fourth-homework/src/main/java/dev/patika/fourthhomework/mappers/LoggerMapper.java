package dev.patika.fourthhomework.mappers;

import dev.patika.fourthhomework.dto.LoggerDTO;

import dev.patika.fourthhomework.model.Logger;
import dev.patika.fourthhomework.model.Student;
import org.mapstruct.Mapper;

@Mapper
public interface LoggerMapper {
    Logger mapFromLoggerDTOtoLogger(LoggerDTO dto);
    Logger mapFromLoggertoLoggerDTO(Logger logger);
}
