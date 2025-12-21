package com.menna.Library.services;

import com.menna.Library.exceptions.ItemNotFoundException;
import com.menna.Library.exceptions.ClientNotFoundException;
import com.menna.Library.model.*;
import com.menna.Library.utils.ConsoleUI;
import com.menna.Library.utils.GlobalIdTracker;

import java.util.ArrayList;
import java.util.List;

public class LibraryService implements CrudService<LibraryItem> {

    private final List<LibraryItem> items = new ArrayList<>();
    private final List<BorrowRecord> borrowedItems = new ArrayList<>();

    @Override
    public void create(LibraryItem item) {
        items.add(item);
    }

    @Override
    public LibraryItem read(int id) throws ItemNotFoundException {
        return items.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new ItemNotFoundException("Item with ID " + id + " not found.")
                );
    }

    @Override
    public void update(int id, LibraryItem updated) throws ItemNotFoundException {
        LibraryItem existing = read(id);
        int index = items.indexOf(existing);
        items.set(index, updated);
    }

  public void delete(int id) throws ItemNotFoundException {
    LibraryItem item = read(id);

    boolean isBorrowed = borrowedItems.stream()
            .anyMatch(r -> r.getItem().getId() == id);

    if (isBorrowed) {
        throw new ItemNotFoundException(
                "Cannot delete item '" + item.getTitle() +
                "' because it is currently borrowed by clients."
        );
    }

    items.remove(item);
    GlobalIdTracker.remove(id);
    System.out.println("Item deleted.");
}

public List<LibraryItem> getAllItems() {
    return new ArrayList<>(items);
}



public void borrowItem(int clientId, int itemId, ClientService clientService)
        throws ClientNotFoundException, ItemNotFoundException {

    Client client = clientService.read(clientId);
    LibraryItem item = read(itemId);

    if (!item.isAvailable()) {
        throw new ItemNotFoundException("Item '" + item.getTitle() + "' is out of stock.");
    }

    item.decreaseStock(1);

    BorrowRecord existing = borrowedItems.stream()
            .filter(r -> r.getClient().getId() == clientId &&
                         r.getItem().getId() == itemId)
            .findFirst()
            .orElse(null);

    if (existing != null) {
        existing.incrementQuantity(); 
    } else {
        BorrowRecord newRecord = new BorrowRecord(item, client);
        borrowedItems.add(newRecord);
        client.addBorrowRecord(newRecord);
    }

    ConsoleUI.success("Item '" + item.getTitle() + "' borrowed successfully.");
}

    public void returnItem(int itemId, int clientId, ClientService clientService)
            throws ClientNotFoundException, ItemNotFoundException {

        Client client = clientService.read(clientId);
        LibraryItem item = read(itemId);
        BorrowRecord found = borrowedItems.stream()
                .filter(r -> r.getClient().getId() == clientId &&
                             r.getItem().getId() == itemId)
                .findFirst()
                .orElse(null);

        if (found == null) {
            throw new ItemNotFoundException(
                    "Client '" + client.getName() +
                    "' did not borrow item '" + item.getTitle() + "'."
            );
        }
        item.increaseStock(1);
        borrowedItems.remove(found);
        client.removeBorrowRecord(found);
    }

    public List<BorrowRecord> getBorrowedItems() {
        return new ArrayList<>(borrowedItems);
    }
}
