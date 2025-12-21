package com.menna.Library.utils;

import com.menna.Library.model.Client;
import com.menna.Library.services.ClientService;
import com.menna.Library.services.LibraryService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GlobalIdTracker {

    private static final Set<Integer> usedIds = new HashSet<>();

    public static boolean isUsed(int id) {
        return usedIds.contains(id);
    }

    public static void add(int id) {
        usedIds.add(id);
    }

    public static void remove(int id) {
    usedIds.remove(id);
}

    public static List<Integer> getAllUsedIds(LibraryService libraryService, ClientService clientService) {
        List<Integer> bookAndMagazineIds = libraryService.getAllItems()
                .stream()
                .map(item -> item.getId())
                .collect(Collectors.toList());

        List<Integer> clientIds = clientService.getAllClients()
                .stream()
                .map(Client::getId)
                .collect(Collectors.toList());

        bookAndMagazineIds.addAll(clientIds);
        return bookAndMagazineIds;
    }

    public static class IdValidator {

        public static boolean isUnique(int id, List<Integer> existingIds) {
            return !existingIds.contains(id) && !GlobalIdTracker.isUsed(id);
        }

        public static int readUniqueId(String prompt, Scanner scanner, List<Integer> existingIds) {
            int id;
            do {
                System.out.print(prompt);

                while (!scanner.hasNextInt()) {
                    System.out.println("Enter a valid integer.");
                    scanner.next();
                    System.out.print(prompt);
                }
                id = scanner.nextInt();
                scanner.nextLine(); 

                if (id <= 0) {
                    System.out.println("ID must be positive.");
                } else if (!isUnique(id, existingIds)) {
                    System.out.println("ID already exists . Try another.");
                } else {
                    GlobalIdTracker.add(id); 
                    break;
                }
            } while (true);

            return id;
        }
    }
}
