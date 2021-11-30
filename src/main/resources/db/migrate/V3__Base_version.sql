create table Card
(
    card_number bigint      not null primary key,
    card_type   varchar(50) not null,
    constraint payment_id foreign key (card_number) references payment (id) on update cascade on delete cascade
);
