package com.menna.Library.services;

import com.menna.Library.exceptions.ClientNotFoundException;
import com.menna.Library.model.Client;
import com.menna.Library.utils.GlobalIdTracker;

import java.util.ArrayList;
import java.util.List;

public class ClientService implements CrudService<Client> {
    private final List<Client> clients = new ArrayList<>();

    @Override
    public void create(Client client) {
        boolean emailTaken = clients.stream().anyMatch(c -> c.getEmail().equalsIgnoreCase(client.getEmail()));
        if (emailTaken) throw new IllegalArgumentException("Email already in use.");
        clients.add(client);
        System.out.println("Client created.");
    }

    @Override
    public Client read(int id) throws ClientNotFoundException {
        return clients.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ClientNotFoundException("Client with ID " + id + " not found."));
    }

    @Override
    public void update(int id, Client updated) throws ClientNotFoundException {
        Client existing = read(id);
        boolean emailTaken = clients.stream()
                .anyMatch(c -> c.getId() != id && c.getEmail().equalsIgnoreCase(updated.getEmail()));
        if (emailTaken) 
            throw new IllegalArgumentException("Email already used by another client.");
        clients.remove(existing);
        clients.add(updated);
        System.out.println("Client updated.");
    }

   public void delete(int id) throws ClientNotFoundException {
    Client client = read(id);

    if (!client.getBorrowedItems().isEmpty()) {
        throw new ClientNotFoundException(
                "Cannot delete client '" + client.getName() +
                "' because they still have borrowed items."
        );
    }

    clients.remove(client);
    GlobalIdTracker.remove(id);
    System.out.println("Client deleted.");
}


    public List<Client> getAllClients() {
        return clients;
    }

    public void displayAll() {
        if (clients.isEmpty()) {
            System.out.println("No clients.");
            return;
        }
        clients.forEach(c -> System.out.println(c.getClientDetails()));
    }
}
