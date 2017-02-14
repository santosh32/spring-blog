CREATE OR REPLACE FUNCTION get_price_by_id(in_prod_id IN VARCHAR2)
    RETURN VARCHAR(20);
 IS 
   out_price VARCHAR(20); 
BEGIN 
	SELECT price INTO out_price FROM product WHERE prod_id = in_prod_id;
RETURN get_price_by_id;
END;
/