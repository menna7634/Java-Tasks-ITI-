package com.menna.Library.utils;

import com.menna.Library.model.Book;
import com.menna.Library.services.ClientService;
import com.menna.Library.services.LibraryService;
import java.util.Scanner;

public class BookValidator {
    public static Book createBook(LibraryService libraryService, ClientService clientService, Scanner scanner) {

    var existingIds = GlobalIdTracker.getAllUsedIds(libraryService, clientService);
        int id = GlobalIdTracker.IdValidator.readUniqueId(
                "Enter Book ID: ",
                scanner,
                existingIds
        );
        String title = LibraryItemValidator.readTitle("Enter Book Title: ", scanner);

        System.out.print("Enter Author: ");
        String author = scanner.nextLine().trim();
        while (author.isEmpty()) {
            System.out.println("Author cannot be empty. Try again.");
            author = scanner.nextLine().trim();
        }

        int stock = LibraryItemValidator.readStock("Enter Stock: ", scanner);

        return new Book(id, title, author, stock);
    }

    public static Book updateBook(Book existing, Scanner scanner) {
        System.out.print("Enter new Book Title (leave blank to keep '" + existing.getTitle() + "'): ");
        String title = scanner.nextLine().trim();
        if (!title.isEmpty()) {
            existing.setTitle(title);
        }

        System.out.print("Enter new Author (leave blank to keep '" + existing.getAuthor() + "'): ");
        String author = scanner.nextLine().trim();
        if (!author.isEmpty()){
             existing.setAuthor(author);
        }

        System.out.print("Enter new Stock (leave blank to keep '" + existing.getStock() + "'): ");
        String stockStr = scanner.nextLine().trim();
        if (!stockStr.isEmpty()) {
            try {
                int stock = Integer.parseInt(stockStr);
                if (stock >= 0) existing.setStock(stock);
            } catch (NumberFormatException ignored) {}
        }

        return existing;
    }
}
