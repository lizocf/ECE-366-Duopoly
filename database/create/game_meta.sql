CREATE TABLE game_meta (
    game_id SERIAL UNIQUE,
    game_code VARCHAR(6) DEFAULT NULL, -- how to make random char sequence unique
    joinable BOOLEAN,
    which_player_turn VARCHAR(50), -- foreign kkey to user_id
    date_time_start TIMESTAMP,
    num_players INT,
    num_turns INT, -- ????
    PRIMARY KEY (game_id),
);