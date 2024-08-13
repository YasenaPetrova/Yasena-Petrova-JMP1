

CREATE TABLE store.salesman (
    salesman_id INT PRIMARY KEY,
    name VARCHAR(255),
    city VARCHAR(255),
    commission DECIMAL(5,2)
);
INSERT INTO salesman (salesman_id, name, city, commission) VALUES
(5001, 'James Hoog', 'New York', 0.15),
(5002, 'salesman_idsalesman_idNail Knite', 'Paris', 0.13),
(5005, 'Pit Alex', 'London', 0.11),
(5006, 'Mc Lyon', 'Paris', 0.14),
(5007, 'Paul Adam', 'Rome', 0.13),
(5003, 'Lauson Hen', 'San Jose', 0.12);

SELECT * FROM SalesmanPerformance;



CREATE TABLE store.customer(
customer_id INT PRIMARY KEY,
	cust_name VARCHAR(100),
    city VARCHAR(50),
    grade INT,
    salesman_id INT,
    FOREIGN KEY (salesman_id) REFERENCES salesman(salesman_id)
);
INSERT INTO customer (customer_id, cust_name, city, grade, salesman_id) VALUES
(3002, 'Nick Rimando', 'New York', 100, 5001),
(3007, 'Brad Davis', 'New York', 200, 5001),
(3005, 'Graham Zusi', 'California', 200, 5002),
(3008, 'Julian Green', 'London', 300, 5002),
(3004, 'Fabian Johnson', 'Paris', 300, 5006),
(3009, 'Geoff Cameron', 'Berlin', 100, 5003),
(3003, 'Jozy Altidor', 'Moscow', 200, 5007),
(3001, 'Brad Guzan', 'London', NULL, 5005);

SELECT * FROM salespeople_multiple_clients;


SELECT 
    SUM(purch_amt) AS total_purchase_amount
FROM 
    orders;
    

SELECT 
    COUNT(*) AS number_of_customers
FROM 
    customer;


SELECT 
    MIN(purch_amt) AS minimum_purchase_amount
FROM 
    orders;

SELECT 
    MAX(purch_amt) AS maximum_purchase_amount
FROM 
    orders;



SELECT 
    customer_id, 
    MAX(purch_amt) AS maximum_purchase_amount
FROM 
    orders
GROUP BY 
    customer_id;


SELECT 
    ord_date, 
    MAX(purch_amt) AS highest_purchase_amount
FROM 
    orders
GROUP BY 
    ord_date;



CREATE TABLE item_mast (
    PRO_ID INT PRIMARY KEY,
    PRO_NAME VARCHAR(255),
    PRO_PRICE DECIMAL(10, 2),
    PRO_COM INT
);

INSERT INTO item_mast (PRO_ID, PRO_NAME, PRO_PRICE, PRO_COM) VALUES
(101, 'Mother Board', 3200.00, 15),
(102, 'Key Board', 450.00, 16),
(103, 'ZIP drive', 250.00, 14),
(104, 'Speaker', 550.00, 16),
(105, 'Monitor', 5000.00, 11),
(106, 'DVD drive', 900.00, 12),
(107, 'CD drive', 800.00, 12),
(108, 'Printer', 2600.00, 13),
(109, 'Refill cartridge', 350.00, 13),
(110, 'Mouse', 250.00, 12);

SELECT 
    PRO_COM AS company_id, 
    AVG(PRO_PRICE) AS average_price
FROM 
    item_mast
GROUP BY 
    PRO_COM;




SELECT COUNT(*) AS number_of_products
FROM item_mast
WHERE PRO_PRICE >= 350;


Sample table: orders

SELECT ord_date, salesman_id, COUNT(*) AS number_of_orders
FROM orders
GROUP BY ord_date, salesman_id
ORDER BY ord_date, salesman_id;
