package com.menna.Library.model;

import java.time.LocalDate;

public class BorrowRecord {

    private final LibraryItem item;
    private final Client client;
    private int quantity;
    private final LocalDate borrowDate;

    public BorrowRecord(LibraryItem item, Client client) {
        this.item = item;
        this.client = client;
        this.borrowDate = LocalDate.now();
        this.quantity = 1;
    }

    public LibraryItem getItem() {
        return item;
    }

    public Client getClient() {
        return client;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }
       public void incrementQuantity() {
        quantity++;
    }

    public void decrementQuantity() {
        quantity--;
    }

    public int getQuantity() {
        return quantity;
    }
}
