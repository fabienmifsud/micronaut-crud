package com.fmi.micronaut.repository.impl;

import com.fmi.micronaut.data.Booking;
import com.fmi.micronaut.repository.BookingRepository;
import io.micronaut.transaction.annotation.ReadOnly;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class BookingRepositoryImpl implements BookingRepository {

    private final EntityManager entityManager;

    public BookingRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @ReadOnly
    public List<Booking> findAll() {
        String qlString = "SELECT b FROM Booking as b";
        TypedQuery<Booking> query = entityManager.createQuery(qlString, Booking.class);
        return query.getResultList();
    }

    @Override
    @ReadOnly
    public List<Booking> findAllByClient(Long clientId) {
        String qlString = "SELECT b FROM Booking as b ORDER BY b.client.id desc";
        TypedQuery<Booking> query = entityManager.createQuery(qlString, Booking.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Boolean createBooking(Booking booking) {
        this.entityManager.persist(booking);
        return true;
    }
}
