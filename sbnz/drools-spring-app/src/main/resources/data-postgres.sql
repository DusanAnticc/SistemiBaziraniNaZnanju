INSERT INTO pump (is_open) VALUES (false);

INSERT INTO valve (is_open) VALUES (false);

INSERT INTO valve (is_open) VALUES (false);

INSERT INTO valve (is_open) VALUES (false);

INSERT INTO pump (is_open) VALUES (false);

INSERT INTO valve (is_open) VALUES (false);

INSERT INTO valve (is_open) VALUES (false);

INSERT INTO valve (is_open) VALUES (false);

INSERT INTO part (name) VALUES ('rotor');

INSERT INTO part (name) VALUES ('stator');

INSERT INTO part (name) VALUES ('blades');

INSERT INTO part (name) VALUES ('valves');

INSERT INTO water_tank (max_value, min_value, current_value, minerals_in_water, enough_minerals, input_valve_id, output_valve_id) VALUES (100000, 10000, 50000, 7, true, 2, 3);

INSERT INTO water_tank (max_value, min_value, current_value, minerals_in_water, enough_minerals, input_valve_id, output_valve_id) VALUES (100000, 10000, 50000, 7, true, 5, 6);

INSERT INTO machine (dtype, brand, model, year, current_steam_value,state, pump_id, valve_id, water_tank_id) VALUES ('SteamMachine', 'Brand', 'Model', '2016', 600.0, 0, 1, 1, 1);

INSERT INTO machine (dtype, brand, model, year, current_steam_value,state, pump_id, valve_id, water_tank_id) VALUES ('SteamMachine2', 'Brand', 'Model', '2016', 620.0, 0, 2, 4, 2);

INSERT INTO log (message, user_name, execution_time, part_id, steam_machine_id) VALUES ('message', 'username', 11111 , 1 , 1 );

INSERT INTO log (message, user_name, execution_time, part_id, steam_machine_id) VALUES ('message', 'username', 11111 , 2 , 1 );

INSERT INTO log (message, user_name, execution_time, part_id, steam_machine_id) VALUES ('message', 'username', 11111 , 3 , 1 );

--INSERT INTO log (message, user_name, execution_time, part_id, steam_machine_id) VALUES ('message', 'username', 11111 , 3 , 2 );

--INSERT INTO log (message, user_name, execution_time, part_id, steam_machine_id) VALUES ('message', 'username', 11111 , 4 , 2 );

INSERT INTO log_temperatures(steam_machine_id, temperatures) VALUES (1, 450);

INSERT INTO log_temperatures(steam_machine_id, temperatures) VALUES (1, 550);

INSERT INTO log_temperatures(steam_machine_id, temperatures) VALUES (1, 650);

INSERT INTO log_temperatures(steam_machine_id, temperatures) VALUES (1, 350);

INSERT INTO log_temperatures(steam_machine_id, temperatures) VALUES (1, 850);

INSERT INTO role (name) values ('ROLE_WORKER');

INSERT INTO role (name) values ('ROLE_GUEST');

--INSERT INTO users (first_name, last_name, username, email, password, deleted, role_id)
--values ('Nikola', 'Nikolic', 'nikola', 'nikola@gmail.com', '1234', false, 1);
--
--INSERT INTO users (first_name, last_name, username, email, password, deleted, role_id)
--values ('Milana', 'Milosevic', 'milana', 'milana@gmail.com', '1234', false, 2);

