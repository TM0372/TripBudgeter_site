CREATE TABLE IF NOT EXISTS countries (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    daily_usd INTEGER NOT NULL
);

INSERT INTO countries (name, daily_usd) VALUES
('Germany', 120),
('Poland', 70),
('Italy', 130),
('Greece', 110),
('Thailand', 55),
('Japn', 100),
('Israel', 200);