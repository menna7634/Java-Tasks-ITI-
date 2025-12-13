package com.menna.Library.services;

import com.menna.Library.exceptions.ItemNotFoundException;
import com.menna.Library.exceptions.ClientNotFoundException;
import com.menna.Library.model.LibraryItem;
import com.menna.Library.model.Client;
import java.util.ArrayList;
import java.util.List;

public class LibraryService {

    private final List<LibraryItem> items = new ArrayList<>();

    public void create(LibraryItem item) {
        items.add(item);
    }

    public LibraryItem read(int id) throws ItemNotFoundException {
        return items.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Item with ID " + id + " not found."));
    }

    public void update(int id, LibraryItem updated) throws ItemNotFoundException {
        LibraryItem existing = read(id);
        int index = items.indexOf(existing);
        items.set(index, updated);
    }

    public void delete(int id) throws ItemNotFoundException {
        LibraryItem item = read(id);
        items.remove(item);
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

        boolean success = item.decreaseStock(1);
        if (!success) {
            throw new ItemNotFoundException("Failed to borrow item '" + item.getTitle() + "'. Not enough stock.");
        }

        client.borrowItem(item);
    }

    public void returnItem(int itemId, int clientId, ClientService clientService)
            throws ClientNotFoundException, ItemNotFoundException {

        Client client = clientService.read(clientId);
        LibraryItem item = read(itemId);

        if (!client.getBorrowedItems().contains(item)) {
            throw new ItemNotFoundException("Client '" + client.getName() + "' did not borrow item '" + item.getTitle() + "'.");
        }

        item.increaseStock(1);
        client.returnItem(item);
    }
}
