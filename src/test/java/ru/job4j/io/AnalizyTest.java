package ru.job4j.io;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    private List<String> listResult = new LinkedList<>();
    private List<String> listTest = new LinkedList<>();

    @Before
    public void setUp() {
        listTest.add("10:58:01 : 10:59:01");
        listTest.add("11:01:02 : 11:02:02");
    }

    @Test
    public void when() throws ParseException, IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
             out.println("200 10:56:01");
             out.println("200 10:57:01");
             out.println("400 10:58:01");
             out.println("200 10:59:01");
             out.println("500 11:01:02");
             out.println("200 11:02:02");
        }
        new Analizy().unavailable(source, target);
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
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