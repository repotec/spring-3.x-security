insert into customers (id, email, password, enabled) values(1, 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 1);
insert into customers (id, email, password, enabled) values(2, 'guest', 'guest', 1);
insert into customers (id, email, password, enabled) values(3, 'customer', 'customer', 0);

insert into authorities (id, email, authority) values (1, 'admin', 'admin-role');
insert into authorities (id, email, authority) values (2, 'guest', 'guest-role');
