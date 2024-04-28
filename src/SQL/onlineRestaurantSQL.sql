/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Hanas
 * Created: 08-Mar-2022
 */
CREATE TABLE CustomerSighup (
        First_Name VARCHAR(45) NOT NULL ,
	Last_Name VARCHAR(45) NOT NULL ,
	Email VARCHAR(45) NOT NULL ,
	city VARCHAR(45) NOT NULL ,
	Neighborhood VARCHAR(45) NOT NULL ,
	username VARCHAR(45) not NULL ,
	password VARCHAR(45) not NULL ,
	PRIMARY KEY (username ) 
);
CREATE TABLE Admin (
	AdminUsername VARCHAR(45) not NULL ,
	AdminPassword VARCHAR(45) not NULL ,
	PRIMARY KEY (AdminUsername ) 
);
CREATE TABLE ITEMS(
        ItemID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
        NAME VARCHAR(20) NOT NULL,
        CATEGORY VARCHAR(20) NOT NULL,
        SPECIFICATIONS VARCHAR(20) NOT NULL,
        PRICE DOUBLE NOT NULL ,
        ADDEDBY  VARCHAR(45) NOT NULL ,
        PRIMARY KEY (ItemID), 
        FOREIGN KEY (ADDEDBY) REFERENCES ADMIN(AdminUsername)
);

Create Table Orders(
        ORDERID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
        CustomerUserName VARCHAR(45) not NULL ,
        TotalPrice Double,
        Orderdate Date,
        PRIMARY KEY (ORDERID), 
        FOREIGN KEY (CustomerUserName) REFERENCES CustomerSighup(username)

);

Create Table OrderItem(
        Order_ID INT NOT NULL,
        Item_ID INT NOT NULL,
        Quantity INT NOT NULL,
        FOREIGN KEY (Order_ID) REFERENCES Orders (ORDERID), 
        FOREIGN KEY (Item_ID) REFERENCES ITEMS (ItemID)
);

CREATE TABLE Payment (
        PaymentMethod VARCHAR (40) NOT NULL ,
        Card_Number VARCHAR (40) ,
        Name_On_Card VARCHAR (40),
        ccv INT ,
        Total_Price DOUBLE NOT NULL ,
        Payment_Date VARCHAR (40) NOT NULL ,
        Order_ID INT NOT NULL ,
        Payment_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
        FOREIGN KEY (Order_ID) REFERENCES Orders (ORDERID), 
        PRIMARY KEY (Payment_ID)
);
CREATE TABLE BILL(
        BillID INT NOT NULL GENERATED ALWAYS AS IDENTITY ,
        PaymentID INT NOT NULL ,
        Location VARCHAR(45) NOT NULL ,
        Bill_Date Date,
        PaidPrice Double,
        FOREIGN KEY (PaymentID) REFERENCES Payment (Payment_ID), 
        PRIMARY KEY (BillID)
);