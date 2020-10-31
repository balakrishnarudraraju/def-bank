DROP TABLE IF EXISTS accounts;
 
CREATE TABLE accounts (
  number INT AUTO_INCREMENT  PRIMARY KEY,
  status VARCHAR(1) NOT NULL,
  type VARCHAR(1) NOT NULL,
  balance NUMBER(10,2) NOT NULL,
  currency VARCHAR(3) NOT NULL,
  customer_id VARCHAR(10) NOT NULL
);
 
INSERT INTO accounts (status, type, balance, currency, customer_id) VALUES
  ('A', 'S', 123.00, 'INR', '1234'),
  ('A', 'S', 234.00, 'INR', '1234'),
  ('A', 'C', 1000.00, 'INR', '1234');
  
  
CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 4 INCREMENT BY 1;