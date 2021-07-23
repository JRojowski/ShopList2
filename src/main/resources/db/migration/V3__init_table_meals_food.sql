Create table meals_food(
    meal_id int(11) NOT NULL,
    food_id int(11) NOT NULL,
    foreign key (meal_id) references meals(id),
    foreign key (food_id) references foods(id)
);