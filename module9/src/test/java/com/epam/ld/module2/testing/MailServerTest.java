package com.epam.ld.module2.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MailServerTest {
    MailServer server;
    String content = "Some text";

    @TempDir
    public Path tempFolder;

    @ParameterizedTest
    @ValueSource(strings = {"outputFile.txt"})
    @Filtered
    public void sendToFile(String fileName) throws IOException {
        Path tempFile = tempFolder.resolve(fileName);
        server.send(String.valueOf(tempFile), content);
        Assertions.assertEquals(Files.readString(tempFile), content);
    }

    @ParameterizedTest
    @ValueSource(strings = {"outputFile.txt"})
    public void sendToConsole(String fileName) throws IOException {
        Path tempFile = tempFolder.resolve(fileName);
        server.send("console", content);
        Assertions.assertTrue(Files.readString(tempFile).isEmpty());
    }
}
