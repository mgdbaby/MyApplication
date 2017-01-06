package com.example.myapplication;

/**
 * Created by vargo on 2017/1/5.
 */

public class Book {
    private String title;
    private String context;

    public Book() {
    }

    public Book(String title, String context) {
        this.title = title;
        this.context = context;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", context='" + context + '\'' +
                '}';
    }
}
