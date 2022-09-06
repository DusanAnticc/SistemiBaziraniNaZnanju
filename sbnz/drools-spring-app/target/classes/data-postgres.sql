INSERT INTO pump (is_open) VALUES (false);

INSERT INTO valve (is_open) VALUES (false);

INSERT INTO valve (is_open) VALUES (false);

INSERT INTO valve (is_open) VALUES (false);

INSERT INTO valve (is_open) VALUES (false);

INSERT INTO valve (is_open) VALUES (false);

INSERT INTO valve (is_open) VALUES (false);

INSERT INTO valve (is_open) VALUES (false);

INSERT INTO valve (is_open) VALUES (false);

INSERT INTO pump (is_open) VALUES (false);

INSERT INTO pump (is_open) VALUES (false);

INSERT INTO pump (is_open) VALUES (false);

INSERT INTO part (name) VALUES ('rotor');

INSERT INTO part (name) VALUES ('stator');

INSERT INTO part (name) VALUES ('blades');

INSERT INTO part (name) VALUES ('valves');

INSERT INTO water_tank (max_value, min_value, current_value, minerals_in_water, enough_minerals, input_valve_id, output_valve_id) VALUES (100000, 10000, 50000, 7, true, 5, 6);

INSERT INTO water_tank (max_value, min_value, current_value, minerals_in_water, enough_minerals, input_valve_id, output_valve_id) VALUES (100000, 10000, 50000, 7, true, 7, 8);

INSERT INTO machine (dtype, malfunction, brand, model, year, current_steam_value,state, pump_id, valve_id, water_tank_id) VALUES ('SteamMachine', false , 'Brand1', 'Model1', '2016', 620.0, 1, 1, 1, 1);

INSERT INTO machine (dtype, malfunction, brand, model, year, current_steam_value,state, pump_id, valve_id, water_tank_id) VALUES ('SteamMachine', false , 'Brand2', 'Model2', '2017', 520.0, 1, 2, 2, 1);

INSERT INTO machine (dtype, malfunction, brand, model, year, current_steam_value,state, pump_id, valve_id, water_tank_id) VALUES ('SteamMachine', false , 'Brand3', 'Model3', '2018', 650.0, 1, 3, 3, 1);

INSERT INTO log (message, user_name, execution_time, part_id, steam_machine_id) VALUES ('rotor stop working', 'Mirko', 1662225219219 , 1 , 1 );

INSERT INTO log (message, user_name, execution_time, part_id, steam_machine_id) VALUES ('stator overheated', 'Mirko', 1662225219219 , 2 , 1 );

INSERT INTO log (message, user_name, execution_time, part_id, steam_machine_id) VALUES ('blades failure', 'Mirko', 1662225219219 , 3 , 1 );

INSERT INTO log (message, user_name, execution_time, part_id, steam_machine_id) VALUES ('valve failure', 'Mirko', 1662225219219 , 4 , 2 );

INSERT INTO log (message, user_name, execution_time, part_id, steam_machine_id) VALUES ('valve stuck', 'Mirko', 1662225219219 , 4 , 2 );

INSERT INTO log (message, user_name, execution_time, part_id, steam_machine_id) VALUES ('stator failure', 'Mirko', 1662225219219 , 2 , 3 );

INSERT INTO log (message, user_name, execution_time, part_id, steam_machine_id) VALUES ('rotor stuck', 'Mirko', 1662225219219 , 1 , 3 );

INSERT INTO service_log (execution_time, part_id, steam_machine_id) VALUES (1662225219220 , 1 , 1 );

INSERT INTO log_temperatures(steam_machine_id, temperatures) VALUES (1, 450);

INSERT INTO log_temperatures(steam_machine_id, temperatures) VALUES (1, 550);

INSERT INTO log_temperatures(steam_machine_id, temperatures) VALUES (1, 650);

INSERT INTO log_temperatures(steam_machine_id, temperatures) VALUES (1, 350);

INSERT INTO log_temperatures(steam_machine_id, temperatures) VALUES (1, 850);

INSERT INTO log_temperatures(steam_machine_id, temperatures) VALUES (2, 550);

INSERT INTO log_temperatures(steam_machine_id, temperatures) VALUES (2, 650);

INSERT INTO log_temperatures(steam_machine_id, temperatures) VALUES (2, 350);

INSERT INTO log_temperatures(steam_machine_id, temperatures) VALUES (2, 850);

INSERT INTO log_temperatures(steam_machine_id, temperatures) VALUES (3, 550);

INSERT INTO log_temperatures(steam_machine_id, temperatures) VALUES (3, 650);

INSERT INTO log_temperatures(steam_machine_id, temperatures) VALUES (3, 350);

INSERT INTO log_temperatures(steam_machine_id, temperatures) VALUES (3, 850);

INSERT INTO role (name) values ('ROLE_WORKER');

INSERT INTO role (name) values ('ROLE_GUEST');

-- SIFRE: 1234
INSERT INTO users (dtype, first_name, last_name, username, email, password, deleted, role_id, prosecuted, penalty)
values ('Worker', 'Nikola', 'Nikolic', 'nikola', 'nikola@gmail.com', '$2a$12$y8KdnPdbPx39blqlCZsQR.fWCJfKA/vws626apsRnuKj2LMyWdwpq', false, 1, false, 0);

INSERT INTO users (dtype, first_name, last_name, username, email, password, deleted, role_id, prosecuted, penalty)
values ('Guest', 'Milana', 'Milosevic', 'milana', 'milana@gmail.com', '$2a$12$y8KdnPdbPx39blqlCZsQR.fWCJfKA/vws626apsRnuKj2LMyWdwpq', false, 2, false, 0);


