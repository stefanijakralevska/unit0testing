package com.internship.controllers.exceptions;

/**
 * Created by hnastevska on 7/20/2017.
 */
public class IncorrectSubjectEntryException extends Exception {
    String message;

    public IncorrectSubjectEntryException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
