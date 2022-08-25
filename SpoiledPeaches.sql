create database SpoiledPeaches;

use SpoiledPeaches;

create table user_tracker (
	user_id int primary key auto_increment,
    user_name varchar(30),
    user_password varchar(30), 
    user_email varchar(50)
);

insert into user_tracker values
(null, "zinujust", "pw123", "shariff.zainal7@gmail.com"),
(null, "nickb", "pw123", "nick_burnz@hotmail.com"),
(null, "stevey", "pw123", "stevey_r@outlook.com"),
(null, "shem", "pw123", "shemwhatsup@icloud.com"),
(null, "joemama", "pw123", "nick_burnz@hotmail.com"),
(null, "test", "pw123", "stevey_r@outlook.com"),
(null, "antishem", "pw123", "shemwhatsup@icloud.com");

create table genres (
    genre_name varchar(25) primary key unique 
);

insert into genres values
("Science Fiction"),
("Fantasy"),
("Horror"),
("Non-Fiction"),
("Mystery"),
("Romance");

create table user_preferences (
	user_id int,
	genre_name varchar(25),

	FOREIGN KEY (user_id)
	REFERENCES user_tracker(user_id),

	FOREIGN KEY (genre_name)
	REFERENCES genres(genre_name),

	PRIMARY KEY(user_id, genre_name)
);

insert into user_preferences values
(1, "Science Fiction"),
(2, "Fantasy"),
(3, "Mystery"),
(4, "Romance"),
(2, "Science Fiction"),
(3, "Fantasy"),
(3, "Science Fiction"),
(4, "Mystery"),
(4, "Fantasy"),
(4, "Science Fiction"),
(5, "Romance"),
(5, "Mystery"),
(5, "Fantasy"),
(5, "Non-Fiction"),
(5, "Science Fiction"),
(6, "Romance"),
(6, "Horror"),
(6, "Mystery"),
(6, "Fantasy"),
(6, "Non-Fiction"),
(6, "Science Fiction");

CREATE TABLE book (
bookID int auto_increment PRIMARY KEY,
bookName varchar(255),
author varchar(255),
pages int,
genre varchar(255),
rating double,
userRating double,
ratingCount int
);

