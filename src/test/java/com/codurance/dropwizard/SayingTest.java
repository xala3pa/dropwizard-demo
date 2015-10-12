package com.codurance.dropwizard;

import com.codurance.dropwizard.core.Saying;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SayingTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        final Saying saying = new Saying(1, "Hello world!");

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/test.json"), Saying.class));

        assertThat(MAPPER.writeValueAsString(saying)).isEqualTo(expected);
    }
}