CREATE TABLE owned_property (
    game_id int NOT NULL,
    user_id int NOT NULL,
    set_name varchar(50) NOT NULL,
    property_name varchar(50) NOT NULL,
    num_hotels int DEFAULT 0,
    PRIMARY KEY (game_id, user_id),
    FOREIGN KEY (property_name) REFERENCES all_property(property_name),
    FOREIGN KEY (set_name) REFERENCES all_property(set_name),
    FOREIGN KEY (game_id) REFERENCES game_meta(game_id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES accounts(user_id) ON DELETE CASCADE,
);

-- INSERT INTO all_property (property_name) VALUES ('nyc') ... need to add this --
