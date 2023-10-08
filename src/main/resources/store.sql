CREATE TABLE Member
(mId           CHAR(8)          NOT NULL,
 pId           CHAR(10)         NOT NULL,
 name          VARCHAR(8)       NOT NULL,
 birthday      DATETIME,
 phone         VARCHAR(10),
 address       VARCHAR(40),
 email         VARCHAR(20),
 introducer    CHAR(8),
 PRIMARY  KEY (mId),
 UNIQUE   (pId),
 FOREIGN KEY (introducer) REFERENCES Member(mId));

CREATE TABLE Product
(pNo           CHAR(6)          NOT NULL,
 pName         VARCHAR(30),
 unitPrice     DECIMAL(10,2),
 catalog       VARCHAR(20),
 PRIMARY KEY (pNo ),
 CONSTRAINT UnitPrice_Check CHECK (unitPrice > 100));

CREATE TABLE Author
(pNo           CHAR(6)          NOT NULL,
 name          VARCHAR(8),
 PRIMARY KEY (pNo, name ),
 FOREIGN KEY (pNo) REFERENCES Product (pNo));

/* transTime原為TIMESTAMP，會遇到資料無法新增，先改成DATETIME最後再手動改回來。 */
CREATE TABLE "Transaction"
(tNo           CHAR(5)          NOT NULL,
 transMid      CHAR(8)          NOT NULL,
 transTime     DATETIME         NOT NULL,
 method        VARCHAR(5)       NOT NULL,
 bankId        VARCHAR(14)      NOT NULL,
 bankName      VARCHAR(20),
 cardType      VARCHAR(10),
 cardId        VARCHAR(10),
 dueDate       DATETIME,
 PRIMARY KEY (tNo),
 FOREIGN KEY (transMid) REFERENCES Member(mId));

/* cartTime原為TIMESTAMP，會遇到資料無法新增，先改成DATETIME最後再手動改回來。 */
CREATE TABLE Cart
(mId           CHAR(8)          NOT NULL,
 cartTime      DATETIME         NOT NULL,
 tNo           CHAR(5)          NOT NULL,
 PRIMARY KEY (mId, cartTime),
 FOREIGN KEY (tNo) REFERENCES "Transaction"(tNo)
     ON UPDATE CASCADE,
 FOREIGN KEY (mId) REFERENCES Member(mId)
     ON DELETE CASCADE  ON UPDATE CASCADE);

/* browseTime原為TIMESTAMP，會遇到資料無法新增，先改成DATETIME最後再手動改回來。 */
CREATE TABLE "Browse"
(mId           CHAR(8)          NOT NULL DEFAULT  'a0910001',
 pNo           CHAR(6)          NOT NULL,
 browseTime    DATETIME,
 PRIMARY KEY (mId, pNo, browseTime),
 FOREIGN KEY (mId) REFERENCES Member(mId)  ON UPDATE CASCADE,
 FOREIGN KEY (pNo) REFERENCES Product (pNo));

/* cartTime原為TIMESTAMP，會遇到資料無法新增，先改成DATETIME最後再手動改回來。 */
CREATE TABLE "Order"
(pNo           CHAR(6)          NOT NULL,
 mId           CHAR(8)          NOT NULL,
 cartTime      DATETIME         NOT NULL,
 amount        INT                       DEFAULT  0,
 PRIMARY KEY (pNo ,mId, cartTime ),
 FOREIGN KEY (pNo) REFERENCES Product (pNo),
 FOREIGN KEY (mId, cartTime) REFERENCES Cart (mId, cartTime));

CREATE TABLE Record
(tNo           CHAR(5)          NOT NULL,
 pNo           CHAR(6)          NOT NULL,
 salePrice     DECIMAL(10,2),
 amount        INT,
 PRIMARY KEY (tNo,pNo),
 FOREIGN KEY (tNo) REFERENCES "Transaction" (tNo),
 FOREIGN KEY (pNo) REFERENCES Product (pNo));


