DELIMITER $$

CREATE  PROCEDURE  'SRLP'. 'insert_product_procedure'(

IN product_id INTEGER,

IN product_name VARCHAR(45),

IN brand VARCHAR(45),

IN price INTEGER)

BEGIN

    insert into products values (product_id,product_name,brand,price);

END$$

DELIMITER ;