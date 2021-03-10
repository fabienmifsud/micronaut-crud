package com.fmi.micronaut.graphql;


import com.fmi.micronaut.data.Booking;
import com.fmi.micronaut.data.Client;
import com.fmi.micronaut.data.Product;
import com.fmi.micronaut.repository.BookingRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@GraphQLService
@Secured(SecurityRule.IS_AUTHENTICATED)
public class BookingService {


    @Inject
    private BookingRepository bookingRepository;

    @GraphQLQuery
    @Secured({"USER", "ADMIN"})
    public List<Booking> bookings() {
        return this.bookingRepository.findAll();
    }

    @GraphQLQuery
    @Secured({"USER", "ADMIN"})
    public List<Booking> bookingsByClient(@GraphQLArgument(name = "clientId") Long clientId) {

        return this.bookingRepository.findAllByClient(clientId);
    }

    @GraphQLMutation
    @Secured("ADMIN")
    public Boolean createBooking(@GraphQLArgument(name = "clientId") Long clientId, @GraphQLArgument(name = "productId") Long productId) {

        Booking booking = new Booking();
        booking.setBookingDate(new Date());
        Client client = new Client();
        client.setId(clientId);
        booking.setClient(client);
        Product product = new Product();
        product.setId(productId);
        booking.setProduct(product);

        return this.bookingRepository.createBooking(booking);
    }
}
