create database SpoiledPeaches;

use SpoiledPeaches;

create table user_tracker (
	user_id int primary key auto_increment,
    user_name varchar(30),
    user_password varchar(30), 
    user_email varchar(50),
    user_phone varchar(50),
    user_DOB date
);

insert into user_tracker values
(null, "zinujust", "pw123", "shariff.zainal7@gmail.com", null, null),
(null, "nickb", "pw123", "nick_burnz@hotmail.com", null, null),
(null, "stevey", "pw123", "stevey_r@outlook.com", null, null),
(null, "shem", "pw123", "shemwhatsup@icloud.com", null, null);

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
(4, "Romance");

CREATE TABLE book (
bookID int auto_increment PRIMARY KEY,
bookName varchar(255),
author varchar(255),
pages int,
genre varchar(255),
rating int
);

insert into book values
#Science Fiction
(null, "Dune", "Frank Herbert", null, "Science Fiction", 4.25),
(null, "Ender's Game", "Orson Scott Card", null, "Science Fiction", 4.3),
(null, "The Hitchhiker's Guide to the Galaxy", "Douglas Adams", null, "Science Fiction", 4.22),
(null, "1984", "George Orwell", null, "Science Fiction", 4.19),
(null, "Fahrenheit 451", "Ray Bradbury", null, "Science Fiction", 3.98),
(null, "Foundation", "Isaac Asimov", null, "Science Fiction", 4.17),
(null, "Brave New World", "Aldous Huxley", null, "Science Fiction", 3.99),
(null, "Hyperion", "Dan Simmons", null, "Science Fiction", 4.24),
(null, "Dp Androids Dream of Electric Sheep?", "Phillip K. Dick", null, "Science Fiction", 4.09),
(null, "I, Robot", "Isaac Asimov", null, "Science Fiction", 4.21),
#Horror
(null, "The Shining", "Stephen King", null, "Horror", 4.25),
(null, "It", "Stephen King", null, "Horror", 4.25),
(null, "Salem's Lot", "Stephen King", null, "Horror", 4.05),
(null, "Dracula", "Bram Stoker", null, "Horror", 4.01),
(null, "Pet Semantary", "Stephen King", null, "Horror", 4.03),
(null, "Misery", "Stephen King", null, "Horror", 4.20),
(null, "The Exorcist", "William Peter Blatty", null, "Horror", 4.19),
(null, "The Haunting of Hill House", "Shirley Jackson", null, "Horror", 3.83),
(null, "Carrie", "Stephen King", null, "Horror", 3.98),
(null, "The Silence of the Lambs", "Thomas Harris", null, "Horror", 4.23),
#Fantasy
(null, "The Hobbit", "J.R.R. Tolkien", null, "Fantasy", 4.28),
(null, "Harry Potter and the Deathly Hallows", "J.K. Rowling", null, "Fantasy", 4.62),
(null, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", null, "Fantasy", 4.47),
(null, "The FellowShip of the Rings", "J.R.R. Tolkien", null, "Fantasy", 4.38),
(null, "Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", null, "Fantasy", 4.58),
(null, "The Return of the King", "J.R.R Tolkien", null, "Fantasy", 4.55),
(null, "Harry Potter and the Goblet of Fire", "J.K. Rowling", null, "Fantasy", 4.57),
(null, "Harry Potter and the Half-Blood Prince", "J.K. Rowling", null, "Fantasy", 4.58),
(null, "Harry Potter and the Chamber of Secrets", "J.K. Rowling", null, "Fantasy", 4.43),
(null, "The Two Towers", "J.R.R Tolkien", null, "Fantasy", 4.46),
#Non-fiction
(null, "The Elements of Style", "William Strunk Jr.", null, "Non-Fiction", 4.16),
(null, "In Cold Blood", "Truman Capote", null, "Non-Fiction", 4.08),
(null, "I know Why the Caged Bird Sings", "Maya Angelou", null, "Non-Fiction", 4.27),
(null, "Fast Food Nation: The Dark Side of the All-American Meal", "Eric Schlosser", null, "Non-Fiction", 3.75),
(null, "The Omnivore's Dilema: A Natural History of Four Meals", "Michael Pollan", null, "Non-Fiction", 4.17),
(null, "On Writing: A Memoir of the Craft", "Stephen King", null, "Non-Fiction", 4.33),
(null, "Maus: A Survivor's Tale: My Father Bleeds History", "Art Spiegelmann", null, "Non-Fiction", 4.36),
(null, "Guns, Germs, and Steel: The Fates of Human Societies", "Jared Diamond", null, "Non-Fiction", 4.04),
(null, "Silent Spring", "Rachel Carson", null, "Non-Fiction", 4.00),
(null, "A Walk in the Woods: Rediscovering America on the Applachian Trail", "Bill Bryson", null, "Non-Fiction", 4.06),
#Mystery
(null, "The Girl with the Dragon Tattoo", "Stieg Larsson", null, "Mystery", 4.16),
(null, "And Then There Were None", "Agatha Christie", null, "Mystery", 4.28),
(null, "Angels & Demons", "Dan Brown", null, "Mystery", 3.93),
(null, "Rebecca", "Daphne du Maurier", null, "Mystery", 4.24),
(null, "In Cold Blood", "Truman Capote", null, "Mystery", 4.08),
(null, "The Godfather", "Mario Puzo", null, "Mystery", 4.37),
(null, "The Lovely Bones", "Alice Sebold", null, "Mystery", 3.84),
(null, "Gone Girl", "Gillian Flynn", null, "Mystery", 4.11),
(null, "The Name of the Rose", "Umberto Eco", null, "Mystery", 4.13),
(null, "Shutter Island", "Dennis Lehane", null, "Mystery", 4.09),
#Romance
(null, "Pride and Prejudice", "Jane Austen", null, "Romance", 4.28),
(null, "Outlander", "Diana Gabaldon", null, "Romance", 4.25),
(null, "Jane Eyre", "Charlotte Bronte", null, "Romance", 4.14),
(null, "Gone with the Wind", "Margaret Mitchell", null, "Romance", 4.30),
(null, "Sense and Sensibility", "Jane Austen", null, "Romance", 4.08),
(null, "The Notebook", "Nicholas Sparks", null, "Romance", 4.13),
(null, "Persuasion", "Jane Austen", null, "Romance", 4.15),
(null, "Dragonfly in the Amber", "Diana Gabaldon", null, "Romance", 4.33),
(null, "Voyager", "Diana Gabaldon", null, "Romance", 4.38),
(null, "Whitney, My Love", "Judith McNaught", null, "Romance", 4.13);
