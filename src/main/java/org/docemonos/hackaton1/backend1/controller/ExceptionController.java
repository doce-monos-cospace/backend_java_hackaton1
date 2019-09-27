package org.docemonos.hackaton1.backend1.controller;

import org.docemonos.hackaton1.backend1.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(basePackages = {"controller",
                                  "config" })
public class ExceptionController {

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    private ErrorDTO usernameNotFoundException(UsernameNotFoundException exception) {
        return new ErrorDTO("404", exception.getMessage());
    }


}
