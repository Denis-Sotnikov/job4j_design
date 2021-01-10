package ru.job4j.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizeTest {
    private List<Analize.User> first = new ArrayList<>();
    private List<Analize.User> second = new ArrayList<>();

    @Before
    public void setUp() {
        first.add(new Analize.User(1, "Sergey"));
        first.add(new Analize.User(2, "Vadim"));
        first.add(new Analize.User(3, "Denis"));
        first.add(new Analize.User(4, "Vika"));
        first.add(new Analize.User(5, "Olga"));
        first.add(new Analize.User(6, "Sasha"));
        first.add(new Analize.User(7, "Nastya"));
        first.add(new Analize.User(8, "Stasya"));

        second.add(new Analize.User(1, "Sergey"));
        second.add(new Analize.User(2, "Nika"));
        second.add(new Analize.User(3, "Denis"));
        second.add(new Analize.User(4, "Vika"));
        second.add(new Analize.User(5, "Francheska"));
        second.add(new Analize.User(6, "Sasha"));
        second.add(new Analize.User(7, "Nastya"));
        second.add(new Analize.User(10, "Polina"));
    }

    @Test
    public void whenWeDidEverything() {
        Analize.Info info = new Analize().diff(first, second);
        assertThat(info.getAdded(), is(1));
        assertThat(info.getChanged(), is(2));
        assertThat(info.getDeleted(), is(1));
    }

}