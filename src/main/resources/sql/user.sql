create sequence hibernate_sequence start with 1 increment by 1
create table address (address_id bigint not null, address1 varchar(255), address2 varchar(255), city varchar(255), country varchar(255), first_name varchar(255), last_name varchar(255), state varchar(255), zip_code varchar(255), primary key (address_id))
create table user_details (user_id bigint not null, email varchar(255), first_name varchar(255), last_name varchar(255), password varchar(255), billing_address_address_id bigint, primary key (user_id))
create table user_details_shipping_address (user_user_id bigint not null, shipping_address_address_id bigint not null)
alter table user_details_shipping_address add constraint UK_f0x1bvm86jhb78mbcn8hgpm unique (shipping_address_address_id)
alter table user_details add constraint FK4t3ba30puowpytrdjtop84uuu foreign key (billing_address_address_id) references address
alter table user_details_shipping_address add constraint FKjbtapte6cntp97x7mlfino6ef foreign key (shipping_address_address_id) references address
alter table user_details_shipping_address add constraint FKrk562ngjywg7s6xsca8subqmi foreign key (user_user_id) references user_details
#insert
call next value for hibernate_sequence
call next value for hibernate_sequence
call next value for hibernate_sequence
insert into address (address1, address2, city, country, first_name, last_name, state, zip_code, address_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?)
insert into user_details (billing_address_address_id, email, first_name, last_name, password, user_id) values (?, ?, ?, ?, ?, ?)
insert into address (address1, address2, city, country, first_name, last_name, state, zip_code, address_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?)
insert into user_details_shipping_address (user_user_id, shipping_address_address_id) values (?, ?)
#select
select user.user_id , user.billing_address_address_id , user.email , user.first_name, user.last_name from user_details user
select address.address_id , address.address1, address.address2, address.city , address.country , address.first_name , address.last_name , address.state, address.zip_code from address address where address.address_id=?
select address.address_id , address.address1 , address.address2, address.city, address.country , address.first_name , address.last_name , address.state, address.zip_code from address address where address.address_id=?
select shippingaddress.user_user_id , shippingaddress.shipping_address_address_id , address.address_id , address.address1 , address.address2 , address.city , address.country , address.first_name , address.last_name , address.state, address.zip_code  from user_details_shipping_address shippingaddress inner join address address on shippingaddress.shipping_address_address_id=address.address_id where shippingaddress.user_user_id=?
select shippingaddress.user_user_id , shippingaddress.shipping_address_address_id , address.address_id , address.address1 , address.address2 , address.city , address.country , address.first_name , address.last_name , address.state, address.zip_code from user_details_shipping_address shippingaddress inner join address address on shippingaddress.shipping_address_address_id=address.address_id where shippingaddress.user_user_id=?

