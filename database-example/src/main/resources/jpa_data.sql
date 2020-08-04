drop table if exists jpa_customer_basket;
drop table if exists jpa_customer;
drop table if exists jpa_items_list;
drop table if exists jpa_item;

create table jpa_item (
  item_id serial,
  item_name varchar(40) not null,
  price numeric not null,
  discount integer,
primary key (item_id)
);

create table jpa_items_list (
  list_item_id serial,
  item_id integer,
  amount integer not null,
  status integer not null,
primary key (list_item_id)
);

create table jpa_customer (
  customer_id serial,
  forename varchar(40) not null,
  surname varchar(40) not null,
  patronymic varchar(40),
  b_day date not null,
primary key (customer_id)
);

create table jpa_customer_basket (
  customer_id integer not null,
  primary key (customer_id)
);


