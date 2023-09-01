insert into users (user_id, user_name, password, enabled) values(1, 'admin', '$2a$10$aTSLPptdbWs1kmXCsNJV2uoEA5B2m.LDvD5AcUElAtDB7CzKXydl2', 1);
insert into users (user_id, user_name, password, enabled) values(2, 'guest', '$2a$10$988iVcS8I/aLq07uBcI5POADPuuzldtRTQ4otb6VKZnDVcqvDxDLC', 1);

insert into roles (role_id, role_name) values (1, 'ADMIN');
insert into roles (role_id, role_name) values (2, 'GUEST');

insert into user_roles (user_role_id, user_id, role_id) values (1, 1, 1);
insert into user_roles (user_role_id, user_id, role_id) values (2, 2, 2);