-- players make username
-- INSERT INTO accounts(user_name) VALUES ('spiceless'), ('mudkip'), ('esaya');

-- -- correct error once duplicate username found
-- -- default iron elo, 0 wins/loss/DP

-- -- host creates game
-- INSERT INTO game_meta(game_code)
-- VALUES ('PEPE'); -- random four letter sequence

-- -- game_code should be unique tbh?

-- -- -- three players join game
-- INSERT INTO player_in_game(game_id, user_id, afk, cash)
-- VALUES (1, 1, FALSE, 2000), -- spiceless
--        (1, 2, FALSE, 2000), -- mudkip 
--        (1, 3, FALSE, 2000);  -- esaya

-- -- -- duplicate (game_id, user_id) rows will not be added

-- -- -- -- host starts game
-- UPDATE game_meta 
-- SET joinable = FALSE, 
--     num_players = 3  -- automate this
-- WHERE game_id = 1; -- automate this

-- -- -- begin game
-- -- -- spice's turn
-- UPDATE player_in_game
-- SET current_direction = 'RIGHT'
-- WHERE user_id = 1;

-- -- buys property
-- INSERT INTO owned_property(game_id, user_id, set_name, property_name)
-- VALUES (1,1,'Vermont', 'Stowe');

-- UPDATE player_in_game
-- SET cash = 1950         -- 2000 - 50 
-- WHERE user_id = 1;

-- how do we know where user's position is? 

-- mudkip
-- UPDATE player_in_game
-- SET current_direction = 'RIGHT'
-- WHERE user_id = 2;


-- -- esaya
-- UPDATE player_in_game
-- SET current_direction = 'RIGHT'
-- WHERE user_id = 3;


-- -- end game
-- DELETE FROM "game_meta" WHERE "game_id" = 1;
-- -- delete on cascade !! (player_in_game rows get deleted too)

-- ALTER SEQUENCE game_meta_game_id_seq RESTART WITH 1;