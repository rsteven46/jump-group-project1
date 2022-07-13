CREATE DATABASE ProgressTracker;

USE ProgressTracker;

CREATE TABLE user (
userID int auto_increment PRIMARY KEY,
username varchar(255),
passwd varchar(30)
);

CREATE TABLE book (
bookID int auto_increment PRIMARY KEY,
bookName varchar(255),
author varchar(255),
pages int
);


CREATE TABLE tracker (

userID int,

bookID int,

FOREIGN KEY (userID)
REFERENCES user(userID),

FOREIGN KEY (bookID)
REFERENCES book(bookID),

progressStatus varchar(255),

PRIMARY KEY(userID, bookID)

);

INSERT INTO user (userID, username, passwd)
VALUES (null, "Steven", "Password");

INSERT INTO user (userID, username, passwd)
VALUES (null, "Zainal", "Password");

INSERT INTO user (userID, username, passwd)
VALUES (null, "Nick", "Password");

INSERT INTO book (bookID, bookName, author, pages)
VALUES (null, "Harry Potter 1", "JK Rowling", 592);

INSERT INTO book (bookID, bookName, author, pages)
VALUES (null, "Harry Potter 2", "JK Rowling", 712);

INSERT INTO book (bookID, bookName, author, pages)
VALUES (null, "Harry Potter 3", "JK Rowling", 463);

INSERT INTO book (bookID, bookName, author, pages)
VALUES (null, "Harry Potter 4", "JK Rowling", 555);

INSERT INTO book (bookID, bookName, author, pages)
VALUES (null, "Harry Potter 5", "JK Rowling", 596);

INSERT INTO book (bookID, bookName, author, pages)
VALUES (null, "Harry Potter 6", "JK Rowling", 1000);

INSERT INTO book (bookID, bookName, author, pages)
VALUES (null, "Harry Potter 7", "JK Rowling", 1005);

INSERT INTO book (bookID, bookName, author, pages)
VALUES (null, "The Fellowship of the Rings", "J.R.R. Tolkien", 1200);

INSERT INTO book (bookID, bookName, author, pages)
VALUES (null, "The Two Towers", "J.R.R. Tolkien", 1300);

INSERT INTO book (bookID, bookName, author, pages)
VALUES (null, "Return of the King", "J.R.R. Tolkien", 1500);

INSERT INTO tracker (userID, bookID, progressStatus)
VALUES (1, 9, "Not started");

INSERT INTO tracker (userID, bookID, progressStatus)
VALUES (2, 5, "Not started");

INSERT INTO tracker (userID, bookID, progressStatus)
VALUES (3, 10, "Not started");

INSERT INTO tracker (userID, bookID, progressStatus)
VALUES (3, 10, "Not started");





