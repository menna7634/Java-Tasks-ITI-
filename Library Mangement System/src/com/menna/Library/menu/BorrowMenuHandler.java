package com.menna.Library.menu;

import com.menna.Library.exceptions.ClientNotFoundException;
import com.menna.Library.exceptions.ItemNotFoundException;
import com.menna.Library.model.Book;
import com.menna.Library.services.ClientService;
import com.menna.Library.services.LibraryService;
import com.menna.Library.utils.ConsoleUI;

import java.util.Scanner;

public class BorrowMenuHandler {

    private final LibraryService libraryService;
    private final ClientService clientService;
    private final Scanner scanner;

    public BorrowMenuHandler(LibraryService libraryService, ClientService clientService, Scanner scanner) {
        this.libraryService = libraryService;
        this.clientService = clientService;
        this.scanner = scanner;
    }

    public void borrowItem() throws ClientNotFoundException, ItemNotFoundException {
        ConsoleUI.title("Borrow Item");

        int clientId = ConsoleUI.readInt("Enter Client ID: ", scanner);
        int itemId = ConsoleUI.readInt("Enter Item ID: ", scanner);

        libraryService.borrowItem(clientId, itemId, clientService);

        ConsoleUI.success("Item borrowed successfully.");
    }

    public void returnItem() throws ClientNotFoundException, ItemNotFoundException {
        ConsoleUI.title("Return Item");

        int itemId = ConsoleUI.readInt("Enter Item ID: ", scanner);
        int clientId = ConsoleUI.readInt("Enter Client ID: ", scanner);

        libraryService.returnItem(itemId, clientId, clientService);

        ConsoleUI.success("Item returned successfully.");
    }
    
    public void displayBorrowed() {
    ConsoleUI.title("Borrowed Items Report");

    var borrowedList = libraryService.getBorrowedItems(); 

    if (borrowedList.isEmpty()) {
        ConsoleUI.info("No items are currently borrowed.");
        return;
    }

   System.out.println("ID | Title                 | Type       | Borrowed By            | Quantity");
System.out.println("----------------------------------------------------------------------------");

borrowedList.forEach(record -> {
    var item = record.getItem();
    var client = record.getClient();

    String type = (item instanceof Book) ? "Book" : "Magazine";

    System.out.printf(
            "%-3d| %-20s| %-10s| %-22s| %-3d%n",
            item.getId(),
            item.getTitle(),
            type,
            client.getName() + " (ID:" + client.getId() + ")",
            record.getQuantity()
    );
});

    ConsoleUI.success("Total Borrowed Items: " + borrowedList.size());
}

}
