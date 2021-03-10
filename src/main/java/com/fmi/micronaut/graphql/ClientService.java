package com.fmi.micronaut.graphql;


import com.fmi.micronaut.data.Client;
import com.fmi.micronaut.repository.ClientRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import org.apache.commons.lang3.time.DateUtils;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import java.text.ParseException;
import java.util.List;

@GraphQLService
@Secured(SecurityRule.IS_AUTHENTICATED)
public class ClientService {

    @Inject
    private ClientRepository clientRepository;

    @GraphQLQuery
//    @RolesAllowed({"USER","ADMIN"})
    public List<Client> clients() {
        return this.clientRepository.findAll();
    }

    @GraphQLMutation
    @RolesAllowed("ADMIN")
    public Boolean createClient(@GraphQLArgument(name = "name") String name,
                                @GraphQLArgument(name = "email") String email,
                                @GraphQLArgument(name = "dateOfBirth") String dateOfBirth) throws ParseException {

        Client client = new Client();
        client.setEmail(email);
        client.setName(name);
        if (dateOfBirth != null) {
            client.setDateOfBirth(DateUtils.parseDate(dateOfBirth, "yyyy-MM-dd HH:mm:ss.SSS"));
        }

        return this.clientRepository.createClient(client);
    }
}
