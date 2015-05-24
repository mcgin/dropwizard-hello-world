package com.example.helloworld.resources;

import com.google.common.base.Optional;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Aidan on 24/05/2015.
 */
public class HelloWorldResourceTest {
    @Test
    public void testResourceDefaults() {
        HelloWorldResource resource = new HelloWorldResource("Boom %s", "aDefaultValue");

        Assert.assertEquals("Boom aDefaultValue", resource.sayHello(Optional.<String>absent()).getContent());
    }

    @Test
    public void testResourceWithAValue() {
        HelloWorldResource resource = new HelloWorldResource("Boom %s", "aDefaultValue");

        Assert.assertEquals("Boom boom",resource.sayHello(Optional.of("boom")).getContent());
    }
}