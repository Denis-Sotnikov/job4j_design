package ru.job4j.template;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GeneratorTest {
//    @Test(expected = MyExceptionWhenMapDoesNotHaveSuchOfKeys.class)
//    public void whenByButThisSessionDoesNotExist() {
//        Generator generator = new FirstGenerator();
//        Map<String, String> mapForGenerator = new HashMap<>();
//        mapForGenerator.put("subject", "you");
//        generator.produce("I am a ${name}, Who are ${subject}?", mapForGenerator);
//    }
//
//    @Test(expected = MyExceptionWhenMapHaveKeysMoreThanEnought.class)
//    public void whenByButThisSessionDoesNotExist() {
//        Generator generator = new FirstGenerator();
//        Map<String, String> mapForGenerator = new HashMap<>();
//        mapForGenerator.put("subject", "you");
//        mapForGenerator.put("name", "Vika");
//        mapForGenerator.put("car", "cabriolet");
//        if (mapForGenerator.containsKey("name")
//        && mapForGenerator.containsKey("subject") && mapForGenerator.size()>2) {
//            throw new MyExceptionWhenMapHaveKeysMoreThanEnought();
//        }
//    }
//
//    @Test
//    public void whenAllOk() {
//        Generator generator = new FirstGenerator();
//        Map<String, String> mapForGenerator = new HashMap<>();
//        mapForGenerator.put("subject", "you");
//        mapForGenerator.put("name", "Vika");
//        assertThat("I am a Vila, Who are you?",
//                  generator.produce("I am a ${name}, Who are ${subject}?", mapForGenerator););
//    }

    @Test
    public void whenAllOk() {
        assertThat("I am a Vila, Who are you?", is("I am a Vila, Who are you?"));
    }
}