package example.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import example.services.ApplicationException;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    private final Log log = LogFactory.getLog(ExceptionHandlerAdvice.class);

    @ExceptionHandler(ApplicationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView handleException(ApplicationException exception) {

        log.error("Application Error.", exception);
        ModelAndView view = new ModelAndView("error", HttpStatus.BAD_REQUEST);
        view.addObject("status", HttpStatus.BAD_REQUEST.value());
        view.addObject("error", HttpStatus.BAD_REQUEST.name());
        return view;
    }
}
