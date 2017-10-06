set database sql syntax ORA true;

ALTER TABLE node_group_ref DROP CONSTRAINT node_group_ref_fk1;
ALTER TABLE calendar_ref DROP CONSTRAINT calendar_ref_fk;
ALTER TABLE INVENTORY_ORGANIZATION_REF DROP CONSTRAINT INVENTORY_ORGANIZATION_REF_FK1;
ALTER TABLE inventory_organization_ref DROP CONSTRAINT inventory_organization_ref_fk2;

DROP TABLE node_group_node_map ;
DROP TABLE node_fulfillment_type_map ;
DROP TABLE node_ref ;
DROP TABLE node_group_ref ;
DROP TABLE store_ref ;
DROP TABLE day_of_week_ref ;
DROP TABLE calendar_exception_ref ;
DROP TABLE calendar_ref ;
DROP TABLE inventory_organization_ref ;
DROP TABLE fulfillment_type_ref ;
DROP TABLE node_type_ref ;
DROP TABLE shift_ref ;
DROP TABLE day_ref ;
DROP TABLE address_ref ;
DROP TABLE unit_of_measure_ref ;
DROP TABLE product_class_ref ;


CREATE TABLE product_class_ref (
    product_class_id        VARCHAR(24) NOT NULL,
    description             VARCHAR(100) NOT NULL,
    CONSTRAINT product_class_ref_pk PRIMARY KEY (product_class_id)
);

CREATE TABLE unit_of_measure_ref (
    unit_of_measure_id      VARCHAR(24) NOT NULL,
    unit_of_measure_type    VARCHAR(24) NOT NULL,
    description             VARCHAR(100) NOT NULL,
    CONSTRAINT unit_of_measure_ref_pk PRIMARY KEY (unit_of_measure_id)
);

CREATE TABLE address_ref (
    address_id                      NUMBER NOT NULL,
    address_line1                   VARCHAR(100) NOT NULL,
    address_line2                   VARCHAR(100),
    address_line3                   VARCHAR(100),
    address_line4                   VARCHAR(100),
    address_city                    VARCHAR(35) NOT NULL,
    main_division_code              VARCHAR(35),
    postal_code                     VARCHAR(10),
    country_code                    VARCHAR(3) NOT NULL,
    address_email                   VARCHAR(150),
    address_phone                   VARCHAR(24),
    CONSTRAINT address_ref_pk PRIMARY KEY (address_id)
);

CREATE TABLE day_ref (
    day_id                          NUMBER NOT NULL,
    working_flag                    VARCHAR(1) NOT NULL,
    CONSTRAINT day_ref_pk PRIMARY KEY (day_id)
);

CREATE TABLE shift_ref (
    shift_id                        NUMBER NOT NULL,
    day_id                          NUMBER,
    start_time                      VARCHAR(5) NOT NULL,
    end_time                        VARCHAR(5) NOT NULL,
    max_items                       NUMBER,
    CONSTRAINT shift_ref_pk PRIMARY KEY (shift_id),
    CONSTRAINT shift_ref_fk FOREIGN KEY (day_id) REFERENCES day_ref(day_id)
);



CREATE TABLE fulfillment_type_ref (
    fulfillment_type_id     VARCHAR(24) NOT NULL,
    description             VARCHAR(100) NOT NULL,
    CONSTRAINT fulfillment_type_ref_pk PRIMARY KEY (fulfillment_type_id)
);

CREATE TABLE node_type_ref (
    node_type_id            VARCHAR(24) NOT NULL,
    description             VARCHAR(100) NOT NULL,
    CONSTRAINT node_type_ref_ref_pk PRIMARY KEY (node_type_id)
);

CREATE TABLE inventory_organization_ref (
    inventory_organization_id       VARCHAR(24) NOT NULL,
    inventory_organization_name     VARCHAR(100) NOT NULL,
    default_node_group_id           VARCHAR(24),
    default_shipping_calendar_id    VARCHAR(24),
    default_product_class_id        VARCHAR(24) NOT NULL,
    default_unit_of_measure_id      VARCHAR(24) NOT NULL,
    node_rejected_supply_action     VARCHAR(24) NOT NULL,
    active_for_availability_flag    VARCHAR(1) NOT NULL,
    CONSTRAINT inventory_organization_ref_pk PRIMARY KEY (inventory_organization_id),
    --CONSTRAINT inventory_organization_ref_fk1 FOREIGN KEY (inventory_organization_id, default_node_group_id) REFERENCES node_group_ref(inventory_organization_id, node_group_id),
    --CONSTRAINT inventory_organization_ref_fk2 FOREIGN KEY (inventory_organization_id, default_shipping_calendar_id) REFERENCES calendar_ref(inventory_organization_id, calendar_id),
    CONSTRAINT inventory_organization_ref_fk3 FOREIGN KEY (default_product_class_id) REFERENCES product_class_ref(product_class_id),
    CONSTRAINT inventory_organization_ref_fk4 FOREIGN KEY (default_unit_of_measure_id) REFERENCES unit_of_measure_ref(unit_of_measure_id)
);

