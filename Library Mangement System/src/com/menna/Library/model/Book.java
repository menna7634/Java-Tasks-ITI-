package com.menna.Library.model;

public class Book extends LibraryItem {
    private String author;

    public Book(int id, String title, String author, int stock) {
        super(id, title, stock);
        setAuthor(author);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author != null && !author.isBlank()) {
            this.author = author.trim();
        }
    }

    @Override
    public String getItemDetails() {
        return "Book [ID:" + id + ", Title:" + title + ", Author:" + author + ", Stock:" + stock + "]";
    }

    @Override
    public String toString() {
        return getItemDetails();
    }
}
