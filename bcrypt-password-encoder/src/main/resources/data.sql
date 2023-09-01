insert into users (id, username, password, enabled) values(1, 'admin', '$2a$12$mURBOyeGhCWq4irWaSiF8O7xIB9LU7nnWLI5qC320WTpRNILItp4K', 1);
insert into users (id, username, password, enabled) values(2, 'guest', 'guest', 1);
insert into users (id, username, password, enabled) values(3, 'customer', 'customer', 0);

insert into authorities (id, username, authority) values (1, 'admin', 'admin-role');
insert into authorities (id, username, authority) values (2, 'guest', 'guest-role');
