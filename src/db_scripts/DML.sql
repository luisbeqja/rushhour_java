-- inserting mock data into our players table
INSERT INTO players (player_name, join_date, email)
VALUES ('Luis', current_date, 'luisb@rushhour.ru');
INSERT INTO players (player_name, join_date, email)
VALUES ('Tim', current_date, 'timmyboy@rushour.ru');
INSERT INTO players (player_name, join_date, email)
VALUES ('SeanBrown', current_date, 'thesb@rushour.ru');


-- inserting mock data into our sessions table
INSERT INTO sessions (sessions_id, player_id, start_date, end_date, total_turns, score, difficulty, duration)
VALUES ('1', '1', '11-12-2024 14:14:55', '11-12-2024 14:20:05', 6, 200, 'easy', '00:05:05');
INSERT INTO sessions (sessions_id, player_id, start_date, end_date, total_turns, score, difficulty, duration)
VALUES ('2', '1', '11-12-2024 16:05:24', '11-12-2024 16:10:44', 7, 150, 'easy', '00:02:50');
INSERT INTO sessions (sessions_id, player_id, start_date, end_date, total_turns, score, difficulty, duration)
VALUES ('3', '3', '11-12-2024 14:23:56', '11-12-2024 14:25:56', 2, 50, 'easy', '00:02:00');
INSERT INTO sessions (sessions_id, player_id, start_date, end_date, total_turns, score, difficulty, duration)
VALUES ('4', '1', '11-12-2024 17:14:14', '11-12-2024 17:49:46', 5, 300, 'easy', '00:30:05');
INSERT INTO sessions (sessions_id, player_id, start_date, end_date, total_turns, score, difficulty, duration)
VALUES ('5', '1', '11-12-2024 18:21:21', '11-12-2024 18:22:21', 6, 200, 'easy', '00:46:20');
INSERT INTO sessions (sessions_id, player_id, start_date, end_date, total_turns, score, difficulty, duration)
VALUES ('6', '2', '11-12-2024 21:40:22', '11-12-2024 21:43:55', 4, 500, 'easy', '00:03:33');
INSERT INTO sessions (sessions_id, player_id, start_date, end_date, total_turns, score, difficulty, duration)
VALUES ('7', '1', '11-12-2024 22:40:54', '12-12-2024 05:05:23', 8, 400, 'hard', '00:04:05');


--top 5 leaderboard
SELECT p.player_name, s.score, TO_CHAR(s.duration, 'HH24:MI:SS') duration, TO_CHAR(s.end_date, 'YYYY-MM-DD') game_ended_on
FROM players p
         JOIN sessions s ON (p.player_id = s.player_id)
ORDER BY 2 DESC
    FETCH FIRST 5 ROWS ONLY;


-- inserting mock data into our boardstates table (this is for one game session)
INSERT INTO boardstates (session_id, game_row, game_column, cell_value)
VALUES (1, 1, 1, 0), (1,1,2,'A'), (1,1,3,'A'), (1,1,4,'X'), (1,1,5,'X'), (1,1,6,0),
       (1,2,1, 'B'), (1,2,2, 'B'), (1,2,3, 'B'), (1,2,4, '0'), (1,2,5, '0'), (1,2,6, 'C'),
       (1,3,1, '0'), (1,3,2, '0'), (1,3,3, '0'), (1,3,4, 'D'), (1,3,5, 'D'), (1,3,6, 'C'),
       (1, 4, 1, 0), (1,4,2,'E'), (1,4,3,'0'), (1,4,4,'0'), (1,4,5,'0'), (1,4,6,'0'),
       (1,5,1, '0'), (1,5,2, 'E'), (1,5,3, 'B'), (1,5,4, '0'), (1,5,5, '0'), (1,5,6, '0'),
       (1,6,1, '0'), (1,6,2, 'E'), (1,6,3, 'F'), (1,6,4, 'F'), (1,6,5, '0'), (1,6,6, '0');
