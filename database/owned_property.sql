CREATE TABLE owned_property (
    game_id int NOT NULL,
    user_id int NOT NULL,
    property_name varchar(50) DEFAULT NULL,
    num_hotels int DEFAULT 0,
    FOREIGN KEY (property_name) REFERENCES all_property(property_name),
    FOREIGN KEY (game_id) REFERENCES game_meta(game_id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES accounts(user_id) ON DELETE CASCADE
);

-- INSERT INTO all_property (property_name) VALUES ('nyc') ... need to add this --
