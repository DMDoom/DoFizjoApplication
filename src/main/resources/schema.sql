create table if not exists Post (
    id int identity,
    author varchar(50) not null,
    title varchar(50) not null,
    content varchar(5000) not null,
    createdAt timestamp not null
);

create table if not exists Block (
    id varchar(15) not null,
    title varchar(50) not null,
    content varchar(2000) not null
);

create table if not exists Partner (
    id int identity,
    img varchar(50) not null,
    name varchar(50) not null,
    description varchar(1000) not null
);

create table if not exists Review (
    id int identity,
    author varchar(50) not null,
    discipline varchar(50) not null,
    opinion varchar(1000) not null
);

create table if not exists Method (
    id int identity,
    name varchar(100) not null,
    description varchar(500) not null
);

create table users (
	username varchar_ignorecase(500) not null primary key,
	password varchar_ignorecase(500) not null,
	enabled boolean not null
);

create table authorities (
	username varchar_ignorecase(50) not null,
	authority varchar_ignorecase(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);