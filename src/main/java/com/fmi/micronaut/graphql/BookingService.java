package com.fmi.micronaut.graphql;



import com.fmi.micronaut.data.Booking;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.micronaut.security.annotation.Secured;

import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import java.util.List;

@GraphQLService
public class BookingService {


//    @Inject
//    private BookingRepository bookingRepository;

    @GraphQLQuery
    @Secured({"USER","ADMIN"})
    public List<Booking> bookings() {
        return null;
    }

    @GraphQLQuery
    @Secured({"USER","ADMIN"})
    public List<Booking> bookingsByClient(Long clientId) {
        return null;
    }

    @GraphQLMutation
    @Secured("ADMIN")
    public Boolean createBooking(Long clientId, Long productId) {
        return null;
    }
}
