create sequence shape_id_seq start 1;

create table shape
(
    shape_id          bigint not null primary key,
    discriminator     varchar(2),
    shape_name        varchar(50),
    rectangle_length  int,
    rectangle_breadth int,
    circle_radius     int
);


create table payment
(
    id     bigint  not null primary key UNIQUE,
    amount decimal not null
);

create table Card
(
    card_number bigint      not null primary key,
    card_type   varchar(50) not null,
    constraint payment_id foreign key (card_number) references payment (id) on update cascade on delete cascade
);

create table cheque
(
    cheque_number bigint      not null primary key,
    cheque_type   varchar(50) not null,
    constraint payment_id foreign key (cheque_number) references payment (id) on update cascade on delete cascade
);

drop table shape;
drop sequence shape_id_seq;
drop table cheque;
drop table card;
drop table payment;
