create table meeting(
    id serial primary key,
    name varchar(255)
);

create table users(
    id serial primary key,
    name varchar(255),
    status boolean,
    meeting_id int references meeting(id)
);

insert into meeting(name) values ('metting java developers');
insert into meeting(name) values ('akvaDiskoteka');
insert into users(name, status, meeting_id) values ('Vika', true, 1);
insert into users(name, status, meeting_id) values ('Masha', true, 1);
insert into users(name, status, meeting_id) values ('Francheska', false, 1);

select meeting.name, count(u) from meeting join users u on meeting.id = u.meeting_id where u.status = true group by meeting.name;
select meeting.name, count(u) from meeting full join users u on meeting.id = u.meeting_id group by meeting.name HAVING count(u) = 0;