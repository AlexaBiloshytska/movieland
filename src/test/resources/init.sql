create table movies(
  id serial not null ,
  name_native varchar(500) unique ,
  name_russian varchar(500) unique,
  year_of_release int,
  description varchar(1000),
  rating double precision,
  price double precision,
  poster_url varchar(20000000)

);

create table genres(
       id serial not null ,
       name varchar(300)
);

insert into genres( name) VALUES ('action movie');
CREATE TABLE users(
                    id serial PRIMARY KEY,
                    name VARCHAR NOT NULL,
                    email VARCHAR NOT NULL,
                    password VARCHAR(45) NOT NULL,
                    admin boolean DEFAULT FALSE
);

insert into genres( name) VALUES ('action movie');

insert into movies ( name_native, name_russian, year_of_release,description,rating,price,poster_url) VALUES ('Shadow fight','Бой с тенью',2005,'My favourite film',10.0,100.0,'https://www.google.com');
insert into movies ( name_native, name_russian, year_of_release,description,rating,price,poster_url) VALUES ('Shadow fight 2','Бой с тенью 2',2005,'My favourite film part 2',10.0,200.0,'https://www.google.com');
insert into movies ( name_native, name_russian, year_of_release,description,rating,price,poster_url) VALUES ('Shadow fight 3','Бой с тенью 3',2011,'The third part',10.0,500.0,'https://www.google.com');
insert into movies ( name_native, name_russian, year_of_release,description,rating,price,poster_url) VALUES ('Focus','Фокус',2011,'With Will Smith',10.0,1000.0,'https://www.google.com');



