insert into users (user_id, user_name, password, enabled) values(1, 'admin', '$2a$12$mURBOyeGhCWq4irWaSiF8O7xIB9LU7nnWLI5qC320WTpRNILItp4K', 1);
insert into users (user_id, user_name, password, enabled) values(2, 'guest', 'guest', 1);

insert into roles (role_id, role) values (1, 'ADMIN');
insert into roles (role_id, role) values (2, 'GUEST');
