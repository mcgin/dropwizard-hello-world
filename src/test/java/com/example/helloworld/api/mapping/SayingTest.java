package com.example.helloworld.api.mapping;

import com.example.helloworld.api.Saying;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

public class SayingTest {
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        final Saying person = new Saying(10, "test content");

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/mappingtests/saying.json"), Saying.class));

        assertThat(MAPPER.writeValueAsString(person)).isEqualTo(expected);
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        final Saying person = new Saying(10, "test content");
        assertThat(MAPPER.readValue(fixture("fixtures/mappingtests/saying.json"), Saying.class))
                .isEqualTo(person);
    }
}
