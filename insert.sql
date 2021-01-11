insert into rulesroles (name) VALUES ('Edit');
insert into rulesroles (name) VALUES ('OnlyRead');
insert into roles (name, rulesroles_id) VALUES ('User', 2);
insert into roles (name, rulesroles_id) VALUES ('Admin', 1);
insert into users (name, role_id) VALUES ('Vika', 1);
insert into users (name, role_id) VALUES ('Masha', 2);
insert into statusOfRequest (name) VALUES ('done');
insert into statusOfRequest (name) VALUES ('waiting');
insert into categoryOfRequest (name) VALUES ('repair');
insert into categoryOfRequest (name) VALUES ('delivery');
insert into categoryOfRequest (name) VALUES ('payout');
insert into request (name, user_id, category_id, status_of_request_id) VALUES ('give me my Salary', 1, 3, 2);
insert into request (name, user_id, category_id, status_of_request_id) VALUES ('sent my mail', 2, 2, 1);
insert into commentariesofrequest (name, requests_id) VALUES ('fast', 1);
insert into commentariesofrequest (name, requests_id) VALUES ('you can do it slowly', 2);
insert into attachedFiles (name, requests_id) VALUES ('list about successful tasks', 1);
insert into attachedFiles (name, requests_id) VALUES ('necessary for effective job', 2);

