package com.example.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice
{
    private static final Log LOGGER = LogFactory.getLog(ExceptionControllerAdvice.class);

    @Autowired
    private Environment environment;

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorInfo> handleGeneralException(Exception exception)
    {
        LOGGER.error(exception.getMessage(), exception);
        ErrorInfo err = new ErrorInfo(
                BAD_REQUEST.value(),
                environment.getProperty(exception.getMessage()
                ));
        return new ResponseEntity<>(err, BAD_REQUEST);
    }
}
