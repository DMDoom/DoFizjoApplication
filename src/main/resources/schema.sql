drop table if exists Post;
drop table if exists Block;
drop table if exists Partner;
drop table if exists Review;
drop table if exists Method;
drop table if exists authorities;
drop table if exists users;

create table if not exists Post (
    id serial primary key,
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
    id serial primary key,
    img varchar(50) not null,
    name varchar(50) not null,
    description varchar(1000) not null
);

create table if not exists Review (
    id serial primary key,
    author varchar(50) not null,
    discipline varchar(50) not null,
    opinion varchar(1000) not null
);

create table if not exists Method (
    id serial primary key,
    name varchar(100) not null,
    description varchar(500) not null
);

create table users (
	username varchar(50) not null primary key,
	password varchar(500) not null,
	enabled boolean not null
);

create table authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);

create unique index ix_auth_username on authorities (username,authority);

create table if not exists Comment (
    id serial primary key,
    postid varchar(10),
    createdAt timestamp,
    author varchar(50),
    content varchar(500),
    foreign key(postid) references Post(id)
);

create table if not exists Post_Comments (
    postid varchar(10),
    commentid varchar(10),
    foreign key(postid) references Post(id),
    foreign key(commentid) references Comment(id)
);

create table if not exists Comment_Queue (
    id serial primary key,
    postid varchar(10),
    createdAt timestamp,
    author varchar(50),
    content varchar(500),
    foreign key(postid) references Post(id)
);