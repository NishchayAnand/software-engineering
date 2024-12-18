
CREATE TABLE movie (
	id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    genre VARCHAR(20),
    release_date DATE,
    duration INT
);

CREATE TABLE theatre (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    street VARCHAR(100) NOT NULL,
    city VARCHAR(20) NOT NULL,
    state VARCHAR(20) NOT NULL,
    country VARCHAR(20) NOT NULL,
    postal_code VARCHAR(10)
);

CREATE TABLE screen (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    theatre_id INT NOT NULL,
    FOREIGN KEY (theatre_id) REFERENCES theatre (id) ON DELETE CASCADE
);

CREATE TABLE shows (
	id INT AUTO_INCREMENT PRIMARY KEY,
    movie_id INT NOT NULL,
    screen_id INT NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    FOREIGN KEY (movie_id) REFERENCES movie (id) ON DELETE CASCADE,
    FOREIGN KEY (screen_id) REFERENCES screen (id) ON DELETE CASCADE
);