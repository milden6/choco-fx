create table if not exists dbt_request
(
	id serial not null
		constraint dbt_request_pkey
			primary key,
	prod_type varchar(40),
	amount integer,
	datetime timestamp,
	choco_user varchar(10)
);

alter table dbt_request owner to postgres;

create table if not exists dbt_product_proc
(
	id serial not null
		constraint dbt_product_proc_pkey
			primary key,
	datetime timestamp,
	party varchar(40),
	temperature integer,
	speed double precision,
	portion_size double precision,
	volume double precision,
	grinding_type varchar(20),
	grinding_size double precision,
	pack_type varchar(20),
	party_output varchar(20),
	whiping_time double precision,
	whiping_intensity double precision,
	cream_amount double precision,
	taste varchar(20),
	consistency varchar(20),
	amount_per double precision,
	respons_user varchar(10)
);

alter table dbt_product_proc owner to postgres;

create table if not exists dbt_product_stat
(
	id integer not null
		constraint dbt_product_stat_pkey
			primary key
		constraint fk_product_proc
			references dbt_product_proc,
	status varchar(5),
	status_txt varchar(20)
);

alter table dbt_product_stat owner to postgres;

create table if not exists dbt_users
(
	choco_user varchar(10) not null
		constraint dbt_users_pkey
			primary key,
	full_name varchar(40),
	reg_datetime timestamp,
	auth varchar(5),
	password varchar(40)
);

alter table dbt_users owner to postgres;

create table if not exists dbt_auth
(
	auth varchar(5) not null
		constraint dbt_auth_pkey
			primary key,
	description varchar(40)
);

alter table dbt_auth owner to postgres;

