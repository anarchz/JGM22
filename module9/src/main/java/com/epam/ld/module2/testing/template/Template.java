package com.epam.ld.module2.testing.template;

/**
 * The type Template.
 */
public class Template {
    private String message = "Some text: subject - #{subject}, value - #{value}";
    private String subject;
    private String value;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
