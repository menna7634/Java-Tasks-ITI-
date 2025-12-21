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
    private final LibraryService libraryService;

    public MenuSystem(LibraryService ls, ClientService cs) {
        this.libraryService = ls;
        this.itemMenu = new ItemMenuHandler(ls, cs, scanner);
        this.clientMenu = new ClientMenuHandler(cs, ls, scanner);
        this.borrowMenu = new BorrowMenuHandler(ls, cs, scanner);
    }

    public void run() {
        boolean running = true;

        while (running) {
            printMainMenu();
            int choice = ConsoleUI.readInt("Choose: ", scanner);

            try {
                switch (choice) {
                    case 1 -> runItemMenu();
                    case 2 -> runClientMenu();
                    case 3 -> runBorrowMenu();
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

    //MAIN MENU
    private void printMainMenu() {
        ConsoleUI.title("Library Management System");

        System.out.println("""
                1. Library Items (Books & Magazines)
                2. Clients
                3. Borrowing Management
                ------------------------------------
                0. Exit
                """);
    }


    //ITEM MENU 
    private void runItemMenu() {
        boolean back = false;

        while (!back) {
            ConsoleUI.title("Library Item Management");

            System.out.println("""
                    1. Add Book
                    2. Add Magazine
                    3. Update Item
                    4. Remove Item
                    5. List All Items
                    ------------------------------------
                    0. Back
                    """);

            int choice = ConsoleUI.readInt("Choose: ", scanner);

            try {
                switch (choice) {
                    case 1 -> itemMenu.addBook();
                    case 2 -> itemMenu.addMagazine();
                    case 3 -> itemMenu.updateItem();
                    case 4 -> itemMenu.removeItem();
                    case 5 -> itemMenu.displayItemsDetails(libraryService.getAllItems());
                    case 0 -> back = true;
                    default -> ConsoleUI.error("Invalid choice. Try again.");
                }
            } catch (Exception ex) {
                ConsoleUI.error(ex.getMessage());
            }
        }
    }


    //CLIENT MENU
    private void runClientMenu() {
        boolean back = false;

        while (!back) {
            ConsoleUI.title("Client Management");

            System.out.println("""
                    1. Add Client
                    2. Update Client
                    3. Remove Client
                    4. Display All Clients
                    ------------------------------------
                    0. Back
                    """);

            int choice = ConsoleUI.readInt("Choose: ", scanner);

            try {
                switch (choice) {
                    case 1 -> clientMenu.addClient();
                    case 2 -> clientMenu.updateClient();
                    case 3 -> clientMenu.removeClient();
                    case 4 -> clientMenu.displayClients();
                    case 0 -> back = true;
                    default -> ConsoleUI.error("Invalid choice. Try again.");
                }
            } catch (Exception ex) {
                ConsoleUI.error(ex.getMessage());
            }
        }
    }


    private void runBorrowMenu() {
        boolean back = false;

        while (!back) {
            ConsoleUI.title("Borrowing Management");

            System.out.println("""
                    1. Borrow Item
                    2. Return Item
                    3. View All Borrowed Items
                    ------------------------------------
                    0. Back
                    """);

            int choice = ConsoleUI.readInt("Choose: ", scanner);

            try {
                switch (choice) {
                    case 1 -> borrowMenu.borrowItem();
                    case 2 -> borrowMenu.returnItem();
                    case 3 -> borrowMenu.displayBorrowed(); 
                    case 0 -> back = true;
                    default -> ConsoleUI.error("Invalid choice. Try again.");
                }
            } catch (Exception ex) {
                ConsoleUI.error(ex.getMessage());
            }
        }
    }
}
