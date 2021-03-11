package com.fmi;

import com.fmi.micronaut.Application;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import spock.lang.Specification;

import javax.inject.Inject;

@MicronautTest(application = Application.class)
class MicronautCrudTest extends Specification {

    @Inject
    EmbeddedApplication<?> application;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }
}
