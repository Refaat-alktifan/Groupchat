package com.andrody.test;

/**
 * Created by Abboudi_Aliwi on 10/24/2015.
 */
public class Chat {

    private String message;
    private String author;

    @SuppressWarnings("unused")
    private Chat() {
    }

    Chat(String message, String author) {
        this.message = message;
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public String getAuthor() {
        return author;
    }
}
