CREATE PROCEDURE  'SRLP'.'insert_product'
	(IN product_id NUMBER, IN product_name VARCHAR(45), IN brand VARCHAR(45), IN price NUMBER)
BEGIN
    insert into products values (product_id, product_name, brand, price);
END;
/

