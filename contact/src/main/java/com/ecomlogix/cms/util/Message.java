package com.ecomlogix.cms.util;

/**
 * Created by eric on 19/06/2016.
 */
public class Message {

    private String type;
    private String message;

    public Message(String message, String type) {
        this.message = message;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}