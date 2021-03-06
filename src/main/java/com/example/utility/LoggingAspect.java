package com.example.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect
{
    private static final String POINTCUT = "execution(* com.example.service.*Impl.*(..))";
    private static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);

    @AfterThrowing(pointcut = POINTCUT ,throwing = "exception")
    public void log(Exception exception) { LOGGER.error(exception.getMessage(), exception); }
}