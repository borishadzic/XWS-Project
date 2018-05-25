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

-- role-permissions
insert into role_permissions (permission_id, role_id) values (1, 1);
insert into role_permissions (permission_id, role_id) values (2, 1);

-- user-roles
insert into user_roles (user_id, role_id) 
values ((select id from users where email = 'bokih.95@gmail.com'), 1)