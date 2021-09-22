package dev.patika.fourthhomework.exceptions;

import dev.patika.fourthhomework.dto.LoggerDTO;

import dev.patika.fourthhomework.mappers.LoggerMapper;
import dev.patika.fourthhomework.model.Logger;
import dev.patika.fourthhomework.service.LoggerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final LoggerService loggerService;
    private final LoggerMapper loggerMapper;

    @ExceptionHandler({CourseIsAlreadyExistException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Logger> handleException(CourseIsAlreadyExistException courseIsAlreadyExistException) {
        Logger response = prepareErrorResponse(HttpStatus.BAD_REQUEST, courseIsAlreadyExistException.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InstructorIsAlreadyExistException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Logger> handleException(InstructorIsAlreadyExistException instructorIsAlreadyExistException) {
        Logger response = prepareErrorResponse(HttpStatus.BAD_REQUEST, instructorIsAlreadyExistException.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({StudentAgeNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Logger> handleException(StudentAgeNotValidException studentAgeNotValidException) {
        Logger response = prepareErrorResponse(HttpStatus.BAD_REQUEST, studentAgeNotValidException.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({StudentNumberForOneCourseExceededException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Logger> handleException(StudentNumberForOneCourseExceededException studentNumberForOneCourseExceededException) {
        Logger response = prepareErrorResponse(HttpStatus.BAD_REQUEST, studentNumberForOneCourseExceededException.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private Logger prepareErrorResponse(HttpStatus httpStatus, String message) {
        LoggerDTO response = new LoggerDTO();
        response.setThrowStatusCode(httpStatus.value());
        response.setThrowMessage(message);
        response.setThrowDate(LocalDate.now());
        return loggerService.save(response);

    }

}