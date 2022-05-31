INSERT INTO pump (is_open) VALUES (false);

INSERT INTO valve (is_open) VALUES (false);

INSERT INTO machine (dtype, brand, model, state, year, current_steam_value, pump_id, valve_id) VALUES ('SteamMachine', 'Brand', 'Model', 0, '2016', 600.0, 1, 1);