create table drone (
    id   INTEGER    NOT NULL AUTO_INCREMENT,
    serial_no VARCHAR(100) NOT NULL,
    model VARCHAR(50) NOT NULL,
    weight_limit decimal(5,2) NOT NULL,
    battery_capacity decimal(5,2) NOT NULL,
    state VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

create table medication (
    id   INTEGER    NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    weight decimal(5,2) NOT NULL,
    code VARCHAR(50) NOT NULL,
    image_path VARCHAR(250) NOT NULL,
    drone_id INTEGER,
    PRIMARY KEY (id)
);