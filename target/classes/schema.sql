create table if not exists person
(
    id integer generated by default as identity primary key,
    username varchar not null unique,
    password varchar not null,
    role varchar not null
);

create table if not exists brand
(
    id integer generated by default as identity primary key,
    brand_name varchar not null unique
);


create table if not exists tool
(
    id integer generated by default as identity primary key,
    person_id integer references person(id) ON DELETE SET NULL,
    brand_id integer references brand(id) ON DELETE SET NULL,
    tool_name varchar not null,
    cost integer
);

