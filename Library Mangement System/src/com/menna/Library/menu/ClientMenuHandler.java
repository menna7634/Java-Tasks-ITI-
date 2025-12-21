package com.menna.Library.menu;

import com.menna.Library.exceptions.ClientNotFoundException;
import com.menna.Library.model.Client;
import com.menna.Library.services.ClientService;
import com.menna.Library.services.LibraryService;
import com.menna.Library.utils.*;

import java.util.Scanner;

public class ClientMenuHandler {

    private final ClientService clientService;
    private final LibraryService libraryService;
    private final Scanner scanner;

    public ClientMenuHandler(ClientService clientService,LibraryService libraryService, Scanner scanner) {
        this.clientService = clientService;
        this.libraryService=libraryService;
        this.scanner = scanner;
    }

    public void addClient() {
        ConsoleUI.title("Add New Client");
        Client c = ClientValidator.createClient(libraryService,clientService, scanner);
        clientService.create(c);
        ConsoleUI.success("Client added:\n" + c.getClientDetails());
    }

    public void updateClient() throws ClientNotFoundException {
        ConsoleUI.title("Update Client");

        int id = ConsoleUI.readInt("Enter Client ID: ", scanner);
        Client existing = clientService.read(id);

        ClientValidator.updateClient(existing, clientService, scanner);
        clientService.update(id, existing);

        ConsoleUI.success("Client updated successfully.");
    }

    public void removeClient() throws ClientNotFoundException {
        ConsoleUI.title("Remove Client");
        int id = ConsoleUI.readInt("Enter Client ID: ", scanner);
        clientService.delete(id);
        ConsoleUI.success("Client removed.");
    }
    public void displayClients() {
    ConsoleUI.title("All Clients");
    
    if (clientService.getAllClients().isEmpty()) {
        ConsoleUI.info("No clients found.");
        return;
    }

    clientService.getAllClients().forEach(client -> 
        System.out.println(client.getClientDetails())
    );
}

}
