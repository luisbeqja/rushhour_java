-- creating a players table
DROP TABLE IF EXISTS players CASCADE ;
CREATE TABLE IF NOT EXISTS players (
                                       player_id INTEGER
                                       CONSTRAINT pk_player PRIMARY KEY,
                                       player_name VARCHAR(10) NOT NULL,
    join_date DATE,
    email VARCHAR(50) NOT NULL
    );

-- Creating sessions table
DROP TABLE IF EXISTS sessions CASCADE;
CREATE TABLE IF NOT EXISTS sessions (
    sessions_id NUMERIC(4)
    CONSTRAINT pk_sessions PRIMARY KEY,
    player_id INTEGER
    CONSTRAINT fk_sessions_player_id
    REFERENCES players(player_id),
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    total_turns NUMERIC(4) NOT NULL,
    score NUMERIC(4) NOT NULL,
    -- easy, medium, hard
    difficulty VARCHAR(6) NOT NULL
    CONSTRAINT ch_sessions_difficulty
    CHECK (difficulty IN ('easy', 'medium', 'hard')),
    duration INTERVAL NOT NULL
    );

-- creating  boardstates table
DROP TABLE IF EXISTS boardstates CASCADE;
CREATE TABLE IF NOT EXISTS boardstates (
                                           session_id NUMERIC(4)
    CONSTRAINT fk_boardstates_session_id
    REFERENCES sessions(sessions_id),
    game_row NUMERIC(1)
    CONSTRAINT ch_boardstates_row
    CHECK (game_row BETWEEN 1 AND 6),
    game_column NUMERIC(1)
    CONSTRAINT ch_boardstates_column
    CHECK (game_column BETWEEN 1 AND 6),
    CONSTRAINT pk_boardstates
    PRIMARY KEY (session_id, game_row, game_column),
    -- 0 OR A,B,C...X
    cell_value VARCHAR(1) NOT NULL
    CONSTRAINT ch_boardstates_cell_value
    CHECK (cell_value IN ('0','A','B','C','D','E','F','X'))
    );


-- Populate mock data

-- inserting mock data into our players table
INSERT INTO players (player_id, player_name, join_date, email)
VALUES ('1', 'Luis', current_date, 'luisb@rushhour.ru');
INSERT INTO players (player_id, player_name, join_date, email)
VALUES ('2', 'Tim', current_date, 'timmyboy@rushour.ru');
INSERT INTO players (player_id, player_name, join_date, email)
VALUES ('3', 'SeanBrown', current_date, 'thesb@rushour.ru');


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