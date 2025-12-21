package com.menna.Library.model;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int id;
    private String name;
    private String email;

    // Stores BorrowRecord, not LibraryItem
    private List<BorrowRecord> borrowedItems = new ArrayList<>();

    public Client(int id, String name, String email) {
        this.id = id;
        setName(name);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name.trim();
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && !email.isBlank()) {
            this.email = email.trim();
        }
    }

    public List<BorrowRecord> getBorrowedItems() {
        return borrowedItems;
    }

    public void addBorrowRecord(BorrowRecord record) {
        borrowedItems.add(record);
    }

    public void removeBorrowRecord(BorrowRecord record) {
        borrowedItems.remove(record);
    }

    public String getClientDetails() {

        String details = "Client [ID:" + id + ", Name:" + name + ", Email:" + email + "]";

        details += "\nBorrowed Items: ";
        if (borrowedItems.isEmpty()) {
            details += "None";
        } else {
            for (BorrowRecord rec : borrowedItems) {
                details += "\n  - " + rec.getItem().getTitle() + 
                           " (ID: " + rec.getItem().getId() + 
                           ", Borrowed: " + rec.getBorrowDate() + ")";
            }
        }

        return details;
    }
}
