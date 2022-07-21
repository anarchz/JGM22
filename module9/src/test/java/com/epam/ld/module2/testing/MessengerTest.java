package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.template.TemplateEngine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mock;
import org.mockito.Spy;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

public class MessengerTest {
    private Messenger messenger;
    @Mock
    private TemplateEngine templateEngine;
    @Mock
    private Template template;
    @Mock
    private MailServer server;

    @TempDir
    public Path tempFolder;

    @TestFactory
    Stream<DynamicTest> dynamicTestStream() {
        List<DynamicTest> dynamicTestList = new ArrayList<>();

        DynamicTest dynamicTest = DynamicTest.dynamicTest("Dynamic test for MailServer",
                () -> {
                    messenger = new Messenger(server, templateEngine);
                    Path tempFile = tempFolder.resolve("outputFile.txt");
                    Client client = spy(new Client());
                    String messageContent = "Some text : subject - Subject, value - Value";

                    doReturn("console").when(client).getAddresses();
                    when(templateEngine.generateMessage(any(), any())).thenReturn(messageContent);

                    messenger.sendMessage(client, template);
                    Assertions.assertEquals(Files.readString(tempFile), messageContent);
                });

        dynamicTestList.add(dynamicTest);
        return dynamicTestList.stream();
    }

    @Test
    public void send() {
        
    }

}
