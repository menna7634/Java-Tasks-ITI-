package com.menna.Library.model;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int id;
    private String name;
    private String email;
    private List<LibraryItem> borrowedItems = new ArrayList<>();

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
        if (name != null && !name.isBlank()) this.name = name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && !email.isBlank()) this.email = email.trim();
    }

    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    public void borrowItem(LibraryItem item) {
        if (item != null && item.isAvailable()) {
            item.decreaseStock(1);
            borrowedItems.add(item);
        }
    }

    public void returnItem(LibraryItem item) {
        if (borrowedItems.remove(item)) {
            item.increaseStock(1);
        }
    }

    public String getClientDetails() {
        return "Client [ID:" + id + ", Name:" + name + ", Email:" + email + "]";
    }
}
