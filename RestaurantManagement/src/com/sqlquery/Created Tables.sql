create table customer (customer_id varchar(45)primary key,customer_name varchar(30) not null,
gender varchar(20) not null,email varchar(30) not null,
Address varchar(60) not null,mobile_number bigint not null);

create table menu(product_id varchar(45) primary key,
product_name varchar(45) not null,price double not null);

create table sales (customer_id varchar(45)not null,
order_date date not null,
product_id varchar(45) not null,
foreign key(customer_id) references customer(customer_id),
foreign key (product_id) references menu(product_id));

create table members(customer_id varchar(45) primary key,customer_name varchar(60) not null,join_date timestamp not null);