create table if not exists Post (
    id identity,
    author varchar(50) not null,
    title varchar(50) not null,
    content varchar(50) not null,
    createdAt timestamp not null
);

create table if not exists Block (
    id identity,
    title varchar(50) not null,
    content varchar(50) not null
);

create table if not exists Partner (
    id identity,
    img varchar(50) not null,
    name varchar(50) not null,
    description varchar(400) not null
);

create table if not exists Review (
    id identity,
    author varchar(50) not null,
    discipline varchar(50) not null,
    opinion varchar(50) not null
);

create table if not exists Offer (
    id identity,
    name varchar(50) not null,
    description varchar(50) not null
);