insert into users (user_id, user_name, password, enabled) values(1, 'admin', 'admin', 1);
insert into users (user_id, user_name, password, enabled) values(2, 'guest', 'guest', 1);

insert into roles (role_id, role_name) values (1, 'ADMIN');
insert into roles (role_id, role_name) values (2, 'GUEST');

insert into user_roles (user_role_id, user_id, role_id) values (1, 1, 1);
insert into user_roles (user_role_id, user_id, role_id) values (2, 2, 2);