CREATE TABLE calendar_ref (
    inventory_organization_id       VARCHAR(24) NOT NULL,
    calendar_id                     VARCHAR(24) NOT NULL,
    calendar_description            VARCHAR(100) NOT NULL,
    default_day_id                  NUMBER NOT NULL,
    CONSTRAINT calendar_ref_pk PRIMARY KEY (inventory_organization_id, calendar_id),
    --CONSTRAINT calendar_ref_fk FOREIGN KEY (inventory_organization_id) REFERENCES inventory_organization_ref(inventory_organization_id),
    CONSTRAINT calendar_ref_fk2 FOREIGN KEY (default_day_id) REFERENCES day_ref(day_id)
);

ALTER TABLE inventory_organization_ref ADD CONSTRAINT inventory_organization_ref_fk2 FOREIGN KEY (inventory_organization_id, default_shipping_calendar_id) REFERENCES calendar_ref(inventory_organization_id, calendar_id) initially deferred deferrable;

ALTER TABLE calendar_ref ADD CONSTRAINT calendar_ref_fk FOREIGN KEY (inventory_organization_id) REFERENCES inventory_organization_ref(inventory_organization_id) initially deferred deferrable;

CREATE TABLE calendar_exception_ref (
    inventory_organization_id       VARCHAR(24) NOT NULL,
    calendar_exception_id           NUMBER NOT NULL,
    calendar_id                     VARCHAR(24) NOT NULL,
    calendar_date                   DATE NOT NULL,
    exception_day_id                NUMBER NOT NULL,
    CONSTRAINT calendar_exception_ref_pk PRIMARY KEY (inventory_organization_id, calendar_exception_id),
    CONSTRAINT calendar_exception_ref_fk1 FOREIGN KEY (inventory_organization_id) REFERENCES inventory_organization_ref(inventory_organization_id),
    CONSTRAINT calendar_exception_ref_fk2 FOREIGN KEY (inventory_organization_id, calendar_id) REFERENCES calendar_ref(inventory_organization_id, calendar_id),
    CONSTRAINT calendar_exception_ref_fk3 FOREIGN KEY (exception_day_id) REFERENCES day_ref(day_id)
);

CREATE TABLE day_of_week_ref (
    inventory_organization_id       VARCHAR(24) NOT NULL,
    calendar_id                     VARCHAR(24) NOT NULL,
    day_id                          NUMBER NOT NULL,
    day_of_week                     NUMBER NOT NULL,
    CONSTRAINT day_of_week_ref_pk PRIMARY KEY (inventory_organization_id, calendar_id, day_id),
    CONSTRAINT day_of_week_ref_fk1 FOREIGN KEY (inventory_organization_id) REFERENCES inventory_organization_ref(inventory_organization_id),
    CONSTRAINT day_of_week_ref_fk2 FOREIGN KEY (inventory_organization_id, calendar_id) REFERENCES calendar_ref(inventory_organization_id, calendar_id),
    CONSTRAINT day_of_week_ref_fk3 FOREIGN KEY (day_id) REFERENCES day_ref(day_id)
);

CREATE TABLE store_ref (
    store_id                        VARCHAR(24) NOT NULL,
    store_name                      VARCHAR(100) NOT NULL,
    client_id                       VARCHAR(24) NOT NULL,
    inventory_organization_id       VARCHAR(24) NOT NULL,
    default_fulfillment_type_id     VARCHAR(24) NOT NULL,
    default_latest_ship_date_days   NUMBER NOT NULL,
    CONSTRAINT store_ref_pk PRIMARY KEY (store_id),
    CONSTRAINT store_ref_fk1 FOREIGN KEY (inventory_organization_id) REFERENCES inventory_organization_ref(inventory_organization_id),
    CONSTRAINT store_ref_fk2 FOREIGN KEY (default_fulfillment_type_id) REFERENCES fulfillment_type_ref(fulfillment_type_id)
);

CREATE TABLE node_group_ref (
    inventory_organization_id       VARCHAR(24) NOT NULL,
    node_group_id                   VARCHAR(24) NOT NULL,
    node_group_description          VARCHAR(100),
    CONSTRAINT node_group_ref_pk PRIMARY KEY (inventory_organization_id, node_group_id)--,
    --CONSTRAINT node_group_ref_fk1 FOREIGN KEY (inventory_organization_id) REFERENCES inventory_organization_ref(inventory_organization_id)
);

ALTER TABLE inventory_organization_ref ADD CONSTRAINT inventory_organization_ref_fk1 FOREIGN KEY (inventory_organization_id, default_node_group_id) REFERENCES node_group_ref(inventory_organization_id, node_group_id) initially deferred deferrable;

