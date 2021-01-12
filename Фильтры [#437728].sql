create table type(
                     id serial primary key,
                     name varchar(255)
);

create table product(
                        id serial primary key,
                        name varchar(255),
                        expired_date date,
                        price int,
                        type_id int references type(id)
);

insert into type(name) VALUES ('молочные продукты');
insert into type(name) VALUES ('напитки');
insert into type(name) VALUES ('алкоголь');
insert into type(name) VALUES ('мучные');
insert into type(name) VALUES ('крупы');
insert into type(name) VALUES ('чаи');
insert into type(name) VALUES ('сыр');

insert into product(name, expired_date, price, type_id) VALUES ('Сыр', '10.05.2021', 100, 1);
insert into product(name, expired_date, price, type_id) VALUES ('Адыгейский', '10.02.2021', 150, 7);
insert into product(name, expired_date, price, type_id) VALUES ('Сулгуни', '05.02.2021', 350, 7);
insert into product(name, expired_date, price, type_id) VALUES ('Молоко', '20.01.2021', 150, 1);
insert into product(name, expired_date, price, type_id) VALUES ('Масло', '22.01.2021', 250, 1);
insert into product(name, expired_date, price, type_id) VALUES ('Квас', '22.01.2021', 150, 2);
insert into product(name, expired_date, price, type_id) VALUES ('Вода', '22.01.2021', 50, 2);
insert into product(name, expired_date, price, type_id) VALUES ('Старый мельник', '22.05.2021', 250, 3);
insert into product(name, expired_date, price, type_id) VALUES ('Зеленая марка', '22.05.2025', 550, 3);
insert into product(name, expired_date, price, type_id) VALUES ('Хлеб', '15.01.2021', 50, 4);
insert into product(name, expired_date, price, type_id) VALUES ('Батон', '16.01.2021', 60, 4);
insert into product(name, expired_date, price, type_id) VALUES ('Греча', '15.01.2025', 70, 5);
insert into product(name, expired_date, price, type_id) VALUES ('Принцесса Нури', '15.01.2028', 300, 6);
insert into product(name, expired_date, price, type_id) VALUES ('Восхитительное мороженное', '15.01.2021', 300, 1);
insert into product(name, expired_date, price, type_id) VALUES ('Нарезное мороженное', '15.01.2021', 300, 1);

select * from product join type t on product.type_id = t.id where t.name like '%сыр%';
select * from product where name like '%мороженное%';
select * from product where extract(year from expired_date) = extract(year from now() + interval '1 month') and extract(month from expired_date) = extract(month from now() + interval '1 month');
select * from product where date_trunc('month', expired_date) = date_trunc('month',now() + interval '1 month');
select * from product where product.price = (SELECT MAX(product.price) FROM product);

select t.name as название, count(product.name) as количество from product join type t on product.type_id = t.id group by t.name;

select * from product join type t on product.type_id = t.id where t.name in ('сыр', 'молочные продукты');

select t.name as название, count(product.name) as количество from product join type t on product.type_id = t.id group by t.name having count(product.name) < 10;

select product.name, t.name from product join type t on product.type_id = t.id;