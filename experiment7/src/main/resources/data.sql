-- user1 / user123   (ROLE_USER)
-- admin1 / admin123 (ROLE_ADMIN)
INSERT INTO users (id, username, password, role) VALUES
(1, 'user1',  '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'ROLE_USER'),
(2, 'admin1', '$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk2wWpS', 'ROLE_ADMIN');
