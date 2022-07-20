package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;


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
        String message = template.getMessage();
        String subject = template.getSubject();
        String value = template.getValue();

        String result = message.replace("#{value}", value);
        return result.replace("#{subject}", subject);
    }
}
