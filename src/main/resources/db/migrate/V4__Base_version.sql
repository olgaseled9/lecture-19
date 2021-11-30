create table cheque
(
    cheque_number bigint      not null primary key,
    cheque_type   varchar(50) not null,
    constraint payment_id foreign key (cheque_number) references payment (id) on update cascade on delete cascade
);
