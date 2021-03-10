package com.fmi.micronaut.graphql;


import com.fmi.micronaut.data.Product;
import com.fmi.micronaut.repository.ProductRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import javax.inject.Inject;
import java.util.List;

@GraphQLService
@Secured(SecurityRule.IS_AUTHENTICATED)
public class ProductService {

    @Inject
    private ProductRepository productRepository;

    @GraphQLQuery
    @Secured({"USER", "ADMIN"})
    public List<Product> products() {
        return this.productRepository.findAll();
    }

    @GraphQLMutation
    @Secured("ADMIN")
    public Boolean createProduct(@GraphQLArgument(name = "name") String name,
                                 @GraphQLArgument(name = "price") Double price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);

        return this.productRepository.createProduct(product);
    }
}
