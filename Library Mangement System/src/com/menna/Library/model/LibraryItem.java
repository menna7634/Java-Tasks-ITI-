package com.menna.Library.model;

public abstract class LibraryItem {
    protected int id;
    protected String title;
    protected int stock;

    public LibraryItem(int id, String title, int stock) {
        this.id = id;
        setTitle(title);
        setStock(stock);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getStock() {
        return stock;
    }

    public void setTitle(String title) {
        if (title != null && !title.isBlank()) {
            this.title = title.trim();
        }
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        }
    }

    public boolean isAvailable() {
        return stock > 0;
    }

    public void increaseStock(int n) {
        if (n > 0){
         stock += n;
        }
    }

    public boolean decreaseStock(int n) {
        if (n > 0 && stock >= n) {
            stock -= n;
            return true;
        }
        return false;
    }

    public abstract String getItemDetails();
}
