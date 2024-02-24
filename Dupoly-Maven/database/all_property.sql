CREATE TABLE all_property (
    property_name varchar(50) UNIQUE NOT NULL,
    set_name varchar(50) NOT NULL,
    PRIMARY KEY (property_name)
);

-- add tax
-- lightning
-- airports

INSERT INTO all_property (property_name, set_name) VALUES
('New York City', 'New York'),      -- East $$$ (New York 1)
('Poughkeepskie', 'New York'),      -- East $$$ (New York 2)

('Miami', 'Florida'),              -- East $$ 1 (Florida 1)
('Tampa', 'Florida'),              -- East $$ 1 (Florida 2)
('Orlando', 'Florida'),            -- East $$ 1 (Florida 3)

('Boston', 'Massachusetts'),             -- East $$ 2 (Massachusetts 1)
('Cambridge', 'Massachusetts'),          -- East $$ 2 (Massachusetts 2)
('Salem', 'Massachusetts'),              -- East $$ 2 (Massachusetts 3)

('Detroit', 'Michigan'),            -- East $$ 3 (Michigan 1)
('Flint', 'Michigan'),              -- East $$ 3 (Michigan 2)
('Rochester', 'Michigan'),          -- East $$ 3 (Michigan 3)

('Cleveland', 'Ohio'),          -- East $$ 4 (Ohio 1)
('Cincinnati', 'Ohio'),         -- East $$ 4 (Ohio 2)
('Beavercreek', 'Ohio'),        -- East $$ 4 (Ohio 3)

('Stowe', 'Vermont'),              -- East $ (Vermont 1)
('Burlington', 'Vermont'),         -- East $ (Vermont 2)

-- EAST COAST BEST COAST RAHHHH

('Los Angeles', 'California'),        -- West $$$ (Cali 1)
('San Francisco', 'California'),      -- West $$$ (Cali 2)

('Las Vegas', 'Nevada'),          -- West $$ 1 (Nevada 1)
('Henderson', 'Nevada'),          -- West $$ 1 (Nevada 2)
('Boulder City', 'Nevada'),       -- West $$ 1 (Nevada 3)

('San Antonio', 'Texas'),        -- West $$ 2 (Texas 1)
('Dallas', 'Texas'),             -- West $$ 2 (Texas 2)
('Houston', 'Texas'),            -- West $$ 2 (Texas 3)

('Portland', 'Oregon'),           -- West $$ 3 (Oregon 1)
('Eugene', 'Oregon'),             -- West $$ 3 (Oregon 2)
('Oregon City', 'Oregon'),        -- West $$ 3 (Oregon 3)

('Seattle', 'Washington'),            -- West $$ 4 (Washington 1)
('Olympia', 'Washington'),            -- West $$ 4 (Washington 2)
('Vancouver', 'Washington'),          -- West $$ 4 (Washington 3)

('Albuquerque', 'New Mexico'),        -- West $ (New Mexico 1)
('Santa Fe', 'New Mexico'),            -- West $ (New Mexico 2)

('Electric Company', 'Utility'),
('Water Company', 'Utility'),

('Tax', 'Tax')

;