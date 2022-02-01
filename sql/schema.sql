create table message (
    id bigserial not null,
    message varchar(255),
    primary key (id)
);

insert into message (message) values ('Hello World');