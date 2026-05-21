package com.rays.common;

import java.util.HashMap;

/**
 * ORSResponse is a generic response wrapper used to send back
 * responses from controllers or services in the application.
 * It provides standard keys for success status, messages,
 * input validation errors, and arbitrary data.
 */
public class ORSResponse {

    /** Key used for storing input validation errors */
    private static final String INPUT_ERROR = "inputerror";

    /** Key used for storing main data object */
    private static final String DATA = "data";

    /** Key used for storing message text */
    private static final String MESSAGE = "message";

    /** Indicates whether the operation was successful */
    private boolean success = false;

    /** Holds the response payload including data, messages, and errors */
    private HashMap<String, Object> result = new HashMap<String, Object>();

    /**
     * Default constructor.
     */
    public ORSResponse() {
    }

    /**
     * Constructs a response with a success status.
     *
     * @param success true if operation succeeded, false otherwise
     */
    public ORSResponse(boolean success) {
        this.success = success;
    }

    /**
     * Constructs a response with a success status and a message.
     *
     * @param success true if operation succeeded
     * @param message Message describing the result
     */
    public ORSResponse(boolean success, String message) {
        this.success = success;
        addMessage(message);
    }

    /**
     * Constructs a response with a success status, message, and data.
     *
     * @param success true if operation succeeded
     * @param message Message describing the result
     * @param value   The main data to include in the response
     */
    public ORSResponse(boolean success, String message, Object value) {
        this.success = success;
        addMessage(message);
        addData(value);
    }

    /**
     * Sets the success status.
     *
     * @param success true if operation succeeded
     */
    public void isSuccess(boolean success) {
        this.success = success;
    }

    /**
     * Returns the success status.
     *
     * @return true if operation succeeded, false otherwise
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Sets the success status.
     *
     * @param success true if operation succeeded
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * Returns the response result map containing data, messages, and errors.
     *
     * @return HashMap containing response payload
     */
    public HashMap<String, Object> getResult() {
        return result;
    }

    /**
     * Sets the response result map.
     *
     * @param result HashMap containing response payload
     */
    public void setResult(HashMap<String, Object> result) {
        this.result = result;
    }

    /** @return the key string for input errors */
    public static String getInputError() {
        return INPUT_ERROR;
    }

    /** @return the key string for data */
    public static String getData() {
        return DATA;
    }

    /** @return the key string for messages */
    public static String getMessage() {
        return MESSAGE;
    }

    /**
     * Adds main data to the response.
     *
     * @param value The data object to include
     */
    public void addData(Object value) {
        result.put(DATA, value);
    }

    /**
     * Adds a message to the response.
     *
     * @param value The message object or string
     */
    public void addMessage(Object value) {
        result.put(MESSAGE, value);
    }

    /**
     * Adds input validation errors to the response.
     *
     * @param value The input error object or map
     */
    public void addInputMessage(Object value) {
        result.put(INPUT_ERROR, value);
    }

    /**
     * Adds a custom key-value pair to the response result.
     *
     * @param key   The key to use
     * @param value The value to store
     */
    public void addResult(String key, Object value) {
        result.put(key, value);
    }

}