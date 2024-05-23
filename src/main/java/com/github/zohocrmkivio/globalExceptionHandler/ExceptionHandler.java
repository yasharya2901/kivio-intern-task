package com.github.zohocrmkivio.globalExceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    // Exception handling logic
    public void handleException(Exception e) {
        // Log the exception
        System.out.println("Exception occurred: " + e.getMessage());
    }
}
