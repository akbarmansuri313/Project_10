package com.rays.exception;

/**
 * Custom exception thrown when a duplicate record is encountered.
 * 
 * @author Akbar Mansuri
 */
public class DuplicateRecordException extends RuntimeException {

    public DuplicateRecordException(String msg) {
        super(msg);
    }
}