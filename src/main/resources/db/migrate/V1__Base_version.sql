create sequence shape_id_seq start 1;

create table shape
(
    shape_id   bigint   not null primary key,
    discriminator varchar (2),
    shape_name varchar(50),
    rectangle_length int,
    rectangle_breadth int,
    circle_radius int
);

drop table shape;
drop sequence shape_id_seq;