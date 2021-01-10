package com.kn.contactlist.log;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Configuration
public class LoggingAspect {

    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void setup() {
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    @Around("execution(* com.kn.contactlist.controller.impl..*(..)))")
    public Object aroundControllers(ProceedingJoinPoint point) throws Throwable {
        long startTime = System.currentTimeMillis();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        MethodSignature signature = (MethodSignature) point.getSignature();

        String methodName = signature.toShortString();

        Object result;

        try {
            result = point.proceed();
        } catch (Exception ex) {
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            logger.error("Exception occurred, httpUrl:{} httpMethod:{} resourceMethod:{} payload:{} duration:{} ms", request.getServletPath(), request.getMethod(),
                    methodName, point.getArgs(), duration);

            throw ex;
        }

        String jsonResultString;

        try {
            jsonResultString = objectMapper.writeValueAsString(result);
        } catch (Exception ex) {
            logger.warn("ResponseDataSerializationError-IgnoreThisError", ex);
            jsonResultString = "ResponseDataSerializationError Not valid java object for json";
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        logger.info("httpUrl:{} httpMethod:{} resourceMethod:{} payload:{} response:{} duration:{} ms", request.getServletPath(), request.getMethod(),
                methodName, point.getArgs(), jsonResultString, duration);

        return result;
    }
}