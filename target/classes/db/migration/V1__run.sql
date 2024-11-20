CREATE TABLE todo (
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255),
    name VARCHAR(255),
    priority INT,
    realized BIT(1)
);