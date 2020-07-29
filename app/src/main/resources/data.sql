DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nip VARCHAR(50) NOT NULL,
    full_name VARCHAR(250) NOT NULL,
    position VARCHAR(250) DEFAULT NULL
);

INSERT INTO employee (nip, full_name, position) VALUES
    ('001', 'Lorem Ipsum', 'VP'),
    ('002', 'Hello', 'AVP');