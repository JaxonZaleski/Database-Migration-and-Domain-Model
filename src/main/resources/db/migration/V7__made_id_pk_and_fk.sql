alter table profiles
    modify id bigint not null primary key;

alter table profiles
    add constraint profiles_id_fk
        foreign key (id) references users (id);