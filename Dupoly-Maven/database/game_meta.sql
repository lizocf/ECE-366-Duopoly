CREATE TABLE game_meta (
    game_id SERIAL UNIQUE,
    game_code varchar(6) UNIQUE DEFAULT NULL, -- how to make random char sequence unique
    joinable boolean DEFAULT TRUE,
    which_player_turn int DEFAULT NULL, -- foreign kkey to user_id
    date_time_start varchar(50) DEFAULT now(),
    num_players int DEFAULT 0,
    num_turns int DEFAULT 0, -- ????
    debt_pot int DEFAULT 0,
    PRIMARY KEY (game_id),
    FOREIGN KEY (which_player_turn) REFERENCES accounts(user_id)
);