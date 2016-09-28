commit;

--테이블 보기
select * from Admin1;
select * from Managers;
select * from Product;
select * from UserPayment;
select * from UserOrder;
select * from User1;
select * from NonUserPayment;
select * from NonUserOrder;
select * from NonUser;

--테이블삭제
drop table Admin1;
drop table Managers;
drop table Product;
drop table UserPayment;
drop table UserOrder;
drop table User1;
drop table NonUserPayment;
drop table NonUserOrder;
drop table NonUser;

--시퀀스 삭제
drop sequence Product_ProductNumber_seq;
drop sequence Managers_managerNumber_seq;
drop sequence User1_userNumber_seq;
drop sequence NonUser_NonUserNumber_seq;
drop sequence User1_orderNumber_seq;
drop sequence NonUser_orderNumber_seq;
drop sequence User1_paymentNumber_seq;
drop sequence NonUser_paymentNumber_seq;

--관리자 (1넣은이유는 admin이란게 시스템에있어서)
create table Admin1
(
  adminNumber int PRIMARY key,
  adminId varchar2(50) not null UNIQUE,
  adminPassword varchar2(20) not null
  
);
--매니저
create table Managers
(
  managerNumber int not null UNIQUE,
  managerId varchar2(50) PRIMARY key,
  managerPassword varchar2(20) not null,
  managerName varchar2(50) not null
);
--상품
create table Product
(
  productNumber int not null UNIQUE,
  productName varchar2(50) PRIMARY key,
  productCommant varchar2(500) not null,
  productPrice int not null,
  productOrigin varchar2(50) not null
);

insert into Product(productnumber, productName, productCommant, productPrice, productOrigin) values(1, '과자', '11', 11, '111'); 
select * from product;

--회원 (1넣은이유는 user이란게 시스템에있어서)
create table User1
(
  userNumber int not null UNIQUE,
   userId varchar2(50) PRIMARY key,
  userPassword varchar2(20) not null,
  userName varchar2(50) not null,
  userTel varchar2(50) not null,
  userAddress varchar2(50) not null,
  userClass int default 1 not null,
  coupon int default 0 not null,
  purchaseQuantity int default 0 not null
);

insert into User1(usernumber, userid, userpassword, username, usertel, useraddress) values(1, '1', '1', '111', '111111', '11-11'); 
insert into User1(usernumber, userid, userpassword, username, usertel, useraddress) values(2, '윤식', '윤식', '111', '111111', '11-11'); 
insert into User1(usernumber, userid, userpassword, username, usertel, useraddress) values(3, '333', '333', '111', '111111', '11-11'); 
select * from user1;


--회원 주문
create table UserOrder
(
  userOrderNumber int primary key,
  userId varchar2(50) references user1(userId),
  productName varchar2(50) references product(productName),
  orderAmount int not null,
  UserAddress varchar2(50)  not null,
  orderDate ,
  paymentflag VARCHAR2(5) default 'n'
);
insert into userorder values(1, '1', '과자', 11, '11-11', 'n'); 
select * from userorder;
drop table userorder;

select o.userOrderNumber, p.productName, o.orderAmount, p.productPrice
from product p, userOrder o, user1 u
where o.userId = 1 and o.productName = p.productName 
and o.paymentflag = 'n';


--회원 결제
create table UserPayment
(
  userPaymentNumber int,
  userOrderNumber int,
  paymentDate Date default sysdate,
  primary key(userPaymentNumber,userOrderNumber)
);
--비회원
create table NonUser
(
  nonUserNumber int not null UNIQUE,
  nonUserName varchar2(50) not null,
  nonUserTel varchar2(50) primary key,
  nonUserAddress varchar2(50)  not null
);
--비회원 주문
create table NonUserOrder
(
  nonUserOrderNumber int primary key,
  nonUserTel varchar2(50) references NonUser(nonUserTel),
  productName varchar2(50) references product(productName),
  orderAmount int not null,
  nonUserAddress varchar2(50)  not null,
  paymentflag VARCHAR2(5) default 'n'
);
--비회원 결제
create table NonUserPayment
(
  nonUserPaymentNumer int,
  nonUserOrderNumber int,
  paymentDate Date default sysdate,
  primary key(nonUserPaymentNumer, nonUserOrderNumber)
);

--Manager번호 시퀀스
create sequence Managers_managerNumber_seq nomaxvalue;

--상품번호 시퀀스
create sequence Product_ProductNumber_seq nomaxvalue;

--User번호 시퀀스
create sequence User1_userNumber_seq nomaxvalue;

--NonUser번호 시퀀스
create sequence NonUser_NonUserNumber_seq nomaxvalue;

-- 회원주문번호 시퀀스
create sequence User1_orderNumber_seq nomaxvalue;

-- 비회원주문번호 시퀀스
create sequence NonUser_orderNumber_seq nomaxvalue;

-- 회원결제번호 시퀀스
create sequence User1_paymentNumber_seq nomaxvalue;

-- 비회원결제번호 시퀀스
create sequence NonUser_paymentNumber_seq nomaxvalue;
