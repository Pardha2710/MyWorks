CREATE TABLE `customers` (
  `customerId` int(11) NOT NULL,
  `userName` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `firstname` varchar(30) DEFAULT NULL,
  `lastname` varchar(30) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `postalCode` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `orders` (
  `orderId` int(11) NOT NULL,
  `customerId` int(11) NOT NULL,
  `productId` int(11) NOT NULL,
  `orderDate` varchar(40) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `amountPaid` varchar(20) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `category` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`orderId`),
  KEY `customerId` (`customerId`),
  KEY `productId` (`productId`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `customers` (`customerId`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`productId`) REFERENCES `products` (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE `products` (
  `productId` int(11) NOT NULL,
  `productName` varchar(30) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `category` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `centennial`.`products`
(`productId`,
`productName`,
`price`,
`category`)
VALUES
(<{productId: }>,
<{productName: }>,
<{price: }>,
<{category: }>);


SELECT `products`.`productId`,
    `products`.`productName`,
    `products`.`price`,
    `products`.`category`
FROM `centennial`.`products`;


SET @productId_to_select = <{row_id}>;
SELECT products.*
    FROM products
    WHERE products.productId = @productId_to_select;
	
	
SET @customerId_to_select = <{row_id}>;
SELECT orders.*
    FROM orders, customers
    WHERE `customers`.`customerId` = `orders`.`customerId`
          AND customers.customerId = @customerId_to_select;
		  
SELECT customers.*
    FROM customers
    WHERE customers.customerId = @customerId_to_select;
	
UPDATE `centennial`.`customers`
SET
`customerId` = <{customerId: }>,
`userName` = <{userName: }>,
`password` = <{password: }>,
`firstname` = <{firstname: }>,
`lastname` = <{lastname: }>,
`address` = <{address: }>,
`city` = <{city: }>,
`postalCode` = <{postalCode: }>
WHERE `customerId` = <{expr}>;


UPDATE `centennial`.`orders`
SET
`orderId` = <{orderId: }>,
`customerId` = <{customerId: }>,
`productId` = <{productId: }>,
`orderDate` = <{orderDate: }>,
`status` = <{status: }>,
`amountPaid` = <{amountPaid: }>,
`quantity` = <{quantity: }>,
`category` = <{category: }>
WHERE `orderId` = <{expr}>;



-- All objects that reference that row (directly or indirectly) will be deleted when this snippet is executed.
-- To preview the rows to be deleted, use Select Row Dependencies
START TRANSACTION;
-- Provide the values of the primary key of the row to delete.
SET @orderId_to_delete = <{row_id}>;

DELETE FROM orders
    USING orders
    WHERE orders.orderId = @orderId_to_delete;
COMMIT;


