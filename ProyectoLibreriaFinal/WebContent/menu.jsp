<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
<title>Automatizaci�n Libreria</title>
<link rel="stylesheet" href="estilos.css">
</head>
<body>
	<div id="div-indx" >	
		<a class="btn-indx" href="ServletUsuario?rqst=buscar">Usuario</a><br>
		<h2>Libros</h2>
		<a class="btn-indx" href="ServletLibro?rqst=listar">Reporte Libros</a><br>
		<a class="btn-indx" href="ServletLibro?rqst=buscar&actualizar=false">Ingresar Libros</a><br>
		<h2>Pr�stamos</h2>
		<a class="btn-indx" href="ServletPrestamo?rqst=listar">Reporte Pr�stamos</a><br>
		<h2>Solicitudes de Prestamo</h2>
		<a class="btn-indx" href="ServletSolicitud?rqst=listar">Reporte Solicitudes</a><br>
		
	</div>	
</body>
</html>