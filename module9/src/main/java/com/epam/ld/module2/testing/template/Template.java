package com.epam.ld.module2.testing.template;

/**
 * The type Template.
 */
public class Template {
    private String message = "Some text: #{subject}";
    private String subject;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
