drop table if exists jdbc_passport;
drop table if exists jdbc_person;
drop table if exists jdbc_address;
drop table if exists jdbc_street;
drop table if exists jdbc_city;

create table jdbc_city (
    city_id integer not null,
    city_name varchar(100) not null,
    primary key(city_id)
);

insert into jdbc_city(city_id, city_name)
values (812, 'Санкт-Петербург'),
(495, 'Москва'), (4012, 'Калининград');

create table jdbc_street (
    street_id serial,
    street_name varchar(100) not null,
    city_id integer not null,
    primary key(street_id),
    foreign key(city_id) references jdbc_city(city_id) on delete restrict
);

insert into jdbc_street(city_id, street_name)
values (812, 'Петровская набережная'),
(812, 'Петровская набережная'), (812, 'Улица Миллионная'),
(812, 'Владимирский проспект'), (812, 'Невский проспект'),
(812, 'Улица Марата'), (812, 'Улица Рубинштейна'),
(812, 'Набережная реки Фонтанки'), (812, 'Улица Восстания'),
(812, 'Улица Жуковского'), (812, 'Литейнай проспект'),
(812, 'Улица Маяковского'), (812, 'Улица Пушкинская'),
(495, 'Звенигородское шоссе'), (495, 'Улица Восточная'),
(495, 'Улица Дольская'), (495, 'Улица Декабристов'),
(495, 'Улица Краснополянская'), (495, 'Улица Крюковская'),
(495, 'Улица Малая Пионерская'), (495, 'Мирской переулок'),
(495, 'Улица Смольная'), (495, 'Улица Береговая'),
(4012, 'Улица Баумана'), (4012, 'Улица Аксакова'),
(4012, 'Улица Возрождения'), (4012, 'Улица Генделя'),
(4012, 'Улица Канонерская'), (4012, 'Улица Песочная'),
(4012, 'Улица Хабаровская'), (4012, 'Улица Победы'),
(4012, 'Улица Янтарная'), (4012, 'Улица Художественная');


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