
INSERT INTO movie (title, genre, release_date, duration) VALUES ('Inception', 'Sci-Fi', '2010-07-16', 120);

INSERT INTO theatre (street, name, city, state, country, postal_code) VALUES ('Broadway Theatre', '1234 Broadway St', 'New York', 'NY', 'USA', '10001');

INSERT INTO screen (name, theatre_id) VALUES ('Screen 1', 1);

INSERT INTO shows (movie_id, screen_id, start_time, end_time) VALUES (1, 1, '10:00:00', '14:00:00');