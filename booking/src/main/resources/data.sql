-- permissions
insert into permission (id, name) values (1, 'CREATE');
insert into permission (id, name) values (2, 'READ');

-- roles
insert into roles (id, name) values (1, 'ROLE_ADMIN');
insert into roles (id, name) values (2, 'ROLE_AGENT');
insert into roles (id, name) values (3, 'ROLE_USER');

-- users
insert into users (id, email, enabled, password) 
values (UUID(), 'bokih.95@gmail.com', 1, '$2a$10$8bH9N7jBJo6XNlfR.mKhYeD9yoWGJJXJ.rOaCgftdn5SdSwZaOlfq');
insert into users (id, email, enabled, password) 
values (UUID(), 'darkokirin@gmail.com', 1, '$2a$10$uZzqU5v.G10pFySkUUIbXuNDukV//c19dBD/hiqbYSgyP8pbhTxh2');


-- role-permissions
insert into role_permissions (permission_id, role_id) values (1, 1);
insert into role_permissions (permission_id, role_id) values (2, 1);

-- user-roles
insert into user_roles (user_id, role_id) 
values ((select id from users where email = 'bokih.95@gmail.com'), 1);
insert into user_roles (user_id, role_id) 
values ((select id from users where email = 'darkokirin@gmail.com'), 1);

-- accomodation types
insert into accomodation_type (type) values ('apartment');
insert into accomodation_type (type) values ('bed&breakfast');
insert into accomodation_type (type) values ('hotel');

-- additional services
insert into additional_service (name) values ('Parking');
insert into additional_service (name) values ('Wifi');
insert into additional_service (name) values ('Breakfast');
insert into additional_service (name) values ('Polupansion');
insert into additional_service (name) values ('Pansion');
insert into additional_service (name) values ('TV');
insert into additional_service (name) values ('Mini kuhinja/kuhinja');
insert into additional_service (name) values ('Privatno kupatilo');

-- test data
-- insert into accomodation (id, address, capacity, city, country, description, name, type_id)
-- values (1, 'Lozionicka 12', 4, 'Novi Sad', 'Srbija', 'Opis', 'Sheraton', 1) ;
-- insert into accomodation_image values (1, 'url1', 1);
-- insert into accomodation_image values (2, 'url2', 1);