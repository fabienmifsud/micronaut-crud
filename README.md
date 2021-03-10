# Spring Boot Crud with Postgres & DGS GraphQL

This project is aimed to quickly test the stack :

- Micronaut (https://micronaut.io/)
- Micronaut GraphQL with SPQR (https://micronaut-projects.github.io/micronaut-graphql/latest/guide/
  and https://github.com/leangen/graphql-spqr)
- Micronaut JPA Postgres (https://guides.micronaut.io/micronaut-data-access-jpa-hibernate/guide/index.html)
- Database initialisation with Flyway (https://micronaut-projects.github.io/micronaut-flyway/latest/guide/index.html)
- Micronaut Security Basic Auth (https://guides.micronaut.io/micronaut-security-basicauth/guide/index.html)

## Clone & build

- Tests are executed on an h2 database (Work in progress)
- Simply `mvn clean install` it

## Run it

You can run the app with a local postgres database by

- running `docker run --name some-postgres -p 5432:5432 -e POSTGRES_PASSWORD=mysecretpassword -d postgres`
- Launch the `Application.class`
- Two users are available with Basic Auth :
    - standardUser (read only)
    - adminUser (create & read)

## GraphQl queries

```graphql
# Sample Queries available for users : standardUser, adminUser : 
query readClients {
    clients{
        id,
        name,
        email,
        dateOfBirth
    }
}

query readProducts {
    products{
        name,
        price
    }
}

query readBookings {
    bookings{
        product {
            name
        },
        client {
            name
        },
        bookingDate
    }
}

query readBookingsByClient {
    bookingsByClient (clientId: 1){
        product {
            name
        }
        bookingDate
    }
}

# Sample Mutations available for users : adminUser : 
mutation createClient {
    createClient(name: "toto3", email: "my.email@toto.com", dateOfBirth: "1986-01-17 00:12:12.000")
}

mutation createProduct {
    createProduct(name: "produit2", price: 10.45)
}

mutation createBooking {
    createBooking(productId: 2, clientId: 2)
}
```

Same app with other stacks :

- https://github.com/fabienmifsud/quarkus-crud
- https://github.com/fabienmifsud/spring-boot-crud