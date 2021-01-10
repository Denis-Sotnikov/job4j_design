create database houses;
create table houses(
  id serial primary key,
  name varchar(255),
  area text,
  quantityFloors int,
  heatingSystem text
);
insert into houses (name, area, quantityFloors, heatingSystem)
                    VALUES ('Practikal house', 'Leningradskaya area',
                            1, 'geotermal heating');
select * from houses;
update houses set quantityFloors = '2';
delete from houses