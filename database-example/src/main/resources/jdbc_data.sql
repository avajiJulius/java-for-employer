drop table if exists jdbc_passport;
drop table if exists jdbc_person;
drop table if exists jdbc_address;
drop table if exists jdbc_street;
drop table if exists jdbc_city;

create table jdbc_city (
    city_id serial,
    city_name varchar(100) not null,
    primary key(city_id)
);

create table jdbc_street (
    street_id serial,
    street_name varchar(100) not null,
    city_id integer not null,
    primary key(street_id),
    foreign key(city_id) references jdbc_city(city_id) on delete restrict
);

create table jdbc_address (
    address_id serial,
    city_id integer not null,
    street_id integer not null,
    building varchar(20) not null,
    primary key(address_id),
    foreign key(city_id) references jdbc_city(city_id) on delete restrict,
    foreign key(street_id) references jdbc_street(street_id) on delete restrict
);

create table jdbc_person (
    person_id serial,
    forename varchar(40) not null,
    surname varchar(40) not null,
    patronymic varchar(40),
    b_day date not null,
    address_id integer not null,
    primary key(person_id),
    foreign key(address_id) references jdbc_address(address_id) on delete restrict
);

create table jdbc_passport (
    passport_id serial,
    person_id integer not null,
    seria varchar(4) not null,
    number varchar(8) not null,
    issue_date date not null,
    issue_department varchar(50),
    primary key(passport_id),
    foreign key(person_id) references jdbc_person(person_id) on delete restrict
);