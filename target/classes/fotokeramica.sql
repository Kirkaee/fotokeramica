DROP TABLE IF EXISTS fc_order;
DROP TABLE IF EXISTS fc_point;

CREATE TABLE fc_point (
    point_id SERIAL,
    point_name varchar(500) not null,
    first_name varchar(100),
    last_name varchar(100),
    point_address varchar(500),
    point_phone varchar(30),
    point_type_of_transfer varchar(30),
    PRIMARY KEY (point_id)
);

CREATE TABLE fc_order (
    order_id SERIAL,
    point_id integer not null,
    order_date date not null,
    order_number varchar(10),
    order_carcass varchar(10),
    order_last_name varchar(100),
    order_holes varchar(100),
    order_size varchar(100),
    order_price varchar(20),
    PRIMARY KEY (order_id),
    FOREIGN KEY (point_id) REFERENCES fc_point(point_id) ON DELETE RESTRICT
);


