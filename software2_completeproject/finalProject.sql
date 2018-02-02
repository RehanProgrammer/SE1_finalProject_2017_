use finalprojectdatabase;
DROP Table if exists inventory;
CREATE TABLE  inventory(
ItemId int primary key not null AUTO_INCREMENT,
itemName varchar(25),
price double,
quantity int,
description varchar(30),
discounts double
);
INSERT INTO inventory (itemName, price, quantity,description,discounts)VALUES
 ("Banana", 0.48, 4,"yellow fruit",0.0),
 ("Apple", 1.47, 35,"round fruit", 0.0),
 ("Pineapple", 0.75, 10, "spongebob", 0.0),
 ("XBOX", 299, 5,"electronics", 0.10),
 ("SONY Playstation", 299, 400,"electronics",0.10 ),
 ("Iphone", 1000, 6, "elctronics",0.25),
 ("Soccer shorts", 7.00, 5, "clothes",0.05),
 ("JEANS", 15.75, 4,"clothes",0.0),
 ("Cap", 5.00,5,"clothes",0.03);
 DROP Table if exists Transactions;
 CREATE TABLE Transactions (
 id int primary key not null AUTO_INCREMENT ,
 TransactionID int  ,
 totalPrice double,
 DOP varchar(15)  
 );
 DROP Table if exists orders;
  CREATE TABLE orders(
  orderId int primary key not null AUTO_INCREMENT,
  transactionID int references Transactions (TransactionID),
  itemId int
  );
  DROP Table if exists inventoryMessege;
  CREATE TABLE inventoryMessege(
  DateID int primary key not null AUTO_INCREMENT,
  DOP date,
  report varchar(50)
  );
  
  drop table if exists Cart;
  CREATE TABLE Cart(
  soID int primary key not null AUTO_INCREMENT,
  itemId int,
  itemName varchar(25),
  itemPrice double
  );
  
  