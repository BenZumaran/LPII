/*
	drop database biblioteca;
*/

drop database biblioteca;
create database biblioteca;
use biblioteca;


create table genero_libros(
cod_gen char(4) primary key,
desc_gen varchar(25) not null
);
----------------------------------------------------
create table tipo_doc(
cod_doc char(4) primary key,
desc_doc varchar(25) not null
);
----------------------------------------------------
create table libro(
cod_lib char(6) primary key not null,
desc_lib varchar(60) not null,
anio_lib int not null,
cod_gen char(4) not null,
autor_lib varchar(80)not null,
estado_lib varchar(10) not null ,
constraint fk_lib_gen foreign key (cod_gen) references genero_libros (cod_gen),
constraint chk_est_lib check (estado_lib in ("stock","prestado","solicitado","Baja"))
);
----------------------------------------------------
create table usuario(
cod_usu varchar(15) primary key not null,
nom_usu varchar(50)not null,
ape_pat_usu varchar(25) not null,
ape_mat_usu varchar(25) not null,
tipo_usu varchar(10) not null,
num_doc_usu varchar(15) not null unique,
img_usu varchar(100) null,
fecha_nac_usu date not null,
admin_usu boolean not null,
contra_usu varchar(45) not null,
constraint chk_tipo_usu check(tipo_usu in("trabajador","admin","cliente"))
);
---------------------------------------------------
create table solicitud_prestamo(
num_soli int primary key auto_increment,
cod_usu_solicitante varchar(15) not null,
cod_usu_aprobador varchar(15) null,
fec_creacion_soli date not null,
fec_aprobacion_soli date null,
fec_ini_pres date not null,
fec_dev_pres date not null,
estado_soli varchar(15) not null,
check(estado_soli in("pendiente","aceptada","denegada")),
constraint fk_codususoli foreign key (cod_usu_solicitante) references usuario (cod_usu),
constraint fk_codusuapro foreign key (cod_usu_aprobador) references usuario (cod_usu)
);
---------------------------------------------------
create table prestamo(
num_pres int primary key auto_increment,
num_soli int not null,
cod_usu varchar(15) not null,
deuda_pres double null,
est_pres varchar(15),
constraint fk_numSoli_pressoli foreign key (num_soli) references solicitud_prestamo(num_soli),
constraint fk_codUsu_presusu foreign key (cod_usu) references usuario(cod_usu),
constraint chk_estPres check (est_pres in ("aprobado","entregado","pendiente","deuda","devuelto"))
);
---------------------------------------------------
create table detalle_prestamo(
num_det_pres int primary key auto_increment,
num_soli int not null,
num_pres int null,
cod_lib char (6) not null
);
----------------------------------------------------
create table recibo(
num_reci int primary key auto_increment,
num_pres int not null,
importe_reci double not null,
cod_usu_cobranza varchar(15),
fec_reci date not null,
cod_doc char(4) not null,
num_doc_reci varchar(15) not null,
constraint fk_numPres_recpres foreign key (num_pres) references prestamo (num_pres),
constraint fk_codUsuCob_recusu foreign key (cod_usu_cobranza) references usuario (cod_usu),
constraint fk_codDoc_rectdoc foreign key (cod_doc) references tipo_doc (cod_doc)
);

----------------------------------------------------


insert into genero_libros values ("gl01","accion"),
	("gl02","comedia"),
	("gl04","romance"),
	("gl05","ciencia ficcion"),
	("gl06","suspenso"),
	("gl07","auto-ayuda");

insert into tipo_doc values ("dc01","DNI"),
	("dc02","Carnet Extranjería"),
	("dc03","Pasaporte"),
	("dc04","Cedula");

insert into libro values ("sa0234","Carrie",2010,"gl06","Stephen King","stock"),
	("op0348","Como mejorar tu Autoestima",2005,"gl07","Mario Cabanillas","stock"),
	("sa0456","Un amor de primavera",2013,"gl04","Rosario Balagar","stock"),
	("ep0984","El verano de Ricky",2002,"gl05","Miguel Unamuno","stock"),
	("cb0038","Un Frances en Francia",1980,"gl02","Christopher Casas","stock");

insert into usuario values ("benzum","Benjamin","Zumaran","Romero","admin","74084434","","1998/07/19",true,"usu123456"),
	("mariocaba02","Mario","Cabanillas","Juarez","trabajador","08976547","","1954/01/05",false,"usu123456"),
	("juanada1987","Juan","Adaliz","Diaz","cliente","83647513","","1987/04/04",false,"usu123456"),
	("marcielo01","Maricielo","Lucas","Terrones","cliente","89765432","","1997/07/07",false,"usu123456");

insert into solicitud_prestamo values(1,"juanada1987",null,"2022/11/30",null,"2022/12/03","2022/12/13","pendiente"),
	(null,"marcielo01", null,"2022/12/01",null,"2022/12/04","2022/12/18","pendiente"),
	(null,"juanada1987",null,"2022/10/27",null,"2022/10/29","2022/11/15","pendiente"),
	(null,"mariocaba02","mariocaba02","2022/09/06","2022/09/09","2022/09/15","2022/09/28","aceptada"),
	(null,"mariocaba02","mariocaba02","2022/11/10","2022/11/10","2022/11/12","2022/12/01","aceptada"),
	(null,"mariocaba02","mariocaba02","2022/11/25","2022/11/26","2022/11/26","2022/12/15","aceptada");

insert into prestamo values(1,4,"marcielo01",0,"devuelto")
	,(null,5,"juanada1987",15,"pendiente")
	,(null,6,"marcielo01",0,"entregado"); 

insert into detalle_prestamo values(1,1,null,"sa0456"),
	(null,2,null,"ep0984"),
	(null,3,null,"ep0984"),
	(null,4,null,"sa0456"),
	(null,4,null,"op0348"),
	(null,5,null,"cb0038"),
	(null,6,null,"sa0234");

insert into recibo values (1,1,25.0,"mariocaba02","2022/10/06", "dc01","32456712");

select * from recibo;
