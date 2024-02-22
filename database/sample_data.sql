-- players make username
INSERT INTO accounts(user_name) VALUES ('spiceless'), ('mudkip'), ('esaya');

-- host creates game
INSERT INTO game_meta(game_code, date_time_start)
VALUES ('PEPE', getdate());

-- three players join game
INSERT player_in_game(game_id, user_id, afk, cash, current_direction)
VALUES (1, 1, FALSE, 2000, 'RIGHT'), -- spiceless
VALUES (1, 2, FALSE, 2000, 'RIGHT'), -- mudkip
VALUES (1, 3, FALSE, 2000, 'LEFT');  -- esaya

-- -- host starts game
-- UPDATE game_meta 
-- SET joinable = FALSE, 
--     num_players = 3  -- automate this
-- WHERE game_id = 1; -- automate this

-- -- begin game
-- -- spice's turn
-- UPDATE player_in_game
-- SET current_direction = 'LEFT'
-- WHERE user_id = 1;

