-- CREATE SEQUENCE game_id_seq start with 1;
--
-- CREATE TABLE gamemeta (
--                           game_id bigint NOT NULL DEFAULT nextval('hp_customer_seq'),
--                           game_code varchar(6) DEFAULT NULL,
--                           last_name varchar(50) DEFAULT NULL,
--                           email varchar(50) DEFAULT NULL,
--                           phone varchar(50) DEFAULT NULL,
--                           address varchar(50) DEFAULT NULL,
--                           city varchar(50) DEFAULT NULL,
--                           state varchar(50) DEFAULT NULL,
--                           zipcode varchar(50) DEFAULT NULL,
--                           PRIMARY KEY (customer_id)
-- );

CREATE TABLE game_meta (
                           game_id SERIAL PRIMARY KEY,
                           game_code VARCHAR(50),
                           joinable BOOLEAN,
                           which_player_turn INT, -- foreign kkey to user_id
                           date_time_start TIMESTAMP,
                           num_players INT,
                           num_turns INT -- ????
);