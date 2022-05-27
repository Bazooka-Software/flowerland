--DROP TABLE IF EXISTS CART_ITEM;
DROP TABLE IF EXISTS PRODUCT CASCADE;

CREATE TABLE PRODUCT (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    price INT NOT NULL,
    quantity INT NOT NULL,
    image_url VARCHAR(250) NOT NULL
);

--CREATE TABLE CART_ITEM (
 --   id INT AUTO_INCREMENT PRIMARY KEY,
 --   session_id VARCHAR(250) NOT NULL,
 --   quantity INT NOT NULL,
 --   product_id INT references product(id)
--);
