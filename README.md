```bash

CREATE DATABASE rmi;

CREATE TABLE public.login (
	id serial NOT NULL,
	username varchar(200) NOT NULL,
	"password" varchar(255) NOT NULL,
	CONSTRAINT login_pkey PRIMARY KEY (id),
	CONSTRAINT login_username_key UNIQUE (username)
);

rmic UserServer
rmiregistry &

```