ALTER TABLE node_group_ref ADD CONSTRAINT node_group_ref_fk1 FOREIGN KEY (inventory_organization_id) REFERENCES inventory_organization_ref(inventory_organization_id) initially deferred deferrable;

CREATE TABLE node_ref (
    inventory_organization_id       VARCHAR(24) NOT NULL,
    node_id                         VARCHAR(24) NOT NULL,
    node_type_id                    VARCHAR(24) NOT NULL,
    node_description                VARCHAR(100),
    node_priority                   NUMBER,
    address_id                      NUMBER NOT NULL,
    shipping_calendar_id            VARCHAR(24),
    node_latitude                   NUMBER(11, 8),
    node_longitude                  NUMBER(11, 8),
    locale_code                     VARCHAR(4) NOT NULL,
    zone_id                         VARCHAR(24),
    node_rejected_supply_action     VARCHAR(24),
    receipt_processing_days         NUMBER,
    min_shipment_processing_days    NUMBER,
    max_shipment_processing_days    NUMBER,
    infinite_flag                   VARCHAR(1) NOT NULL,
    active_for_availability_flag    VARCHAR(1) NOT NULL,
    ship_node_flag                  VARCHAR(1) NOT NULL,
    giftwrap_allowed_flag           VARCHAR(1) NOT NULL,
    CONSTRAINT node_ref_pk PRIMARY KEY (inventory_organization_id, node_id),
    CONSTRAINT node_ref_fk1 FOREIGN KEY (inventory_organization_id) REFERENCES inventory_organization_ref(inventory_organization_id),
    CONSTRAINT node_ref_fk2 FOREIGN KEY (node_type_id) REFERENCES node_type_ref(node_type_id),
    CONSTRAINT node_ref_fk3 FOREIGN KEY (address_id) REFERENCES address_ref(address_id),
    CONSTRAINT node_ref_fk4 FOREIGN KEY (inventory_organization_id, shipping_calendar_id) REFERENCES calendar_ref(inventory_organization_id, calendar_id)
);

CREATE TABLE node_fulfillment_type_map (
    inventory_organization_id       VARCHAR(24) NOT NULL,
    node_id                         VARCHAR(24) NOT NULL,
    fulfillment_type_id             VARCHAR(24) NOT NULL,
    CONSTRAINT node_fulfillment_type_map_pk PRIMARY KEY (inventory_organization_id, node_id, fulfillment_type_id),
    CONSTRAINT node_fulfillment_type_map_fk1 FOREIGN KEY (inventory_organization_id) REFERENCES inventory_organization_ref(inventory_organization_id),
    CONSTRAINT node_fulfillment_type_map_fk2 FOREIGN KEY (inventory_organization_id, node_id) REFERENCES node_ref(inventory_organization_id, node_id),
    CONSTRAINT node_fulfillment_type_map_fk3 FOREIGN KEY (fulfillment_type_id) REFERENCES fulfillment_type_ref(fulfillment_type_id)
);

CREATE TABLE node_group_node_map (
    inventory_organization_id       VARCHAR(24) NOT NULL,
    node_group_id                   VARCHAR(24) NOT NULL,
    node_id                         VARCHAR(24) NOT NULL,
    node_group_node_priority        NUMBER,
    node_group_node_start_date      DATE,
    node_group_node_end_date        DATE,
    node_group_node_active_flag     VARCHAR(1) NOT NULL,
    CONSTRAINT node_group_node_map_pk PRIMARY KEY (inventory_organization_id, node_group_id, node_id),
    CONSTRAINT node_group_node_map_fk1 FOREIGN KEY (inventory_organization_id) REFERENCES inventory_organization_ref(inventory_organization_id),
    CONSTRAINT node_group_node_map_fk2 FOREIGN KEY (inventory_organization_id, node_group_id) REFERENCES node_group_ref(inventory_organization_id, node_group_id),
    CONSTRAINT node_group_node_map_fk3 FOREIGN KEY (inventory_organization_id, node_id) REFERENCES node_ref(inventory_organization_id, node_id)
);


DROP SEQUENCE DAY_ID_SEQ IF EXISTS;
DROP SEQUENCE SHIFT_ID_SEQ IF EXISTS;
DROP SEQUENCE CALENDAR_EXCEPTION_ID_SEQ IF EXISTS;
DROP SEQUENCE ADDRESS_ID_SEQ IF EXISTS;

CREATE SEQUENCE DAY_ID_SEQ AS INTEGER START WITH 1001 INCREMENT BY 1;
CREATE SEQUENCE SHIFT_ID_SEQ AS INTEGER START WITH 10001 INCREMENT BY 1;
CREATE SEQUENCE CALENDAR_EXCEPTION_ID_SEQ AS INTEGER START WITH 2001 INCREMENT BY 1;
CREATE SEQUENCE ADDRESS_ID_SEQ AS INTEGER START WITH 101 INCREMENT BY 1;