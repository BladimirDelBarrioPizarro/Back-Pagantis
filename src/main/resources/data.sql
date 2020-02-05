drop table users if exists;
drop table wallets if exists;

CREATE TABLE public.users(
    id integer not null,
    name character varying(100) NOT NULL,
    department character varying(100) NOT NULL
);

INSERT INTO users (id,name,department) VALUES (1,'Bladi','IT');
INSERT INTO users (id,name,department) VALUES (2,'Roberto','Health');
INSERT INTO users (id,name,department) VALUES (3,'Maria del Pilar','Restaurant');
INSERT INTO users (id,name,department) VALUES (4,'Angela','Legal');

CREATE TABLE public.wallets(
    id integer not null,
    pagacoint integer not null,
    user_id integer not null
);

INSERT INTO wallets (id,pagacoint,user_id) VALUES (1,1000,1);
INSERT INTO wallets (id,pagacoint,user_id) VALUES (2,1000,2);
INSERT INTO wallets (id,pagacoint,user_id) VALUES (3,1000,2);
INSERT INTO wallets (id,pagacoint,user_id) VALUES (4,1000,2);
INSERT INTO wallets (id,pagacoint,user_id) VALUES (5,1000,3);
INSERT INTO wallets (id,pagacoint,user_id) VALUES (6,1000,3);
INSERT INTO wallets (id,pagacoint,user_id) VALUES (7,1000,3);
INSERT INTO wallets (id,pagacoint,user_id) VALUES (8,1000,4);