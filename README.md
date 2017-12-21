# Problem

Shopping cart microservice.

# Solution

2 Microservices implemented using Spring boot, java 8, maven, activemq, angularjs  and hibernate.



### Retrieve all products :

GET url:  http://localhost:8080/product/v1/list

### Retrieve specific product:

GET url:  http://localhost:8080/product/v1/5

### Create new product

### Update existing product

### Submit an order (that has one to many items and each item has one product with certain quantity)



### Persist a new order with chosen products and their quantities:

Post url: Post url:  http://localhost:8080/order/v1/save
Content-Type : application/json
body (raw): Place the json one wants to persist.

[{productId:1,quantity:2},{productId:2,quantity:3}]


## PERSISTENCE TIER.

### Database MYSQL  DML

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `user_logon` varchar(45) DEFAULT NULL,
  `user_password` varchar(45) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `item` (
  `item_id` BIGINT(20) NOT NULL,
  `product_id` BIGINT(20) NOT NULL,
  `quantity` int(11) NOT NULL DEFAULT '1',
  `order_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`item_id`),
  KEY `product_id_idx` (`product_id`),
  KEY `order_id_fk_idx` (`order_id`),
  CONSTRAINT `item_order_id_fk` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `item_product_id_fk` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `order` (
  `order_id` BIGINT(20) NOT NULL,
  `status_id` int(11) DEFAULT '0',
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `payment` (
  `payment_id` BIGINT(20) NOT NULL,
  `order_id`BIGINT(20) NOT NULL,
  `created` datetime DEFAULT CURRENT_TIMESTAMP,
  `value` double DEFAULT '0',
  `status_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`payment_id`,`order_id`),
  KEY `order_idFK_idx` (`order_id`),
  CONSTRAINT `payment_order_id_fk` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `product` (
  `product_id` bigint(20) NOT NULL,
  `product_desc` varchar(45) NOT NULL,
  `product_price` double DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `available` int(11) DEFAULT '0' COMMENT '1= yes, 0= no',
  `product_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `status` (
  `status_id` int(11) NOT NULL,
  `status_desc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



### MYSQL DDL


INSERT INTO `order`.`item`
(`item_id`,
`product_id`,
`quantity`,
`order_id`)
VALUES
(<{item_id: }>,
<{product_id: }>,
<{quantity: 1}>,
<{order_id: }>);



INSERT INTO `order`.`order`
(`order_id`,
`status_id`,
`created`)
VALUES
(<{order_id: }>,
<{status_id: 0}>,
<{created: CURRENT_TIMESTAMP}>);



INSERT INTO `order`.`payment`
(`payment_id`,
`order_id`,
`created`,
`value`,
`status_id`)
VALUES
(<{payment_id: }>,
<{order_id: }>,
<{created: CURRENT_TIMESTAMP}>,
<{value: 0}>,
<{status_id: }>);



INSERT INTO `order`.`product`
(`product_id`,
`product_desc`,
`product_price`,
`created`,
`available`)
VALUES
(<{product_id: }>,
<{product_desc: }>,
<{product_price: }>,
<{created: }>,
<{available: 0}>);



INSERT INTO `order`.`status`
(`status_id`,
`status_desc`)
VALUES
(<{status_id: }>,
<{status_desc: }>);
