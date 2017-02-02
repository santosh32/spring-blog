CREATE OR REPLACE PROCEDURE get_product_by_id (
  inout_prod_id IN out NUMBER , 
  out_name out VARCHAR2, 
  out_brand out VARCHAR2, 
  out_price out NUMBER  
) AS 
BEGIN
  FOR c IN (SELECT prod_id, name, brand, price
	INTO inout_prod_id, out_name, out_brand, out_price
	FROM products WHERE prod_id = prod_id)
  loop
    inout_prod_id := c.prod_id;
    out_name := c.name;
    out_brand := c.brand;
    out_price := c.price;
  END loop;
END get_product_by_id;