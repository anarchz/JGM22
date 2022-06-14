package com.jgm.module7;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(
        locations = "classpath:application-test.properties")
public class RepositoryTest {

    @Test
    public void test() {

    }
}
