create table part_time_employee
(
    id          bigint      not null primary key,
    first_name  varchar(50) not null,
    last_name   varchar(50) not null,
    hourly_rate decimal     not null
);

insert into part_time_employee (id, first_name, last_name, hourly_rate)
values (88, 'Ivan', 'Tramp', 51);

