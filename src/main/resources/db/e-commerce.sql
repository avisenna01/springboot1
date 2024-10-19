create table categories (
	categories_id serial primary key,
	category_description varchar(30)
);

create table products (
	product_id serial primary key,
	product_description varchar(30),
	categories_id int,
	price int not null,
	foreign key (categories_id) references categories(categories_id)
);

create table customers (
	customer_id serial primary key,
	email varchar(15) not null,
	phone varchar(15),
	address text,
	gender varchar(5),
	birth_date date
);

create table orders (
	order_id serial primary key,
	order_date date,
	customer_id int,
	foreign key (customer_id) references customers(customer_id)
);

create table order_items (
	order_item_id serial primary key,
	order_id int not null,
	product_id int not null,
	foreign key (order_id) references orders(order_id),
	foreign key (product_id) references products(product_id)
);

create table product_reviews (
	product_reviews_id serial primary key,
	review text,
	product_id int not null,
	customer_id int not null,
	foreign key (product_id) references products(product_id),
	foreign key (customer_id) references customers(customer_id)
);


create table payment_details (
	payment_id serial primary key,
	payment_type varchar(20),
	order_id int not null,
	foreign key (order_id) references orders(order_id)
);

insert into categories (category_description) values
('Men'),
('Women'),
('Reused');

select * from categories;

insert into products (product_description, categories_id, price) values
('Men shirt',1,10000),
('Women blouse',2,20000),
('biodegredable straw',3,30000);

select * from products;

alter table customers add column first_name varchar(15);
alter table customers add column last_name varchar(15);

insert into customers (email, phone, address, gender, birth_date, first_name, last_name) values
('abi@gmail.com','08123456789','Jakarta','Male','2000-11-11','Abi','Yudhistira'),
('dean@gmail.com','08987654321','Sidoarjo','Male','1999-10-10','Dean','Altar'),
('rendy@gmail.com','08123212321','Palembang','Male','2000-10-10','Rendy','Anwar'),
('juke@gmail.com','08989888889','China','Male','2000-10-10','Juan','Kevin'),
('udin@gmail.com','08124214412','India','Male','1999-09-09','Udin','Al-ghifari');

select * from customers;

insert into orders (order_date,customer_id) values
('2024-10-10',1),
('2023-10-10',2),
('2024-09-09',1),
('2023-11-11',5);

select * from orders;

insert into order_items (order_id,product_id) values
(1,1),
(2,1),
(3,3);

select * from order_items;

insert into product_reviews (review,product_id,customer_id) values
('product ini biasa aja',1,1),
('product ini bagus',2,2),
('product ini sangat bagus sekali',3,2);

select * from product_reviews;

insert into payment_details (payment_type,order_id) values
('cash',1),
('debit',2),
('credit',3);

select * from payment_details;

-- JOIN QUERIES
-- join products with categories to get product details with category names
select * 
from products 
inner join categories on products.product_id = categories.categories_id;

-- join orders with customers to get order details with customer information
select *
from customers c
inner join orders o on c.customer_id = o.customer_id;

-- join order_items with products to get order item details with product information
select *
from products p
inner join order_items oi on p.product_id = oi.product_id;

-- join orders, order_items, and products to get detailed order information
select *
from orders o
inner join order_items oi on o.order_id = oi.order_id
inner join products p on oi.product_id = p.product_id;

-- join product_reviews, products, and customers to get review details with product and customer information
select *
from product_reviews pr
inner join products p on pr.product_id = p.product_id
inner join customers c on c.customer_id = pr.customer_id;

-- combine product information with categories name
create view product_details as 
select p.*,category_description
from categories c
inner join products p on c.categories_id = p.categories_id;

-- drop view product_details;

select * from product_details;

-- summarizes orders placed by customers
create view customer_orders as
select c.*,order_date,oi.order_id,oi.order_item_id,p.*
from customers c
inner join orders o on c.customer_id = o.customer_id
inner join order_items oi on o.order_id = oi.order_id
inner join products p on oi.product_id = p.product_id;

