create table message (
    id bigserial not null,
    message varchar(255),
    primary key (id)
);

insert into message (message) values ('Hello World');

create table person(
    id bigserial not null,
    name varchar(255),
    account_balance bigint not null default 0,
    primary key (id)
)

insert into person(name, account_balance) values ('Bob', 100);