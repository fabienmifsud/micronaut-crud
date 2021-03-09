package com.fmi.micronaut.graphql;


import com.fmi.micronaut.data.Product;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.micronaut.security.annotation.Secured;

import java.util.List;

@GraphQLService
public class ProductService {

//    @Inject
//    private ProductRepository productRepository;

    @GraphQLQuery
    @Secured({"USER","ADMIN"})
    public List<Product> products() {
        return null;
    }

    @GraphQLMutation
    @Secured("ADMIN")
    public Boolean createProduct(@GraphQLArgument(name = "name") String name,
                                 @GraphQLArgument(name = "price") Double price) {
        return null;
    }
}
