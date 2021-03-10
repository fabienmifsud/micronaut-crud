package com.fmi.micronaut.repository;

import com.fmi.micronaut.data.Booking;

import java.util.List;

public interface BookingRepository {

    List<Booking> findAll();

    Boolean createBooking(Booking booking);

    List<Booking> findAllByClient(Long clientId);
}
