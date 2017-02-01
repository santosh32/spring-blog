CREATE PROCEDURE 'SRLP'.'get_product'(IN in_prod_id NUMBER,
	    OUT out_prod_name VARCHAR(255),
	    OUT out_prod_brand VARCHAR(255),
	    OUT out_prod_price NUMBER)
    BEGIN
	SELECT product_name, brand, price
	INTO out_prod_name, out_prod_brand, out_prod_price
	FROM products WHERE product_id = in_prod_id;
    END;
/