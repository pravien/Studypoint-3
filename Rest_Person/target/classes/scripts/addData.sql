INSERT INTO BOOK (ID, TITLE) VALUES (null, 'book-3');
SET @book1 = LAST_INSERT_ID();
INSERT INTO BOOK (ID, TITLE) VALUES (null, 'book-4');
SET @book2 = LAST_INSERT_ID();
Insert INTO Customer(firstname,lastname) VALUES ("jens","jens");
SET @Customer1 = LAST_INSERT_ID();

