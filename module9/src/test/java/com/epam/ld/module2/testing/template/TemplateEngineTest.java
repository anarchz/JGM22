package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TemplateEngineTest {
    Template template;
    TemplateEngine engine;
    Client client;
    @BeforeEach
    public void setUp() {
        template = new Template();
        engine = new TemplateEngine();
        client = new Client();
    }

    @Test
    public void shouldReplacePlaceholders() {
        template.setSubject("newSubject");
        String result = "Some text: newSubject";
        String message = engine.generateMessage(template, client);
        Assertions.assertEquals(result, message);
    }
}
