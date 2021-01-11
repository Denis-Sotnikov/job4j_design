create table Users(
  id serial primary key,
  name varchar(255)
);
create table Roles(
  id serial primary key,
  name varchar(255)
);
create table RulesRoles(
  id serial primary key,
  name varchar(255)
);
create table Request(
  id serial primary key,
  name varchar(255)
);
create table CommentariesOfRequest(
  id serial primary key,
  name varchar(255)
);
create table attachedFiles(
  id serial primary key,
  name varchar(255)
);
create table statusOfRequest(
  id serial primary key,
  name varchar(255)
);
create table categoryOfRequest(
  id serial primary key,
  name varchar(255)
);

ALTER TABLE users ADD COLUMN role_id int;
ALTER TABLE users ADD FOREIGN KEY (role_id)
    REFERENCES roles(id);

ALTER TABLE roles ADD COLUMN rulesroles_id int;
ALTER TABLE roles ADD FOREIGN KEY (rulesroles_id)
    REFERENCES rulesroles(id);

ALTER TABLE request ADD COLUMN user_id int;
ALTER TABLE request ADD FOREIGN KEY (user_id)
    REFERENCES users(id);

ALTER TABLE request ADD COLUMN commentaries_of_requests_id int;
ALTER TABLE request ADD FOREIGN KEY (commentaries_of_requests_id)
    REFERENCES CommentariesOfRequest(id);

ALTER TABLE request DROP COLUMN commentaries_of_requests_id;

ALTER TABLE CommentariesOfRequest ADD COLUMN requests_id int;
ALTER TABLE CommentariesOfRequest ADD FOREIGN KEY (requests_id)
    REFERENCES request(id);

ALTER TABLE attachedFiles ADD COLUMN requests_id int;
ALTER TABLE attachedFiles ADD FOREIGN KEY (requests_id)
    REFERENCES request(id);

ALTER TABLE Request ADD COLUMN category_id int;
ALTER TABLE Request ADD FOREIGN KEY (category_id)
    REFERENCES categoryOfRequest(id);

ALTER TABLE Request ADD COLUMN status_of_request_id int;
ALTER TABLE Request ADD FOREIGN KEY (status_of_request_id)
    REFERENCES statusOfRequest(id);

create table roles_and_rulesroles(
    id serial primary key,
    roles_id int references roles(id),
    rulseroles_id int references rulesroles(id)
);