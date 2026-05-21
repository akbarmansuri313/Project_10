package com.rays.exception;

/**
 * Custom exception thrown for database-related errors.
 * 
 * @author Akbar Mansuri
 */
public class DatabaseException extends RuntimeException {

    public DatabaseException(String msg) {
        super(msg);
    }

}