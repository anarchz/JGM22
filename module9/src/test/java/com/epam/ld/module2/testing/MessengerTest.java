package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.template.TemplateEngine;
import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

@ExtendWith(WriteToFileExtention.class)
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
    @DisabledIfEnvironmentVariable(named = "STREAMS", matches = "FALSE")
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

    @Rule
    ExpectedException exception = ExpectedException.none();

    @Test
    @Disabled
    public void sendNullTemplateJUnit4() throws IOException {
        exception.expect(NullPointerException.class);
        messenger = new Messenger(server, templateEngine);
        Client client = spy(new Client());
        messenger.sendMessage(client, null);
    }

    @Test
    @Filtered
    public void sendNullTemplateJupiter() throws IOException {
        messenger = new Messenger(server, templateEngine);
        Client client = spy(new Client());
        Assertions.assertThrows(NullPointerException.class, () -> messenger.sendMessage(client, null));
    }
}