Insert into MEMBER
(MID, PID, NAME, BIRTHDAY, PHONE, ADDRESS, EMAIL)
Values
    ('b0922468', 'R100200300', 'Jackson', '1980-03-30', '06-3210321', '台南縣中華路號', 'jack99@ms9.hinet.net');
Insert into MEMBER
(MID, PID, NAME, BIRTHDAY, PHONE, ADDRESS, EMAIL)
Values
    ('b0905555', 'C200456789', 'Jennifer', '1974-03-04', '07-2221111', '高雄市五福三路號', 'jen33@ms3.hinet.net');
Insert into MEMBER
(MID, PID, NAME, BIRTHDAY, PHONE, ADDRESS, EMAIL, INTRODUCER)
Values
    ('a0910001', 'A220123456', 'Jenny', '1979-01-01', '02-2222001', '台北市中山北路號', 'jenny@ms1.hinet.net', 'b0905555');
Insert into MEMBER
(MID, PID, NAME, BIRTHDAY, PHONE, ADDRESS, EMAIL, INTRODUCER)
Values
    ('c0927777', 'B123123123', 'Su', '1982-06-06', '07-2345678', '高雄市蓮海路號', 'su88@ms2.hinet.net', 'b0905555');
Insert into MEMBER
(MID, PID, NAME, BIRTHDAY, PHONE, ADDRESS, EMAIL, INTRODUCER)
Values
    ('a0911234', 'A12255888', 'Tony', '1980-12-12', '02-2288009', '台北市羅斯福路號', 'tony@ms1.hinet.net', 'a0910001');
Insert into MEMBER
(MID, PID, NAME, BIRTHDAY, PHONE, ADDRESS, EMAIL, INTRODUCER)
Values
    ('a0921111', 'A100999777', 'David', '1975-11-22', '04-2468888', '台中市中港路號', 'david@ms1.hinet.net', 'a0911234');
GO

Insert into PRODUCT
   (PNO, PNAME, UNITPRICE, CATALOG)
 Values
   ('b30999', '資料庫理論與實務', 500, 'Book');
Insert into PRODUCT
(PNO, PNAME, UNITPRICE, CATALOG)
Values
    ('d11222', '任賢齊專輯三', 300, 'CD');
Insert into PRODUCT
(PNO, PNAME, UNITPRICE, CATALOG)
Values
    ('b20666', 'OLAP進階', 500, 'Book');
Insert into PRODUCT
(PNO, PNAME, UNITPRICE, CATALOG)
Values
    ('b10234', '管理資訊系統概論', 600, 'Book');
Insert into PRODUCT
(PNO, PNAME, UNITPRICE, CATALOG)
Values
    ('b40555', '系統分析理論與實務', 550, 'Book');
Insert into PRODUCT
(PNO, PNAME, UNITPRICE, CATALOG)
Values
    ('d20777', '蔡依林專輯二', 350, 'CD');
Insert into PRODUCT
(PNO, PNAME, UNITPRICE, CATALOG)
Values
    ('v01888', '哈利波特-混血王子的背叛', 450, 'DVD');
Insert into PRODUCT
(PNO, PNAME, UNITPRICE, CATALOG)
Values
    ('d03333', '5566專輯', 450, 'CD');
Insert into PRODUCT
(PNO, PNAME, UNITPRICE, CATALOG)
Values
    ('b51111', '電子商務理論與實務', 700, 'Book');
Insert into PRODUCT
(PNO, PNAME, UNITPRICE, CATALOG)
Values
    ('v00111', '英雄', 400, 'DVD');
GO

Insert into AUTHOR
   (PNO, NAME)
 Values
   ('b30999', 'Huang');
Insert into AUTHOR
(PNO, NAME)
Values
    ('b10234', 'Lin');
Insert into AUTHOR
(PNO, NAME)
Values
    ('d11222', 'William');
Insert into AUTHOR
(PNO, NAME)
Values
    ('b20666', 'Sandra');
Insert into AUTHOR
(PNO, NAME)
Values
    ('b40555', 'Wu');
Insert into AUTHOR
(PNO, NAME)
Values
    ('d20777', 'Jolin');
