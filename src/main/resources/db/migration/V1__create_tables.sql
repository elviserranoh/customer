create table if not exists customers (
    id BINARY(16) primary key,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    birth_date date not null
);