insert into customers (id, email, password, enabled) values(1, 'admin@test.com', 'admin', 1);
insert into customers (id, email, password, enabled) values(2, 'guest@test.com', 'guest', 1);
insert into customers (id, email, password, enabled) values(3, 'customer@test.com', 'customer', 0);

insert into authorities (id, email, authority) values (1, 'admin@test.com', 'admin-role');
insert into authorities (id, email, authority) values (2, 'guest@test.com', 'guest-role');
