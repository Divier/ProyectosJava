create table users (id bigint not null auto_increment, username varchar(45) not null, password varchar(60) not null, enabled tinyint not null default 1, unique key (username), primary key (id)) engine=InnoDB;
create table authorities (id bigint not null auto_increment, user_id bigint not null, authority varchar(45) not null, unique key unique_user_id_authority (user_id, authority), primary key (id)) engine=InnoDB;
alter table authorities add constraint fk_authorities_user foreign key (user_id) references users (id);

INSERT INTO users (id, username, password, enabled) VALUES(1, 'andres', '$2a$10$OcU.Bb/./fhJ6SapJ8aQae1Mxcr6Zh1tuKKSFE.34jP1j3RspxJJK', 1);
INSERT INTO users (id, username, password, enabled) VALUES(2, 'admin', '$2a$10$IntadJkLPNoWa2m/rKt5mOAXQMBKABynX4ENg4/fK7NN5nfEGvtBC', 1);

INSERT INTO authorities (id, user_id, authority) VALUES(1, 1, 'ROLE_USER');
INSERT INTO authorities (id, user_id, authority) VALUES(2, 2, 'ROLE_USER');
INSERT INTO authorities (id, user_id, authority) VALUES(3, 2, 'ROLE_ADMIN');