Insert into AUTHOR
(PNO, NAME)
Values
    ('v01888', 'J.K.');
Insert into AUTHOR
(PNO, NAME)
Values
    ('b51111', 'Lai');
Insert into AUTHOR
(PNO, NAME)
Values
    ('b51111', 'Huang');
Insert into AUTHOR
(PNO, NAME)
Values
    ('b51111', 'Lin');
Insert into AUTHOR
(PNO, NAME)
Values
    ('d03333', 'Jackey');
Insert into AUTHOR
(PNO, NAME)
Values
    ('d03333', 'David');
Insert into AUTHOR
(PNO, NAME)
Values
    ('d03333', 'Tom');
GO

Insert into "TRANSACTION"
   (TNO, TRANSMID, TRANSTIME, METHOD, BANKID, BANKNAME, CARDTYPE, CARDID, DUEDATE)
 Values
   ('92222', 'a0911234', '2003/1/1 11:30:00', 'cart', '010', 'tb', 'visa', '987654321', '2005-01-01');
Insert into "TRANSACTION"
(TNO, TRANSMID, TRANSTIME, METHOD, BANKID, BANKNAME, CARDTYPE, CARDID, DUEDATE)
Values
    ('92555', 'b0922468', '2003/11/11 09:10:00', 'cart', '010', 'tb', 'visa', '333300000', '2004-01-01');
Insert into "TRANSACTION"
(TNO, TRANSMID, TRANSTIME, METHOD, BANKID, BANKNAME, CARDTYPE, CARDID, DUEDATE)
Values
    ('90111', 'b0905555', '2002/5/5 12:30:30', 'cart', '020', 'fb', 'master', '444455555', '2003-01-01');
Insert into "TRANSACTION"
(TNO, TRANSMID, TRANSTIME, METHOD, BANKID, BANKNAME, CARDTYPE, CARDID, DUEDATE)
Values
    ('92333', 'c0927777', '2003/10/15 09:00:00', 'email', '070', 'sb', 'visa', '111122222', '2004-12-31');
Insert into "TRANSACTION"
(TNO, TRANSMID, TRANSTIME, METHOD, BANKID, BANKNAME, CARDTYPE, CARDID, DUEDATE)
Values
    ('91888', 'a0910001', '2002/9/10 10:10:00', 'fax', '040', 'cb', 'master', '777788888', '2004-10-10');
Insert into "TRANSACTION"
(TNO, TRANSMID, TRANSTIME, METHOD, BANKID, BANKNAME, CARDTYPE, CARDID, DUEDATE)
Values
    ('92666', 'c0927777', '2003/10/10 22:10:30', 'cart', '020', 'fb', 'visa', '123456789', '2003-12-31');
Insert into "TRANSACTION"
(TNO, TRANSMID, TRANSTIME, METHOD, BANKID, BANKNAME, CARDTYPE, CARDID, DUEDATE)
Values
    ('91100', 'a0911234', '2004/7/27 18:30:00', 'cart', '010', 'tb', 'visa', '987654321', '2005-01-01');
GO

Insert into CART
   (MID, CARTTIME, TNO)
 Values
   ('a0911234', '2003/1/1 10:00:00', '92222');
Insert into CART
(MID, CARTTIME, TNO)
Values
    ('a0910001', '2002/9/9 10:00:10', '91888');
Insert into CART
(MID, CARTTIME, TNO)
Values
    ('b0922468', '2003/11/11 09:00:30', '92555');
Insert into CART
(MID, CARTTIME, TNO)
Values
    ('a0911234', '2002/2/2 18:00:30', '91100');
Insert into CART
(MID, CARTTIME, TNO)
Values
    ('b0905555', '2002/5/5 12:00:00', '90111');
Insert into CART
(MID, CARTTIME, TNO)
Values
    ('c0927777', '2003/10/10 22:00:00', '92666');
GO

Insert into "BROWSE"
   (MID, PNO, BROWSETIME)
 Values
   ('a0910001', 'b40555', '2002/9/9 10:00:00');
