package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;

import java.util.Map;


/**
 * The type Template engine.
 */
public class TemplateEngine {
    /**
     * Generate message string.
     *
     * @param template the template
     * @param client   the client
     * @return the string
     */
    public String generateMessage(Template template, Client client) {
        Map<String, String> values = template.getValues();

        String message = template.getMessage();
        String subject = null;
        String value = null;

        for(Map.Entry<String, String> entry : values.entrySet()) {
            switch(entry.getKey()) {
                case "subject":
                    subject = entry.getValue();
                    break;
                case "value":
                    value = entry.getValue();
                    break;
                default:
                    break;
            }
        }

        String result = message.replace("#{value}", value);
        return result.replace("#{subject}", subject);
    }
}
