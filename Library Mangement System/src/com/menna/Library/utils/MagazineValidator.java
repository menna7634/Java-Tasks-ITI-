package com.menna.Library.utils;
import com.menna.Library.model.Magazine;
import com.menna.Library.services.ClientService;
import com.menna.Library.services.LibraryService;
import java.util.Scanner;

public class MagazineValidator {

    public static Magazine createMagazine(LibraryService libraryService, ClientService clientService, Scanner scanner) {
   var existingIds = GlobalIdTracker.getAllUsedIds(libraryService, clientService);
        int id = GlobalIdTracker.IdValidator.readUniqueId(
                "Enter Magazine ID: ",
                scanner,
                existingIds
        );
        String title = LibraryItemValidator.readTitle("Enter Magazine Title: ", scanner);

        System.out.print("Enter Publisher: ");
        String publisher = scanner.nextLine().trim();
        while (publisher.isEmpty()) {
            System.out.println("Publisher cannot be empty. Try again.");
            publisher = scanner.nextLine().trim();
        }

        int stock = LibraryItemValidator.readStock("Enter Stock: ", scanner);

        return new Magazine(id, title, publisher, stock);
    }

    public static Magazine updateMagazine(Magazine existing, Scanner scanner) {
        System.out.print("Enter new Magazine Title (leave blank to keep '" + existing.getTitle() + "'): ");
        String title = scanner.nextLine().trim();
        if (!title.isEmpty()) existing.setTitle(title);

        System.out.print("Enter new Publisher (leave blank to keep '" + existing.getPublisher() + "'): ");
        String publisher = scanner.nextLine().trim();
        if (!publisher.isEmpty()) existing.setPublisher(publisher);

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
