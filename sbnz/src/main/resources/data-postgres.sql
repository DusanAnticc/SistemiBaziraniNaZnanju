-- Lozinke su hesovane pomocu BCrypt algoritma https://www.dailycred.com/article/bcrypt-calculator
-- Lozinka je 1234

INSERT INTO role (name) values ('ROLE_ADMIN');

INSERT INTO users (username, password, first_name, last_name, email, role_id, deleted)
VALUES ('admin', '$2a$10$VPwDVhCe69G71DmDg9iMXe3hXcS.YvhdkGf3f3GG93buXE60M73bG', 'Marko', 'Markovic', 'admin@example.com', 1, false);
