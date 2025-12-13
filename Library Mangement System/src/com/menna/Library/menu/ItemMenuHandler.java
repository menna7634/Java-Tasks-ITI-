package com.menna.Library.menu;

import com.menna.Library.exceptions.ItemNotFoundException;
import com.menna.Library.model.*;
import com.menna.Library.services.ClientService;
import com.menna.Library.services.LibraryService;
import com.menna.Library.utils.*;

import java.util.Scanner;

public class ItemMenuHandler {

    private final LibraryService libraryService;
    private final ClientService clientService;
    private final Scanner scanner;

    public ItemMenuHandler(LibraryService libraryService,ClientService clientService, Scanner scanner) {
        this.libraryService = libraryService;
        this.clientService=clientService;
        this.scanner = scanner;
    }

    public void addBook() {
        ConsoleUI.title("Add New Book");
        Book b = BookValidator.createBook(libraryService,clientService, scanner);
        libraryService.create(b);
        ConsoleUI.success("Book added successfully:\n" + b.getItemDetails());
    }

    public void addMagazine() {
        ConsoleUI.title("Add New Magazine");
        Magazine m = MagazineValidator.createMagazine(libraryService,clientService, scanner);
        libraryService.create(m);
        ConsoleUI.success("Magazine added successfully:\n" + m.getItemDetails());
    }

    public void updateItem() throws ItemNotFoundException {
        ConsoleUI.title("Update Library Item");

        int id = ConsoleUI.readInt("Enter Item ID to update: ", scanner);
        LibraryItem existing = libraryService.read(id);

        ConsoleUI.info("Existing Data:\n" + existing.getItemDetails());

        LibraryItem updated;
        if (existing instanceof Book) {
            updated = BookValidator.updateBook((Book) existing, scanner);
        } else {
            updated = MagazineValidator.updateMagazine((Magazine) existing, scanner);
        }

        libraryService.update(id, updated);
        ConsoleUI.success("Item updated successfully.");
    }

    public void removeItem() throws ItemNotFoundException {
        ConsoleUI.title("Remove Library Item");
        int id = ConsoleUI.readInt("Enter Item ID to delete: ", scanner);
        libraryService.delete(id);
        ConsoleUI.success("Item removed successfully.");
    }
}
