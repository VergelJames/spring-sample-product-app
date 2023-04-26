############################################
#
# DATA DEFINITION LANGUAGE (DDL) SCRIPTS
############################################


DROP TABLE IF EXISTS `country`;
CREATE TABLE `country`(
    country_id          INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name                VARCHAR(255),
    code                VARCHAR(20),
    iso_code            VARCHAR(20),
    status				VARCHAR(3) NOT NULL DEFAULT 'ACT'
) ENGINE=InnoDB;


DROP TABLE IF EXISTS `segment`;
CREATE TABLE `segment`(
    segment_id          INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name                VARCHAR(255),
    status				VARCHAR(3) NOT NULL DEFAULT 'ACT'
) ENGINE=InnoDB;


DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`(
    product_id                  BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name                        VARCHAR(255),
    status                      VARCHAR(3) NOT NULL DEFAULT 'ACT'
) ENGINE=InnoDB;


DROP TABLE IF EXISTS `product_detail`;
CREATE TABLE `product_detail`(
    product_details_id          BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    product_id                  BIGINT UNSIGNED NOT NULL REFERENCES product(product_id),
    segment_id                  INT UNSIGNED NOT NULL REFERENCES segment(segment_id),
    country_id                  INT UNSIGNED NOT NULL REFERENCES country(country_id),
    discount_band               VARCHAR(50) NULL,
    units_sold                  DECIMAL(11, 2) NULL,
    manufacturing_price         DECIMAL(11, 2) NULL,
    sale_price                  DECIMAL(11, 2) NULL,
    gross_sales                 DECIMAL(11, 2) NULL,
    discounts                   DECIMAL(11, 2) NULL,
    sales                       DECIMAL(11, 2) NULL,
    cogs                        DECIMAL(11, 2) NULL,
    profit                      DECIMAL(11, 2) NULL,
    date                        DATE NULL,
    status                      VARCHAR(3) NOT NULL DEFAULT 'ACT'
) ENGINE=InnoDB;