insert into book values
#Science Fiction
(null, "Dune", "Frank Herbert", null, "Science Fiction", 4.25, 0, 0),
(null, "Ender's Game", "Orson Scott Card", null, "Science Fiction", 4.3, 0, 0),
(null, "The Hitchhiker's Guide to the Galaxy", "Douglas Adams", null, "Science Fiction", 4.22, 0, 0),
(null, "1984", "George Orwell", null, "Science Fiction", 4.19, 0, 0),
(null, "Fahrenheit 451", "Ray Bradbury", null, "Science Fiction", 3.98, 0, 0),
(null, "Foundation", "Isaac Asimov", null, "Science Fiction", 4.17, 0, 0),
(null, "Brave New World", "Aldous Huxley", null, "Science Fiction", 3.99, 0, 0),
(null, "Hyperion", "Dan Simmons", null, "Science Fiction", 4.24, 0, 0),
(null, "Do Androids Dream of Electric Sheep?", "Phillip K. Dick", null, "Science Fiction", 4.09, 0, 0),
(null, "I, Robot", "Isaac Asimov", null, "Science Fiction", 4.21, 0, 0),
#Horror
(null, "The Shining", "Stephen King", null, "Horror", 4.25, 0, 0),
(null, "It", "Stephen King", null, "Horror", 4.25, 0, 0),
(null, "Salem's Lot", "Stephen King", null, "Horror", 4.05, 0, 0),
(null, "Dracula", "Bram Stoker", null, "Horror", 4.01, 0, 0),
(null, "Pet Semantary", "Stephen King", null, "Horror", 4.03, 0, 0),
(null, "Misery", "Stephen King", null, "Horror", 4.20, 0, 0),
(null, "The Exorcist", "William Peter Blatty", null, "Horror", 4.19, 0, 0),
(null, "The Haunting of Hill House", "Shirley Jackson", null, "Horror", 3.83, 0, 0),
(null, "Carrie", "Stephen King", null, "Horror", 3.98, 0, 0),
(null, "The Silence of the Lambs", "Thomas Harris", null, "Horror", 4.23, 0, 0),
#Fantasy
(null, "The Hobbit", "J.R.R. Tolkien", null, "Fantasy", 4.28, 0, 0),
(null, "Harry Potter and the Deathly Hallows", "J.K. Rowling", null, "Fantasy", 4.62, 0, 0),
(null, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", null, "Fantasy", 4.47, 0, 0),
(null, "The FellowShip of the Rings", "J.R.R. Tolkien", null, "Fantasy", 4.38, 0, 0),
(null, "Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", null, "Fantasy", 4.58, 0, 0),
(null, "The Return of the King", "J.R.R Tolkien", null, "Fantasy", 4.55, 0, 0),
(null, "Harry Potter and the Goblet of Fire", "J.K. Rowling", null, "Fantasy", 4.57, 0, 0),
(null, "Harry Potter and the Half-Blood Prince", "J.K. Rowling", null, "Fantasy", 4.58, 0, 0),
(null, "Harry Potter and the Chamber of Secrets", "J.K. Rowling", null, "Fantasy", 4.43, 0, 0),
(null, "The Two Towers", "J.R.R Tolkien", null, "Fantasy", 4.46, 0, 0),
#Non-fiction
(null, "The Elements of Style", "William Strunk Jr.", null, "Non-Fiction", 4.16, 0, 0),
(null, "In Cold Blood", "Truman Capote", null, "Non-Fiction", 4.08, 0, 0),
(null, "I know Why the Caged Bird Sings", "Maya Angelou", null, "Non-Fiction", 4.27, 0, 0),
(null, "Fast Food Nation: The Dark Side of the All-American Meal", "Eric Schlosser", null, "Non-Fiction", 3.75, 0, 0),
(null, "The Omnivore's Dilema: A Natural History of Four Meals", "Michael Pollan", null, "Non-Fiction", 4.17, 0, 0),
(null, "On Writing: A Memoir of the Craft", "Stephen King", null, "Non-Fiction", 4.33, 0, 0),
(null, "Maus: A Survivor's Tale: My Father Bleeds History", "Art Spiegelmann", null, "Non-Fiction", 4.36, 0, 0),
(null, "Guns, Germs, and Steel: The Fates of Human Societies", "Jared Diamond", null, "Non-Fiction", 4.04, 0, 0),
(null, "Silent Spring", "Rachel Carson", null, "Non-Fiction", 4.00, 0, 0),
(null, "A Walk in the Woods: Rediscovering America on the Applachian Trail", "Bill Bryson", null, "Non-Fiction", 4.06, 0, 0),
#Mystery
(null, "The Girl with the Dragon Tattoo", "Stieg Larsson", null, "Mystery", 4.16, 0, 0),
(null, "And Then There Were None", "Agatha Christie", null, "Mystery", 4.28, 0, 0),
(null, "Angels & Demons", "Dan Brown", null, "Mystery", 3.93, 0, 0),
(null, "Rebecca", "Daphne du Maurier", null, "Mystery", 4.24, 0, 0),
(null, "In Cold Blood", "Truman Capote", null, "Mystery", 4.08, 0, 0),
(null, "The Godfather", "Mario Puzo", null, "Mystery", 4.37, 0, 0),
(null, "The Lovely Bones", "Alice Sebold", null, "Mystery", 3.84, 0, 0),
(null, "Gone Girl", "Gillian Flynn", null, "Mystery", 4.11, 0, 0),
(null, "The Name of the Rose", "Umberto Eco", null, "Mystery", 4.13, 0, 0),
(null, "Shutter Island", "Dennis Lehane", null, "Mystery", 4.09, 0, 0),
#Romance
(null, "Pride and Prejudice", "Jane Austen", null, "Romance", 4.28, 0, 0),
(null, "Outlander", "Diana Gabaldon", null, "Romance", 4.25, 0, 0),
(null, "Jane Eyre", "Charlotte Bronte", null, "Romance", 4.14, 0, 0),
(null, "Gone with the Wind", "Margaret Mitchell", null, "Romance", 4.30, 0, 0),
(null, "Sense and Sensibility", "Jane Austen", null, "Romance", 4.08, 0, 0),
(null, "The Notebook", "Nicholas Sparks", null, "Romance", 4.13, 0, 0),
(null, "Persuasion", "Jane Austen", null, "Romance", 4.15, 0, 0),
(null, "Dragonfly in the Amber", "Diana Gabaldon", null, "Romance", 4.33, 0, 0),
(null, "Voyager", "Diana Gabaldon", null, "Romance", 4.38, 0, 0),
(null, "Whitney, My Love", "Judith McNaught", null, "Romance", 4.13, 0, 0);

CREATE TABLE tracker (

userID int,

bookID int,

FOREIGN KEY (userID)
REFERENCES user_tracker(user_ID),

FOREIGN KEY (bookID)
REFERENCES book(bookID),

progressStatus varchar(255),

PRIMARY KEY(userID, bookID)

);

INSERT INTO tracker (userID, bookID, progressStatus)
VALUES (1, 9, "Not started");

INSERT INTO tracker (userID, bookID, progressStatus)
VALUES (2, 5, "Not started");

INSERT INTO tracker (userID, bookID, progressStatus)
VALUES (3, 10, "Not started");

