package com.menna.Library.model;

public class Magazine extends LibraryItem {
    private String publisher;

    public Magazine(int id, String title, String publisher, int stock) {
        super(id, title, stock);
        setPublisher(publisher);
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        if (publisher != null && !publisher.isBlank()) {
            this.publisher = publisher.trim();
        }
    }

    @Override
    public String getItemDetails() {
        return "Magazine [ID:" + id + ", Title:" + title + ", Publisher:" + publisher + ", Stock:" + stock + "]";
    }

    @Override
    public String toString() {
        return getItemDetails();
    }
}
