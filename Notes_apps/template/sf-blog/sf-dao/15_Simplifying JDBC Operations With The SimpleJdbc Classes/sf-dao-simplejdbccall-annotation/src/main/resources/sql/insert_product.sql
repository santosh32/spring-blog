CREATE OR REPLACE PROCEDURE insert_product(
    in_prod_id IN NUMBER ,
    in_name    IN VARCHAR2 ,
    in_brand   IN VARCHAR2 ,
    in_price   IN NUMBER )
AS
BEGIN
  INSERT INTO products (prod_id, name, brand, price) VALUES  (in_prod_id, in_name, in_brand, in_price);
  COMMIT;
END insert_product;