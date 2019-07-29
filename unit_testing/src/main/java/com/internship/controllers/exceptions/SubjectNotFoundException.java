package com.internship.controllers.exceptions;

/**
 * Created by hnastevska on 7/20/2017.
 */
public class SubjectNotFoundException extends Exception {
    String message;

    public SubjectNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
