create table devices(
                        id serial primary key,
                        name varchar(255),
                        price float
);

create table people(
                       id serial primary key,
                       name varchar(255)
);

create table devices_people(
                               id serial primary key,
                               device_id int references devices(id),
                               people_id int references people(id)
);

insert into devices (name, price) VALUES ('computer', 100);
insert into devices (name, price) VALUES ('watch', 400);
insert into devices (name, price) VALUES ('phone', 550);
insert into devices (name, price) VALUES ('scaner', 50);
insert into devices (name, price) VALUES ('teleport', 1000);
insert into devices (name, price) VALUES ('teodolit', 850);
insert into devices (name, price) VALUES ('taheometr', 10000);
insert into devices (name, price) VALUES ('nivelir', 10);

insert into people (name) VALUES ('Tanya');
insert into people (name) VALUES ('Nika');
insert into people (name) VALUES ('Francheska');
insert into people (name) VALUES ('Mishel');

insert into devices_people (device_id, people_id) values (1, 1);
insert into devices_people (device_id, people_id) values (3, 1);
insert into devices_people (device_id, people_id) values (5, 1);
insert into devices_people (device_id, people_id) values (2, 1);

insert into devices_people (device_id, people_id) values (6, 2);
insert into devices_people (device_id, people_id) values (2, 2);
insert into devices_people (device_id, people_id) values (4, 2);
insert into devices_people (device_id, people_id) values (1, 2);

insert into devices_people (device_id, people_id) values (7, 3);
insert into devices_people (device_id, people_id) values (8, 3);

insert into devices_people (device_id, people_id) values (5, 4);

select avg(d.price) from devices as d;
select p.name, avg(d.price) from devices_people join devices d on devices_people.device_id = d.id join people p on devices_people.people_id = p.id
group by p.name;

select p.name, avg(d.price) from devices_people join devices d on devices_people.device_id = d.id join people p on devices_people.people_id = p.id
group by p.name
having avg(d.price) > 5000;