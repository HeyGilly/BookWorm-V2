DROP DATABASE bookworm_db;

CREATE DATABASE IF NOT EXISTS bookworm_db;

USE bookworm_db;



CREATE TABLE IF NOT EXISTS USER (
    USER_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    FIRST_NAME VARCHAR(75) NOT NULL,
    LAST_NAME VARCHAR(75) NOT NULL,
    USERNAME VARCHAR(25) NOT NULL UNIQUE,
    EMAIL VARCHAR(125) NOT NULL UNIQUE,
    PASSWORD VARCHAR(25) NOT NULL,
    BIO VARCHAR(160),
    PROFILE_PICTURE_PATH VARCHAR(255)
);
ALTER TABLE USER
    ADD RESET_TOKEN VARCHAR(36);

ALTER TABLE USER
    ADD role VARCHAR(25);

ALTER TABLE USER
    DROP COLUMN RESET_TOKEN;


CREATE TABLE IF NOT EXISTS BOOKSHELF(
    BOOK_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    ISBN LONG NULL,
    BOOK_TITLE VARCHAR(250) NOT NULL,
    AUTHOR VARCHAR(100) NOT NULL,
    DATA_PUBLISHED VARCHAR(75) NOT NULL,
    COVER_PAGE VARCHAR(250),
    DESCRIPTION LONGTEXT NOT NULL,
    GENRE VARCHAR(75) NOT NULL,
    PAGE_COUNT INT NOT NULL,
    RATING INT NOT NULL,
    GOOGLE_PLAY VARCHAR(250)
);

CREATE TABLE IF NOT EXISTS USER_REVIEWS(
    REVIEW_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    RATING INT NOT NULL,
    TITLE VARCHAR(250) NOT NULL,
    BODY LONGTEXT NOT NULL,
    BOOKSHELF_ID LONG NOT NULL,
    USER_ID LONG NOT NULL
);

ALTER TABLE USER_REVIEWS
    ADD COLUMN LIKED_COUNT INT NOT NULL DEFAULT 0;

CREATE TABLE IF NOT EXISTS LIKED_REVIEWS (
    LIKE_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    USER_ID BIGINT NOT NULL,
    REVIEW_ID BIGINT NOT NULL,
    LIKED_DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID),
    FOREIGN KEY (REVIEW_ID) REFERENCES USER_REVIEWS(REVIEW_ID)
);

drop table LIKED_REVIEWS;
-- Creating the GENRE table
CREATE TABLE GENRE (
   GENRE_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
   NAME VARCHAR(255)
);

-- Creating the USER_FAVORITE_GENRE table
CREATE TABLE FAVORITE_GENRE (
     USER_FAVORITE_GENRE_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
     USER_ID BIGINT,
     GENRE_ID BIGINT,
     FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID),
     FOREIGN KEY (GENRE_ID) REFERENCES GENRE(GENRE_ID)
);

-- Creating the USER_FAVORITE_GENRE table
CREATE TABLE FAVORITE_BOOKS (
    USER_FAVORITE_BOOK_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    USER_ID BIGINT,
    BOOK_ID BIGINT,
    FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID),
    FOREIGN KEY (BOOK_ID) REFERENCES BOOKSHELF(BOOK_ID)
);

CREATE TABLE IF NOT EXISTS BEST_FRIENDS (
    FRIENDSHIP_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    USER_ID BIGINT NOT NULL,
    FRIEND_ID BIGINT NOT NULL,
    STATUS VARCHAR(50),  -- This can be 'pending', 'accepted', 'declined', etc.
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID),
    FOREIGN KEY (FRIEND_ID) REFERENCES USER(USER_ID)
);



