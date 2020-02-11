drop table wallet_user if exists;
drop table users if exists;
drop table wallets if exists;




CREATE TABLE public.users(
    id SERIAL primary key NOT NULL,
    name character varying(100) NOT NULL,
    department character varying(100) NOT NULL
);

INSERT INTO users (id,name,department) VALUES (1,'Bladi','IT');
INSERT INTO users (id,name,department) VALUES (2,'Roberto','Health');
INSERT INTO users (id,name,department) VALUES (3,'Maria del Pilar','Restaurant');
INSERT INTO users (id,name,department) VALUES (4,'Angela','Legal');

CREATE TABLE public.wallets(
    id SERIAL primary key NOT NULL,
    pagacoint integer not null,
    bank character varying(100) NOT NULL
);

INSERT INTO wallets (id,pagacoint,bank) VALUES (1,1000,'Santander');
INSERT INTO wallets (id,pagacoint,bank) VALUES (2,1000,'Sabadell');
INSERT INTO wallets (id,pagacoint,bank) VALUES (3,1000,'Barclays');
INSERT INTO wallets (id,pagacoint,bank) VALUES (4,1000,'Bankia');
INSERT INTO wallets (id,pagacoint,bank) VALUES (5,1000,'La Caixa');
INSERT INTO wallets (id,pagacoint,bank) VALUES (6,1000,'BBVA');
INSERT INTO wallets (id,pagacoint,bank) VALUES (7,1000,'Citigroup');
INSERT INTO wallets (id,pagacoint,bank) VALUES (8,1000,'ING');

CREATE TABLE public.wallet_user(
    user_id integer NOT NULL,
    wallet_id integer NOT NULL
);

INSERT INTO wallet_user (user_id,wallet_id) VALUES (1,1);
INSERT INTO wallet_user (user_id,wallet_id) VALUES (2,2);
INSERT INTO wallet_user (user_id,wallet_id) VALUES (2,3);
INSERT INTO wallet_user (user_id,wallet_id) VALUES (2,4);
INSERT INTO wallet_user (user_id,wallet_id) VALUES (3,5);
INSERT INTO wallet_user (user_id,wallet_id) VALUES (3,6);
INSERT INTO wallet_user (user_id,wallet_id) VALUES (3,7);
INSERT INTO wallet_user (user_id,wallet_id) VALUES (4,8);
