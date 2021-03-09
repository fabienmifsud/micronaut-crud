package com.fmi.micronaut.graphql;


import com.fmi.micronaut.data.Client;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.micronaut.security.annotation.Secured;

import java.text.ParseException;
import java.util.List;

@GraphQLService
public class ClientService {

//    @Inject
//    private ClientRepository clientRepository;

    @GraphQLQuery
    @Secured({"USER","ADMIN"})
    public List<Client> clients() {
        return null;
    }

    @GraphQLMutation
    @Secured("ADMIN")
    public Boolean createClient(@GraphQLArgument(name = "name") String name,
                                @GraphQLArgument(name = "email") String email,
                                @GraphQLArgument(name = "dateOfBirth") String dateOfBirth) throws ParseException {
        return null;
    }
}
