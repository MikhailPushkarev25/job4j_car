create table users (
    id serial primary key,
    name varchar(255),
    email varchar(255) unique,
    password varchar(255)
);

create table color (
   id serial primary key,
   name varchar(255)
);

create table mark (
    id serial primary key,
    name varchar(255)
);

create table bodyType (
    id serial primary key,
    name varchar(255)
);

create table item (
    id serial primary key,
    description varchar(255),
    created timestamp,
    done boolean,
    user_id int references users(id),
    car_id int references car(id)
);

create table photo (
    id serial primary key,
    name varchar(255),
    item_id int references item(id)
);

create table car (
    id serial primary key,
    year int,
    price int,
    modeles varchar(255),
    color_id int references color(id),
    mark_id int references mark(id),
    body_id int references bodyType(id)
);

insert into mark(name) values
                     ('Cadillac'),
                     ('Chery'),
                     ('Chevrolet'),
                     ('Chrysler'),
                     ('Citroën'),
                     ('Audi'),
                     ('Bentley'),
                     ('Datsun'),
                     ('Ford'),
                     ('Geely'),
                     ('Honda'),
                     ('Hyundai'),
                     ('Infiniti'),
                     ('Kia'),
                     ('Lexus'),
                     ('Mitsubishi'),
                     ('Nissan'),
                     ('Opel'),
                     ('Porsche'),
                     ('Renault');

insert into bodyType(name) values
                         ('Седан'),
                         ('Хэтчбек'),
                         ('Лифтбек'),
                         ('Универсал'),
                         ('Купе'),
                         ('Фургон'),
                         ('Лимузин'),
                         ('Внедорожник');

insert into color(name) values
                      ('Синий'),
                      ('Белый'),
                      ('Крысный'),
                      ('Золотой'),
                      ('Черный'),
                      ('Зеленый');


