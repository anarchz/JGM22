package com.epam.ld.module2.testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MailServerTest {
    MailServer server;
    String content = "Some text";

    @TempDir
    public Path tempFolder;

    @Test
    public void sendToFile() throws IOException {
        Path tempFile = tempFolder.resolve("outputFile.txt");
        server.send(String.valueOf(tempFile), content);
        Assertions.assertEquals(Files.readString(tempFile), content);
    }

    @Test
    public void sendToConsole() throws IOException {
        Path tempFile = tempFolder.resolve("outputFile.txt");
        server.send("console", content);
        Assertions.assertTrue(Files.readString(tempFile).isEmpty());
    }
}
