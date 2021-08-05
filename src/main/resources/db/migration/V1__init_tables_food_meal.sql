Create table foods(
    id int primary key auto_increment,
    name varchar(100) not null,
    firm varchar(100),
    category varchar(100) not null,
    price float
);

Create table meals(
                      id int primary key auto_increment,
                      name varchar(100) not null,
                      type varchar(100) not null
)