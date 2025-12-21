package com.menna.Library.menu;

import com.menna.Library.exceptions.ItemNotFoundException;
import com.menna.Library.model.*;
import com.menna.Library.services.ClientService;
import com.menna.Library.services.LibraryService;
import com.menna.Library.utils.*;

import java.util.ArrayList;
import java.util.List;
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
   public void displayItemsDetails(List<LibraryItem> items) {

    List<Book> books = new ArrayList<>();
    List<Magazine> magazines = new ArrayList<>();

    for (LibraryItem item : items) {
        if (item instanceof Book) {
            books.add((Book) item);
        } else if (item instanceof Magazine) {
            magazines.add((Magazine) item);
        }
    }


    ConsoleUI.title("Books");

    if (books.isEmpty()) {
        ConsoleUI.info("No Books Available.");
    } else {
        System.out.println("ID | Title                 | Author              | Stock");
        System.out.println("---------------------------------------------------------------");

        for (Book b : books) {
            System.out.printf(
                "%-3d| %-20s | %-18s | %d%n",
                b.getId(),
                b.getTitle(),
                b.getAuthor(),
                b.getStock()
            );
        }

        ConsoleUI.success("Total Books: " + books.size());
    }

    System.out.println();

    ConsoleUI.title("Magazines");

    if (magazines.isEmpty()) {
        ConsoleUI.info("No Magazines Available.");
    } else {
        System.out.println("ID | Title                 |  Publisher | Stock");
        System.out.println("---------------------------------------------------------------");

        for (Magazine m : magazines) {
            System.out.printf(
                "%-3d| %-20s | %-12s | %d%n",
                m.getId(),
                m.getTitle(),
                m.getPublisher(),
                m.getStock()
            );
        }

        ConsoleUI.success("Total Magazines: " + magazines.size());
    }

    System.out.println();
    ConsoleUI.title("Summary");
    System.out.println("Total Items: " + items.size());
    System.out.println("Books: " + books.size());
    System.out.println("Magazines: " + magazines.size());
}

}
