DROP TABLE IF EXISTS customer;

CREATE TABLE customer
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name  VARCHAR(250) NOT NULL,
    age        NUMERIC      NOT NULL
);

INSERT INTO customer (first_name, last_name, age)
VALUES ('Aliko', 'Dangote', 24),
       ('Bill', 'Gates', 32),
       ('Folrunsho', 'Alakija', 21);
