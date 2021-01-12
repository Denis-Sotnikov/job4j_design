create table houses (
    id serial primary key,
    name varchar(255),
    area text,
    quantityfloors integer,
    heatingsystem  text
);

create table necessary_work(
  id serial primary key,
  type_of_work varchar(255),
  id_house int references houses(id)
);

insert into houses (name, area, quantityfloors, heatingsystem) VALUES ('Light', 125, 2, 'geotermal');
insert into houses (name, area, quantityfloors, heatingsystem) VALUES ('Your walls', 150, 1, 'air');
insert into houses (name, area, quantityfloors, heatingsystem) VALUES ('Online', 100, 1, 'electricity');
insert into houses (name, area, quantityfloors, heatingsystem) VALUES ('Sky', 125, 1, 'firewood');
insert into houses (name, area, quantityfloors, heatingsystem) VALUES ('Sea', 75, 1, 'air');
insert into houses (name, area, quantityfloors, heatingsystem) VALUES ('Earth', 225, 1, 'air');
insert into houses (name, area, quantityfloors, heatingsystem) VALUES ('Fire', 110, 1, 'air');


insert into necessary_work (type_of_work, id_house) VALUES ('repair walls', 2);
insert into necessary_work (type_of_work, id_house) VALUES ('repair walls', 4);
insert into necessary_work (type_of_work, id_house) VALUES ('montage system ventilation', 2);
insert into necessary_work (type_of_work, id_house) VALUES ('installation of insulation', 2);
insert into necessary_work (type_of_work, id_house) VALUES ('increasing water pressure up to 3 atmospheres', 2);

insert into necessary_work (type_of_work, id_house) VALUES ('repair walls', 5);
insert into necessary_work (type_of_work, id_house) VALUES ('montage system ventilation', 3);
insert into necessary_work (type_of_work, id_house) VALUES ('installation of insulation', 6);
insert into necessary_work (type_of_work, id_house) VALUES ('increasing water pressure up to 3 atmospheres', 3);

select * from necessary_work n inner join houses h on n.id_house = h.id;
select h.id, h.name, n.type_of_work from necessary_work n inner join houses h on n.id_house = h.id;
select h.name as Название_дома , h.area as Площадь, n.type_of_work as Тип_работ from necessary_work n inner join houses h on n.id_house = h.id;