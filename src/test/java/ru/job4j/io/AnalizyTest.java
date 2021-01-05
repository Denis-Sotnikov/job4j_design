package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizyTest {
    private List<String> listResult = new LinkedList<>();
    private List<String> listTest = new LinkedList<>();

    @Before
    public void setUp() {
        listTest.add("10:58:01 : 10:59:01");
        listTest.add("11:01:02 : 11:02:02");
    }

    @Test
    public void whenAnalysisJustCase() throws ParseException {
        String path = "server.log";
        String result = "UnavailableServer.log";
        new Analizy().unavailable(path, result);
        try (BufferedReader in = new BufferedReader(new FileReader(result))) {
            List<String> linesis = new ArrayList<String>();
            in.lines().forEach(listResult::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(listResult,
                is(listTest)
        );
    }
}