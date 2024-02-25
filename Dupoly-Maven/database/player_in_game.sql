CREATE TABLE player_in_game (
    game_id int NOT NULL,
    user_id int NOT NULL,
    afk BOOLEAN DEFAULT FALSE,
    cash int DEFAULT 2000,
    current_direction varchar(10) DEFAULT NULL,
    current_position int DEFAULT 0,
    PRIMARY KEY (game_id, user_id),
    FOREIGN KEY (game_id) REFERENCES game_meta(game_id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES accounts(user_id) ON DELETE CASCADE
);

-- add position (59 total)