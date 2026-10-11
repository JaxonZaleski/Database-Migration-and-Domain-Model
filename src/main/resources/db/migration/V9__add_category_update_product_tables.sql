create table category
(
    id   integer auto_increment
        primary key,
    name VARCHAR(255) not null invisible
);

alter table product
    add category_id integer not null;

alter table product
    add constraint product_category_fk
        foreign key (category_id) references category (id);
