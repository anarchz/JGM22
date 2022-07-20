package com.epam.ld.module2.testing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Mail server class.
 */
public class MailServer {

    /**
     * Send notification.
     *
     * @param addresses  the addresses
     * @param messageContent the message content
     */
    public void send(String addresses, String messageContent) throws IOException {
        if(!addresses.equals("console")) {
            Files.writeString(Path.of(addresses), messageContent);
        } else {
            System.out.println(messageContent);
        }
    }
}
