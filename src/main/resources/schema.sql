DROP DATABASE bookworm_db;

CREATE DATABASE IF NOT EXISTS bookworm_db;

USE bookworm_db;



CREATE TABLE IF NOT EXISTS USER(
    USER_ID SERIAL PRIMARY KEY,
    FIRST_NAME VARCHAR(75) NOT NULL,
    LAST_NAME VARCHAR(75) NOT NULL,
    USERNAME VARCHAR(25) NOT NULL UNIQUE,
    EMAIL VARCHAR(125) NOT NULL UNIQUE,
    PASSWORD VARCHAR(25) NOT NULL,
    BIO VARCHAR(150)
);

CREATE TABLE IF NOT EXISTS BOOKSHELF(
      BOOK_ID SERIAL PRIMARY KEY,
      ISBN LONG NULL,
      BOOK_TITLE VARCHAR(250) NOT NULL,
      AUTHOR VARCHAR(100) NOT NULL,
      DATA_PUBLISHED VARCHAR(75) NOT NULL,
      COVER_PAGE VARCHAR(250),
      DESCRIPTION LONGTEXT NOT NULL,
      GENRE VARCHAR(75) NOT NULL,
      PAGE_COUNT INT NOT NULL,
      RATING INT NOT NULL
)


