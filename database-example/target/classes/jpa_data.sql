drop table if exists jpa_customer_order_item;
drop table if exists jpa_customer_order;
drop table if exists jpa_customer;
drop table if exists jpa_product;

create table jpa_product (
  product_id serial,
  product_name varchar(40) not null,
  price numeric not null,
  available_amount integer not null,
primary key (product_id)
);

insert into jpa_product(product_name, price, available_amount)
values ('Ноутбук', 34000, 15), ('Наушники', 2300, 67), ('Телефон', 28000, 71),
('Утюг', 4700, 43), ('Фонарь', 2100, 23), ('Радио', 6200, 13);

create table jpa_customer (
  customer_id serial,
  forename varchar(40) not null,
  surname varchar(40) not null,
  patronymic varchar(40),
  b_day date not null,
primary key (customer_id)
);

create table jpa_customer_order (
  order_id serial not null,
  customer_id integer not null,
  status integer not null,
primary key (order_id),
foreign key(customer_id) references jpa_customer(customer_id) on delete restrict
);

create table jpa_customer_order_item (
  order_item_id serial not null,
  order_id integer not null,
  product_id integer not null,
  amount integer not null,
primary key (order_item_id),
foreign key(order_id) references jpa_customer_order(order_id) on delete restrict,
foreign key(product_id) references jpa_customer_order_item(order_item_id) on delete restrict
);


