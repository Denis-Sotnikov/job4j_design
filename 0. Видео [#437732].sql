create table departments(
                       id serial primary key,
                       name varchar(255)
);

create table emploees(
                        id serial primary key,
                        name varchar(255),
                        departments_id int references departments(id)
);

insert into departments(name) values ('Masterskaya');
insert into departments(name) values ('Konstruktorskoye buro');
insert into departments(name) values ('Market');

insert into emploees(name, departments_id) values ('Vika', 1);
insert into emploees(name, departments_id) values ('Natasha', 2);
insert into emploees(name, departments_id) values ('Olga', 1);
insert into emploees(name, departments_id) values ('Nastya', 3);
insert into emploees(name, departments_id) values ('Ira', 1);
insert into emploees(name, departments_id) values ('Jesika', 2);
insert into emploees(name) values ('Veronika');

select * from departments left join emploees e on departments.id = e.departments_id;
select * from departments right join emploees e on departments.id = e.departments_id;
select * from departments cross join emploees;
select * from emploees left join departments d on emploees.id = d.id where emploees.departments_id is null;

select * from departments left join emploees e on departments.id = e.departments_id where e.departments_id is not null;
select * from departments right join emploees e on departments.id = e.departments_id where e.departments_id is not null;

create table teens(
                         id serial primary key,
                         name varchar(255),
                         gender varchar(255)
);

insert into teens(name, gender) VALUES ('Veronika', 'female');
insert into teens(name, gender) VALUES ('Siremo', 'female');
insert into teens(name, gender) VALUES ('Law', 'female');
insert into teens(name, gender) VALUES ('Mia', 'female');
insert into teens(name, gender) VALUES ('Spartanec', 'male');
insert into teens(name, gender) VALUES ('Straj', 'male');
insert into teens(name, gender) VALUES ('Leon', 'male');
insert into teens(name, gender) VALUES ('Neo', 'male');

select * from teens t1 cross join teens t2 where t1.gender = 'female' and t2.gender = 'male';