Insert into "BROWSE"
(MID, PNO, BROWSETIME)
Values
    ('b0922468', 'b40555', '2003/11/10 12:00:30');
Insert into "BROWSE"
(MID, PNO, BROWSETIME)
Values
    ('b0922468', 'b10234', '2003/11/1 22:00:00');
Insert into "BROWSE"
(MID, PNO, BROWSETIME)
Values
    ('c0927777', 'v00111', '2003/10/10 21:50:00');
Insert into "BROWSE"
(MID, PNO, BROWSETIME)
Values
    ('c0927777', 'd20777', '2003/10/10 21:40:00');
Insert into "BROWSE"
(MID, PNO, BROWSETIME)
Values
    ('c0927777', 'd11222', '2003/10/10 21:30:30');
Insert into "BROWSE"
(MID, PNO, BROWSETIME)
Values
    ('b0905555', 'v01888', '2002/5/5 11:40:30');
Insert into "BROWSE"
(MID, PNO, BROWSETIME)
Values
    ('a0911234', 'b20666', '2002/2/2 17:50:00');
Insert into "BROWSE"
(MID, PNO, BROWSETIME)
Values
    ('a0911234', 'b30999', '2002/2/2 17:30:00');
GO

Insert into "order"
   (PNO, MID, CARTTIME, AMOUNT)
 Values
   ('d11222', 'a0911234', '2003/1/1 10:00:00', 1);
Insert into "order"
(PNO, MID, CARTTIME, AMOUNT)
Values
    ('b40555', 'b0922468', '2003/11/11 09:00:30', 10);
Insert into "order"
(PNO, MID, CARTTIME, AMOUNT)
Values
    ('b10234', 'b0922468', '2003/11/11 09:00:30', 5);
Insert into "order"
(PNO, MID, CARTTIME, AMOUNT)
Values
    ('v00111', 'c0927777', '2003/10/10 22:00:00', 2);
Insert into "order"
(PNO, MID, CARTTIME, AMOUNT)
Values
    ('d20777', 'c0927777', '2003/10/10 22:00:00', 1);
Insert into "order"
(PNO, MID, CARTTIME, AMOUNT)
Values
    ('d11222', 'c0927777', '2003/10/10 22:00:00', 1);
Insert into "order"
(PNO, MID, CARTTIME, AMOUNT)
Values
    ('v01888', 'b0905555', '2002/5/5 12:00:00', 3);
Insert into "order"
(PNO, MID, CARTTIME, AMOUNT)
Values
    ('b30999', 'a0911234', '2002/2/2 18:00:30', 1);
GO

Insert into RECORD
   (TNO, PNO, SALEPRICE, AMOUNT)
 Values
   ('91100', 'b30999', 450, 1);
Insert into RECORD
(TNO, PNO, SALEPRICE, AMOUNT)
Values
    ('90111', 'v01888', 1350, 3);
Insert into RECORD
(TNO, PNO, SALEPRICE, AMOUNT)
Values
    ('92555', 'b10234', 3000, 5);
Insert into RECORD
(TNO, PNO, SALEPRICE, AMOUNT)
Values
    ('92555', 'b40555', 5000, 10);
Insert into RECORD
(TNO, PNO, SALEPRICE, AMOUNT)
Values
    ('91888', 'b40555', 1650, 3);
Insert into RECORD
(TNO, PNO, SALEPRICE, AMOUNT)
Values
    ('91888', 'd03333', 850, 2);
Insert into RECORD
(TNO, PNO, SALEPRICE, AMOUNT)
Values
    ('92666', 'd11222', 300, 1);
Insert into RECORD
(TNO, PNO, SALEPRICE, AMOUNT)
Values
    ('92666', 'd20777', 350, 1);
Insert into RECORD
(TNO, PNO, SALEPRICE, AMOUNT)
Values
    ('92666', 'v00111', 800, 2);
Insert into RECORD
(TNO, PNO, SALEPRICE, AMOUNT)
Values
    ('92333', 'b51111', 700, 1);