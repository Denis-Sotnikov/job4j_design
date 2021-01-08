package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithCommentFirst() {
        String path = "testForConfigWithComment.txt";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("password"),
                isEmptyOrNullString()
        );
    }
}