package com.menna.Library.app;

import com.menna.Library.menu.MenuSystem;
import com.menna.Library.services.ClientService;
import com.menna.Library.services.LibraryService;

public class Main {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();
        ClientService clientService = new ClientService();

        MenuSystem menu = new MenuSystem(libraryService, clientService);
        menu.run();
    }
}
