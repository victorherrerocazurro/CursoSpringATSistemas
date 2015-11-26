DROP TABLE USERS;

CREATE TABLE USERS (
	id BIGINT PRIMARY KEY,
	user_login varchar(45) NOT NULL,
	user_pass varchar(45) NOT NULL,
	age int NOT NULL
) ENGINE=InnoDB;


insert into `USERS` (`id`, `user_login`, `user_pass`, `age`) 
	values (1, 'fer', '1234', 40);
insert into `USERS` (`id`, `user_login`, `user_pass`, `age`) 
	values (2, 'rosa', 'rosa', 30);
insert into `USERS` (`id`, `user_login`, `user_pass`, `age`) 
	values (3, 'luis', 'miguel', 20);
insert into `USERS` (`id`, `user_login`, `user_pass`, `age`) 
	values (4, 'ana', '1234', 50);	
	