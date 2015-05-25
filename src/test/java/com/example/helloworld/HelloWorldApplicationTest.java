package com.example.helloworld;

import com.codahale.metrics.health.HealthCheckRegistry;
import com.example.helloworld.resources.HelloWorldResource;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Environment;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HelloWorldApplicationTest {

    private final Environment environment = mock(Environment.class);
    private final JerseyEnvironment jersey = mock(JerseyEnvironment.class);
    private final HealthCheckRegistry healthChecks = mock(HealthCheckRegistry.class);
    private final HelloWorldApplication application = new HelloWorldApplication();
    private final HelloWorldConfiguration config = new HelloWorldConfiguration();

    @Before
    public void setUp() throws Exception {
        config.setDefaultName("boom");
        config.setTemplate("aTemplate");
        when(environment.jersey()).thenReturn(jersey);
        when(environment.healthChecks()).thenReturn(healthChecks);
    }

    @Test
    public void buildsAnHelloWorldResource() throws Exception {
        application.run(config, environment);
        verify(jersey).register(isA(HelloWorldResource.class));
    }
}