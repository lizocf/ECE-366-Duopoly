-- players make username
INSERT INTO accounts(user_name) VALUES ('spiceless'), ('mudkip'), ('esaya');

-- correct error once duplicate username found
-- default iron elo, 0 wins/loss/DP

-- host creates game
INSERT INTO game_meta(game_code)
VALUES ('PEPE'); -- random four letter sequence

-- game_code should be unique tbh?

-- three players join game
INSERT INTO player_in_game(game_id, user_id)
VALUES (1, 1), -- spiceless
       (1, 2), -- mudkip 
       (1, 3); -- esaya

-- duplicate (game_id, user_id) rows will not be added

-- host starts game
UPDATE game_meta 
SET joinable = FALSE, 
    num_players = 3,
    num_turns = 1  -- automate this
WHERE game_id = 1; -- automate this

-- BEGIN GAME

-- spice's turn
UPDATE game_meta 
SET which_player_turn = 1 -- aka spiceless 
WHERE game_id = 1; -- automate this

-- go right and land 10th space
UPDATE player_in_game
SET current_direction = 'RIGHT',
    current_position = 11 -- go space is 0
WHERE game_id = 1 AND user_id = 1; -- game_id part overkill bc users arent allowed in > 1 game, safer ig

-- debt space is passed!
UPDATE game_meta
SET debt_pot = 50
WHERE game_id = 1;

-- buys property
INSERT INTO owned_property(game_id, user_id, set_name, property_name)
VALUES (1,1,'Michigan', 'Rochester');

UPDATE player_in_game
SET cash = 1940     -- rochester costs 60
WHERE game_id = 1 AND user_id = 1;


-- mudkip's turn
UPDATE game_meta 
SET which_player_turn = 2 -- aka mudkip 
WHERE game_id = 1; 

UPDATE player_in_game
SET current_direction = 'RIGHT',
    current_position = 8 -- skull card!
WHERE game_id = 1 AND user_id = 2;

-- skull card pulled: bankrupt L
UPDATE player_in_game
SET cash = 0,

-- mudkip loses
    afk = TRUE 
    -- is this a good way to show that someone lost? alternatively, we can
    -- just remove this player from this table when they quit
WHERE game_id = 1 AND user_id = 2;

-- esaya's turn
UPDATE game_meta 
SET which_player_turn = 3-- aka esaya 
WHERE game_id = 1; 

UPDATE player_in_game
SET current_direction = 'LEFT',
    current_position = 52   -- going counter clockwise now
WHERE game_id = 1 AND user_id = 3;

-- suprise card pulled: claim all of Cali

INSERT INTO owned_property(game_id, user_id, set_name, property_name)
VALUES (1,3,'California', 'Los Angeles'),
       (1,3,'California', 'San Francisco');

-- buy hotel for SF
UPDATE player_in_game
SET cash = 1920 -- SF hotel cost = $80
WHERE game_id = 1 AND user_id = 3;

UPDATE owned_property
SET num_hotels = 1
WHERE game_id = 1 AND user_id = 3 AND property_name = 'San Francisco';

-- need a statement to restrict user from
-- upgrading before other hotels are bought, idk how tho

-- buy hotel for LA
UPDATE player_in_game
SET cash = 1820 -- LA hotel cost = $100
WHERE game_id = 1 AND user_id = 3;

UPDATE owned_property
SET num_hotels = 1
WHERE game_id = 1 AND user_id = 3 AND property_name = 'Los Angeles';

-- airport

-- sells property

-- end game
DELETE FROM "game_meta" WHERE "game_id" = 1;
-- delete on cascade !! (player_in_game rows get deleted too)

ALTER SEQUENCE game_meta_game_id_seq RESTART WITH 1;