<h1 align="center">
  <img alt="Auth-RMI" src="https://res.cloudinary.com/dpf7e7tpc/image/upload/v1603655086/projetos/auth-rmi_lfncqx.png" width="400" />
</h1>

<h1 align="center">
  RMI + Java
</h1>
<h3 align="center">Study work on RMI with Java in a simple application for the Development of Distributed Control Systems discipline.</h3>
<br/>
<p align="center">
  <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/mac-alves/auth-rmi">
  <img alt="GitHub top language" src="https://img.shields.io/github/languages/top/mac-alves/auth-rmi">
  <img alt="GitHub repo size" src="https://img.shields.io/github/repo-size/mac-alves/auth-rmi">
  <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/mac-alves/auth-rmi"> 
</p>

<p align="center">
  <a href="#rocket-technologies">Technologies</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#bangbang-dependencies">Dependencies</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#information_source-how-to-use">How To Use</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#bangbang-license">Attention</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#link-useful-links">Useful Links</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#memo-license">License</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#memo-license">Autor</a>
</p>

## :rocket: &nbsp;&nbsp;&nbsp; Technologies and Dependencies

This project was developed with the following technologies:
-  [Java v8](https://www.java.com/pt-BR/)
-  [PostgreSQL](https://www.postgresql.org/)
-  [JFrame](https://docs.oracle.com/javase/8/docs/api/javax/swing/JFrame.html)
-  [RMI](https://www.java.com/pt-BR/)
-  [Netbeans v12.1](https://netbeans.org/)

## :bangbang: &nbsp;&nbsp;&nbsp; Dependencies
-  [Java v8](https://www.java.com/pt-BR/)
-  [PostgreSQL](https://www.postgresql.org/)
-  [Netbeans v12.1](https://netbeans.org/)

## :information_source: &nbsp;&nbsp;&nbsp; How To Use

```bash
# Create a database and table with commands in PostgreSql

CREATE DATABASE rmi;

CREATE TABLE public.login (
	id serial NOT NULL,
	username varchar(200) NOT NULL,
	"password" varchar(255) NOT NULL,
	CONSTRAINT login_pkey PRIMARY KEY (id),
	CONSTRAINT login_username_key UNIQUE (username)
);

# Clone this repository
$ git clone https://github.com/mac-alves/auth-rmi

# Go into the repository
$ cd auth-rmi/

# Other steps
- 'open project in NetBeans'
- 'Clean and Build of project (Shift+F11)'

# in terminal execute
$ cd build/classes/

# generate stub.
$ rmic UserServer

# register object
$ rmiregistry &

# in NetBeans
- 'check if the PostgreSql drive is linked to the project in'
- 'properties (project properties) ->
	libraries ->
		Classpath ->
			add library -> 
				PostgreSql JDBC Driver'

# verify credintials of db
- 'src/Conection.java

	private String local = "localhost";
	private String user = "postgres";
	private String senha = "postgres";
	private final String porta = "5433";'

# run server
- 'UserServer -> Run File'

# run client
- 'Auth -> Run File'

```

## :bangbang: &nbsp;&nbsp;&nbsp; Attention
- For a project execution, the database must already be created together with a login table.

## :link: &nbsp;&nbsp;&nbsp; Useful Links
 - [Project presentation](https://youtu.be/zpJR2cxbt-o)

## :memo: &nbsp;&nbsp;&nbsp; License
This project is under the MIT license. See the [LICENSE](https://github.com/mac-alves/auth-rmi/blob/master/LICENSE) for more information.

---

## Autor

:anchor: **Mauricio Alves** - *Github* - [mac-alves](https://github.com/mac-alves)