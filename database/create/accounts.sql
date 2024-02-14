CREATE TABLE accounts (
    user_id SERIAL UNIQUE,
    user_name VARCHAR(10) NOT NULL UNIQUE,
    num_wins INT DEFAULT 0,
    num_losses INT DEFAULT 0,
    duo_points INT DEFAULT 0,
    PRIMARY KEY (user_id)
);