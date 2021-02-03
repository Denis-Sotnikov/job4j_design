CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer,
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into person(id, name, company_id) values (1, 'Vika', 1);
insert into person(id, name, company_id) values (2, 'Francheska', 2);
insert into person(id, name, company_id) values (3, 'Nastya', 3);
insert into person(id, name, company_id) values (4, 'Olga', 4);
insert into person(id, name, company_id) values (5, 'Masha', 5);
insert into person(id, name, company_id) values (6, 'Natasha', 6);
insert into person(id, name, company_id) values (7, 'Katya', 7);