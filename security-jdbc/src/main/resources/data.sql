insert into USERS (id, username, password, enabled) values(1, 'admin', 'admin', 1);
insert into USERS (id, username, password, enabled) values(2, 'guest', 'guest', 1);
insert into USERS (id, username, password, enabled) values(3, 'customer', 'customer', 0);

insert into authorities (id, username, authority) values (1, 'admin', 'admin-role');
insert into authorities (id, username, authority) values (2, 'guest', 'guest-role');
