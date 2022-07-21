package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.template.TemplateEngine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {
        MailServer mailServer = new MailServer();
        TemplateEngine templateEngine = new TemplateEngine();
        Messenger messenger = new Messenger(mailServer, templateEngine);

        Client client = new Client();
        Template template = new Template();
        Map<String, String> values = new HashMap<>();

        Scanner scanner;
        if(args.length == 0) {
            scanner = new Scanner(System.in);
            String ent = scanner.nextLine();
            while(!ent.equals("X")) {
                String[] entryValues = ent.split("=");
                values.put(entryValues[0], entryValues[1]);
                ent = scanner.nextLine();
            }
            client.setAddresses("console");
        } else {
            scanner = new Scanner(new File("resources/inputFile.txt"));
            while(!scanner.nextLine().equals("X")) {
                String ent = scanner.next();
                String[] entryValues = ent.split("=");
                values.put(entryValues[0], entryValues[1]);
            }
            client.setAddresses("resources/outputFile.txt");
        }
        template.setValues(values);
        template.setMessage("Some text: subject - #{subject}, value - #{value}");
        messenger.sendMessage(client, template);
    }
}
