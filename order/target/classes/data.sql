DROP TABLE IF EXISTS orders;

CREATE TABLE orders(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  customer_name VARCHAR(250) NOT NULL,
  date VARCHAR(250) NOT NULL,
  shipping_address VARCHAR(250) NOT NULL,
  order_items_id INT,
  total_cost DOUBLE
);

 