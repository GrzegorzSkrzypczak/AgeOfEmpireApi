package pl.grzegorz.ageofempire.empires2.common.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.grzegorz.ageofempire.empires2.common.service.NoSuchCivilizationExeption;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value = NoSuchCivilizationExeption.class)
    public ResponseEntity<Object> noSuchElementException(NoSuchCivilizationExeption e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
