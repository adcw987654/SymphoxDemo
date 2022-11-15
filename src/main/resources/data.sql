create table transaction (
	transaction_id varchar(30),
point_amount int,
business_time timestamp,
process_cost int,
created_by varchar(10),
created_time timestamp,
primary key(transaction_id)
);