alter table addresses
    add state varchar(255) not null after city;

alter table users
    drop column state;