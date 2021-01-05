package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "testForConfig.txt";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("password"),
                is("nesokrushimayaStena")
        );
    }

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

    @Test
    public void whenPairWithCommentSecond() {
        String path = "testForConfigWithComment.txt";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("onlyForward")
        );
    }
}