create table profiles
(
    id              BIGINT       null,
    bio             TEXT         null,
    phone_number    varchar(15)  null,
    date_of_birth   DATE         null,
    loyality_points int UNSIGNED DEFAULT 0 null
);

drop table table_name