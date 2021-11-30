create table full_time_employee
(
    id         bigint      not null primary key,
    first_name varchar(50) not null,
    last_name  varchar(50) not null,
    salary     decimal     not null
);

insert into full_time_employee (id, first_name, last_name, salary)
values (100, 'Ivanka', 'Tramp', 5014);

