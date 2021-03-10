package com.fmi.micronaut.repository.impl;

import com.fmi.micronaut.data.Client;
import com.fmi.micronaut.repository.ClientRepository;
import io.micronaut.transaction.annotation.ReadOnly;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class ClientRepositoryImpl implements ClientRepository {

    private final EntityManager entityManager;

    public ClientRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @ReadOnly
    public List<Client> findAll() {
        String qlString = "SELECT c FROM Client as c";
        TypedQuery<Client> query = entityManager.createQuery(qlString, Client.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Boolean createClient(Client client) {
        this.entityManager.persist(client);
        return true;
    }
}
