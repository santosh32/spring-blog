CREATE OR REPLACE PROCEDURE get_product_by_id (
  in_prod_id IN product.prod_id%TYPE, 
  out_recordset out sys_refcursor) 
AS 
BEGIN
  OPEN out_recordset FOR 
  	SELECT prod_id, name, brand, price FROM product WHERE prod_id = in_prod_id;
END get_product_by_id;