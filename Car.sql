create DATABASE machine_torage;

create table body(
    id serial primary key,
    name varchar(255)
);

create table engine(
    id serial primary key,
    name varchar(255),
    power int
);

create table transmission(
    id serial primary key,
    name varchar(255),
    quantity_of_steps int
);


ALTER table transmission add column id serial primary key;
ALTER table body add column id serial primary key;
ALTER table body add column save int;
ALTER table engine add column id serial primary key;

create table car(
     name varchar(255),
     color varchar(255),
     transmission_id int references transmission(id),
     engine_id int references engine(id),
     body_id int references body(id)
);

insert into transmission(name, quantity_of_steps) VALUES ('dsg', 8);
insert into transmission(name, quantity_of_steps) VALUES ('mehanic', 6);
insert into transmission(name, quantity_of_steps) VALUES ('variator', 10);
insert into transmission(name, quantity_of_steps) VALUES ('variator-eco', 15);

insert into body(name) VALUES ('kabriolet');
insert into body(name) VALUES ('sedan');
insert into body(name) VALUES ('universal');
insert into body(name) VALUES ('combi');

insert into engine(name, power) VALUES ('dvs', 80);
insert into engine(name, power) VALUES ('dvs', 150);
insert into engine(name, power) VALUES ('gibrid', 200);
insert into engine(name, power) VALUES ('electro', 300);
insert into engine(name, power) VALUES ('electro-eco', 100);

insert into car(name, color, transmission_id, engine_id, body_id) values ('lada vesta', 'blue', 2, 1, 2);
insert into car(name, color, transmission_id, engine_id, body_id) values ('tesla model s', 'red', 3, 4, 2);
insert into car(name, color, transmission_id, engine_id, body_id) values ('ford mustang', 'black', 2, 2, 2);
insert into car(name, color, transmission_id, engine_id, body_id) values ('toyota prius', 'white', 1, 3, 3);
insert into car(name, color, transmission_id, engine_id, body_id) values ('mercedes', 'blue', 2, 1, 2);

-- вывод всех автомобилей и их частей
select * from car left join body b on car.body_id = b.id left join engine e on car.engine_id = e.id left join transmission t on car.transmission_id = t.id;
-- вывод отдельно кузовов которые неиспользуются в авто
select * from car right join body b on car.body_id = b.id where car.body_id is null;
-- вывод отдельно трансмиссий которые неиспользуются в авто
select * from car right join transmission t on car.transmission_id = t.id where car.transmission_id is null;
-- вывод отдельно двигателей которые неиспользуются в авто
select * from car right join engine e on car.engine_id = e.id where car.engine_id is null;

select * from car right join body b on car.body_id = b.id join transmission t on car.transmission_id = t.id join engine e on car.engine_id = e.id;
