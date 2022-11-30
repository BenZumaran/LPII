create database biblioteca;
use biblioteca;

create table genero_libros(
cod_gen char(4) primary key,
desc_gen varchar(15) not null
);
----------------------------------------------------
create table tipo_doc(
cod_doc char(4) primary key,
desc_doc varchar(15) not null
);
----------------------------------------------------
create table libro(
cod_lib char(6) primary key not null,
desc_lib varchar(60) not null,
anio_lib int not null,
cod_gen char(4) not null references genero_libros,
autor_lib varchar(80)not null,
estado_lib varchar(10) not null ,
check (estado_lib in ("stock","prestado","solicitado","Baja"))
);
----------------------------------------------------
create table usuario(
cod_usu char(6) primary key not null,
nom_usu varchar(50)not null,
ape_pat_usu varchar(30) not null,
ape_mat_usu varchar(30) not null,
edad int not null,
tipo_usu varchar(10) not null,
num_doc_usu varchar(15) not null,
fecha_nac_usu date not null,
admin_usu boolean not null,
contra_usu varchar(45) not null,
check(tipo_usu in("trabajador","admin","cliente"))
);
----------------------------------------------------
create table recibo(
num_reci int primary key auto_increment,
num_pres int references prestamo,
importe_reci double not null,
cod_usu_cobranza char(6) not null references usuario (cod_usu),
fec_reci date not null,
cod_doc char(4) not null references tipo_doc,
num_doc_reci varchar(15) not null
);
---------------------------------------------------
---------------------------------------------------
create table prestamo(
num_pres int primary key auto_increment,
cod_usu char(6) not null,
num_det_pres int not null,
fec_ini_pres date not null,
fec_dev_pres date not null,
deuda_pres double null,
num_soli int not null,
foreign key (cod_usu) references usuario (cod_usu)
);
---------------------------------------------------
create table detalle_soli_pres(
num_det_soli int primary key auto_increment,
num_soli int not null,
cod_lib char(6) not null,
foreign key (cod_lib) references libro (cod_lib)
);
---------------------------------------------------
create table detalle_prestamo(
num_det_pres int primary key auto_increment,
num_pres int not null,
cod_lib char (6) not null,
foreign key (cod_lib) references libro (cod_lib)
);
----------------------------------------------------
create table solicitud_prestamo(
num_soli int primary key auto_increment,
cod_usu_solicitante char(6) not null,
cod_usu_aprobador char(6) not null,
num_det_soli int not null,
fec_creacion_soli date not null,
fec_aprobacion_soli date null,
estado_soli varchar(15) not null,
check(estado_soli in("pendiente","aceptada","denegada")),
foreign key (cod_usu_solicitante) references usuario (cod_usu),
foreign key (cod_usu_aprobador) references usuario (cod_usu)
);
----------------------------------------------------
----------------------------------------------------
alter table prestamo add foreign key (num_soli) references solicitud_prestamo (num_soli);
alter table prestamo add foreign key (num_det_pres) references detalle_prestamo (num_det_pres);
alter table solicitud_prestamo add foreign key (num_det_soli) references detalle_soli_pres (num_det_soli);
alter table detalle_prestamo add foreign key (num_pres) references prestamo (num_pres);
alter table detalle_soli_pres add foreign key (num_soli) references solicitud_prestamo (num_soli);