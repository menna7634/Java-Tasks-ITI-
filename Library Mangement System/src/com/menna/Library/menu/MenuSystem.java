package com.menna.Library.menu;

import com.menna.Library.services.ClientService;
import com.menna.Library.services.LibraryService;
import com.menna.Library.utils.ConsoleUI;

import java.util.Scanner;

public class MenuSystem {

    private final Scanner scanner = new Scanner(System.in);
    private final ItemMenuHandler itemMenu;
    private final ClientMenuHandler clientMenu;
    private final BorrowMenuHandler borrowMenu;

    public MenuSystem(LibraryService ls, ClientService cs) {
        this.itemMenu = new ItemMenuHandler(ls,cs, scanner);
        this.clientMenu = new ClientMenuHandler(cs,ls, scanner);
        this.borrowMenu = new BorrowMenuHandler(ls, cs, scanner);
    }

    public void run() {
        boolean running = true;
        while (running) {
            printMainMenu();

            int choice = ConsoleUI.readInt("Choose: ", scanner);

            try {
                switch (choice) {
                    case 1 -> itemMenu.addBook();
                    case 2 -> itemMenu.addMagazine();
                    case 3 -> itemMenu.updateItem();
                    case 4 -> itemMenu.removeItem();
                    case 5 -> clientMenu.addClient();
                    case 6 -> clientMenu.updateClient();
                    case 7 -> clientMenu.removeClient();
                    case 8 -> borrowMenu.borrowItem();
                    case 9 -> borrowMenu.returnItem();
                    case 0 -> {
                        ConsoleUI.success("Exiting system... Goodbye!");
                        running = false; 
                    }
                    default -> ConsoleUI.error("Invalid choice. Try again.");
                }
            } catch (Exception ex) {
                ConsoleUI.error(ex.getMessage());
            }
        }
    }

    private void printMainMenu() {
        ConsoleUI.title("Library Management System");

        System.out.println("""
                1. Add Book
                2. Add Magazine
                3. Update Item
                4. Remove Item
                ------------------------------------
                5. Add Client
                6. Update Client
                7. Remove Client
                ------------------------------------
                8. Borrow Item
                9. Return Item
                ------------------------------------
                0. Exit
                """);
    }
}
