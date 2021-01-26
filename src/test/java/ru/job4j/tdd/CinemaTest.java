package ru.job4j.tdd;

import static org.junit.Assert.*;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;

public class CinemaTest {

    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Test(expected = MyExceptionWhenByButThisSessionDoesNotExist.class)
    public void whenByButThisSessionDoesNotExist() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date); // выпадет исключение
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test(expected = MyExceptionWhenThisCinemaHaveAlreadyBeenHere.class)
    public void whenThisCinemaHaveAlreadyBeenHere() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        Cinema cinema2 = new Cinema3D();
        cinema.add(new Session3D()); // выпадет исключение так как пытаемся добавить дубль объекта.
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Test(expected = MyExceptionWhenSuchSessionDoesNotExist.class)
    public void whenSuchSessionDoesNotExist() {
        List<Session> sessions = cinema.find(session -> true); // выпадет исключение - нет такого сеанса
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }
}