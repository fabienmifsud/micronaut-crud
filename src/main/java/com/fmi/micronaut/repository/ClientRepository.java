package com.fmi.micronaut.repository;

import com.fmi.micronaut.data.Client;

import java.util.List;

public interface ClientRepository {
    List<Client> findAll();

    Boolean createClient(Client client);
}
