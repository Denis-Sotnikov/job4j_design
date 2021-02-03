CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

insert into company(id, name) values (1, 'samsung');
insert into company(id, name) values (2, 'lg');
insert into company(id, name) values (3, 'apple');
insert into company(id, name) values (4, 'facebook');
insert into company(id, name) values (5, 'tesla');

select p.name, c.name from person p join company c on p.company_id = c.id where company_id != 5;

CREATE VIEW resultTable AS select c.name, count(p) as quantity from company c join person p on c.id = p.company_id group by c.name;

select name, quantity from resultTable as foo where quantity = (select max(quantity) from resultTable);
