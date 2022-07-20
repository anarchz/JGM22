package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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
        Map<String, String> values = new HashMap<>();
        values.put("subject", "newSubject");
        values.put("value", "newValue");
        template.setMessage("Some text: subject - #{subject}, value - #{value}");
        template.setValues(values);
        String result = "Some text: subject - newSubject, value - newValue";
        String message = engine.generateMessage(template, client);
        Assertions.assertEquals(result, message);
    }

    @Test
    public void placeholdersNotProvided() {
        Map<String, String> values = new HashMap<>();
        values.put("value", "newValue");
        template.setMessage("Some text: subject - #{subject}, value - #{value}");
        template.setValues(values);
        Assertions.assertThrows(NullPointerException.class, () -> engine.generateMessage(template, client));
    }

    @Test
    public void ignorePlaceholdersNotFound() {
        Map<String, String> values = new HashMap<>();
        values.put("subject", "newSubject");
        values.put("value", "newValue");
        values.put("notFoundValue", "notFoundValue");
        template.setMessage("Some text: subject - #{subject}, value - #{value}");
        template.setValues(values);
        String result = "Some text: subject - newSubject, value - newValue";
        String message = engine.generateMessage(template, client);
        Assertions.assertEquals(result, message);
    }

    @Test
    public void shouldReplaceValueWithPlaceholders() {
        Map<String, String> values = new HashMap<>();
        values.put("subject", "newSubject");
        values.put("value", "#{tag}");
        template.setMessage("Some text: subject - #{subject}, value - #{value}");
        template.setValues(values);
        String result = "Some text: subject - newSubject, value - #{tag}";
        String message = engine.generateMessage(template, client);
        Assertions.assertEquals(result, message);
    }
}
