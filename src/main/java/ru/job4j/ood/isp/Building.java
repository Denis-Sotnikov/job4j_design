package ru.job4j.ood.isp;
//Не во всех домах есть паркинг
//Метод  int getQuantityCarAtParking() нарушает прнцип isp.
public interface Building {
   int getAuantityPeople();

   int getQuantityCarAtParking();
}
