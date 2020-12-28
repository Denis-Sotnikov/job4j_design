package ru.job4j.it;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test
    public void whenAddBeforeStartIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 0, 2);
        assertThat(Arrays.asList(2, 1, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addAfter(input, 0, 2);
        assertThat(input, Is.is(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void whenAddAfterLastIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addAfter(input, 1, 2);
        assertThat(input, Is.is(Arrays.asList(1, 3, 2)));
    }

    @Test
    public void whenPredicatCheckedAnyElementsAndDelete() {
        List<Integer> input = new ArrayList<>(Arrays.asList(4, 2, 5, 7, 8, 2, 22, 131, 157));
        ListUtils.removeIf(input, x -> x % 2 == 0);
        assertThat(input, Is.is(Arrays.asList(5, 7, 131, 157)));
    }

    @Test
    public void whenPredicatCheckedAnyElementsAndReplace() {
        List<Integer> input = new ArrayList<>(Arrays.asList(4, 2, 5, 7, 8, 2, 22, 131, 157));
        ListUtils.replaceIf(input, x -> x % 2 == 0, 8);
        assertThat(input, Is.is(Arrays.asList(8, 8, 5, 7, 8, 8, 8, 131, 157)));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(4, 2, 5, 7, 7, 7, 8, 2, 22, 131, 157));
        List<Integer> input2 = new ArrayList<>(Arrays.asList(4, 2, 5, 7));
        ListUtils.removeAll(input, input2);
        assertThat(input, Is.is(Arrays.asList(8, 22, 131, 157)));
    }
}