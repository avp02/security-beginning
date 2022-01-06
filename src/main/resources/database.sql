CREATE TABLE users
(
    user_id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_name     VARCHAR(255) NOT NULL,
    user_password VARCHAR(255) NOT NULL
)
    ENGINE InnoDB;

CREATE TABLE roles
(
    role_id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(100) NOT NULL
)
    ENGINE InnoDB;

CREATE TABLE user_roles
(
    user_id INT NOT NULL UNIQUE,
    role_id INT NOT NULL UNIQUE,
    FOREIGN KEY user_roles (user_id) REFERENCES users (user_id),
    FOREIGN KEY user_roles (role_id) REFERENCES roles (role_id)
)
    ENGINE InnoDB;

INSERT INTO users
VALUES (1, 'Vavan', '$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG');

INSERT INTO roles
VALUES (1, 'ROLE_USER'),
       (2, 'ROLE_ADMIN');

INSERT INTO user_roles
VALUES (1, 2);