-- drop view customer_orders;

select * from customer_orders;

-- provides detailed information about order items
create view order_items_details as
select o.*,oi.order_item_id,oi.product_id
from orders o
inner join order_items oi on o.order_id = oi.order_id

select * from order_items_details;

-- combines product reviews with product and customer details
create view product_reviews_details as
select product_description, c.first_name, c.last_name, pr.review
from products p
inner join product_reviews pr on p.product_id = pr.product_id
inner join customers c on pr.customer_id = c.customer_id;

-- drop view product_reviews_details;

select * from product_reviews_details;

-------------------------------------------------------

alter table products add column product_name varchar(20);
select * from products;

update products set product_name = 'Uniqlo Office Shirt' where product_id = 1;
update products set product_name = 'Zara Blouse' where product_id = 2;
update products set product_name = 'Eco Straw' where product_id = 3;

select * from products;

-------------------------------------------------------

-- implement subqueries to retrieve specific data, such as the highest-rated products
-- 1. I want to add rating column in the product review section
-- 2. to get the highest rated product, I will only get the highest scored product (5 stars from 1-5 scale)

-- checking the customer table
select * from customers;
-- checking the product_reviews and product table
select * from product_reviews;
select * from products;
-- add rating column
alter table product_reviews add column rating int;
-- update the current data in the table
update product_reviews set rating = 3 where product_reviews_id = 1;
update product_reviews set rating = 4 where product_reviews_id = 2;
update product_reviews set rating = 5 where product_reviews_id = 3;
-- insert another product in the product table
insert into products (product_description, categories_id, price, product_name) values
('Men polo',1,40000,'Uniqlo Polo'),
('Women dress',2,50000,'Dior Dress'),
('Shorts',1,60000,'Uniqlo Shorts'),
('Skirt',2,70000,'Zara Skirts');
-- insert another value in the product_reviews table
insert into product_reviews (review,product_id,customer_id,rating) values
('baju polo ini sangat nyaman digunakan',4,1,5),
('Saya membeli celana pendek ini, namun sayang sekali ada robeknya',6,2,2),
('dress ini cocok untuk digunakan ketika berpesta',5,4,4),
('Sebagai pemilik kafe, sedotan ini menjadi stok wajib saya.
 selain karena bahannya yang ramah lingkungan, juga karena nyaman digunakan',3,2,5);
 
-- implement subqueries to retrieve specific data, such as the highest-rated products
select product_name, product_description, price, avg_rating
from (
	select product_id, avg(rating) as avg_rating
	from product_reviews
	group by product_id
) as t
inner join products p on t.product_id = p.product_id
order by avg_rating desc

---------

-- select * from product_reviews_details

-- alter table products add column image_path TEXT

-- alter table customers add column pass varchar(30)

select * from products
select * from customers

update customers set pass = '123' where customer_id = 1;
update customers set pass = '123' where customer_id = 3;
update customers set pass = '123' where customer_id = 4;
update customers set pass = '123' where customer_id = 5;
update customers set pass = '123' where customer_id = 6;


-- update products set image_path = '/images/men_shirt.jpeg' where product_id = 1
-- update products set image_path = '/images/bio_straw.jpeg' where product_id = 3
-- update products set image_path = '/images/men_polo.jpeg' where product_id = 4
-- update products set image_path = '/images/women_dress.jpeg' where product_id = 5
-- update products set image_path = '/images/shorts.jpeg' where product_id = 6;
-- update products set image_path = '/images/skirt.jpeg' where product_id = 7;
-- update products set product_name = 'Mayoral boy shirt' where product_id = 8;
-- update products set product_description = 'Boy shirt' where product_id = 8;
-- update products set image_path = '/images/boy_shirt.jpeg' where product_id = 8;