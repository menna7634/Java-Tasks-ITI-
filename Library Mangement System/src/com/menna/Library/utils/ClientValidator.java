package com.menna.Library.utils;

import com.menna.Library.model.Client;
import com.menna.Library.services.ClientService;
import com.menna.Library.services.LibraryService;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ClientValidator {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");

    public static Client createClient(LibraryService libraryService, ClientService clientService, Scanner scanner) {
   List<Integer> existingIds = GlobalIdTracker.getAllUsedIds(libraryService, clientService);

        int id = GlobalIdTracker.IdValidator.readUniqueId(
                "Enter Client ID: ",
                scanner,
                existingIds
        );
        GlobalIdTracker.add(id); 

        String name;
        do {
            System.out.print("Enter Client Name: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                ConsoleUI.error("Name cannot be empty.");
            }
        } while (name.isEmpty());

        String email="";
        boolean validEmail;
        do {
            System.out.print("Enter Email: ");
            String input = scanner.nextLine().trim();
            boolean formatOk = EMAIL_PATTERN.matcher(input).matches();
            boolean unique = clientService.getAllClients().stream()
                    .noneMatch(c -> c.getEmail().equalsIgnoreCase(input));

            validEmail = formatOk && unique;
            if (!formatOk) {
                ConsoleUI.error("Invalid email format.");
            } else if (!unique) {
                ConsoleUI.error("Email already exists. Try another.");
            } else {
                email = input;
            }
        } while (!validEmail);

        return new Client(id, name, email);
    }


    public static Client updateClient(Client existing, ClientService clientService, Scanner scanner) {

        System.out.print("Enter new Name (or leave blank to keep '" + existing.getName() + "'): ");
        String nameInput = scanner.nextLine().trim();
        if (!nameInput.isEmpty()) {
            existing.setName(nameInput);
        }

        boolean emailValid;
        do {
            System.out.print("Enter new Email (or leave blank to keep '" + existing.getEmail() + "'): ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) break;

            boolean formatOk = EMAIL_PATTERN.matcher(input).matches();
            boolean unique = clientService.getAllClients().stream()
                    .noneMatch(c -> c.getEmail().equalsIgnoreCase(input) && c.getId() != existing.getId());

            emailValid = formatOk && unique;
            if (!formatOk) {
                ConsoleUI.error("Invalid email format.");
            } else if (!unique) {
                ConsoleUI.error("Email already exists. Try another.");
            } else {
                existing.setEmail(input);
            }
        } while (!emailValid);

        return existing;
    }
}
