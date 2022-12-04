<%@page import="beans.PrestamoDTO" %>
<%@page import="beans.UsuarioDTO" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Automatización Libreria</title>
<link rel="stylesheet" href="estilos.css">
</head>
<body>

	<a class="btn-indx" href="menu.jsp">Menú</a><br>
	<div id="div-indx" >	
			<%
				List<PrestamoDTO> lista = (List<PrestamoDTO>) request.getAttribute("dataPrestamo");
			%>
			<table>
				<tr>				
					<td>
						Número de Prestamo:
					</td>
					<td>
						Código Usuario:
					</td>
					<td>
						Númer de solicitud:
					</td>
					<td>
						Deuda:
					</td>
					<td>
						Estado Prestamo:
					</td>
				</tr>
				<tr>				
					<td>
					</td>
					<td>
						<form action="ServletPrestamo?rqst=filtrar&nomfilro=usuario" name="Buscar" method="post">							
							<input id="btn5" class="btn-indx" name="txtUsuario" type="text" value="">
							<input id="btn5" class="btn-indx" type="submit" value="Buscar">
						</form>
					</td>
					<td>
					</td>
					<td>
					</td>
					<td>
					</td>
				</tr>
				<% for(PrestamoDTO prestamo : lista){
					%>	
				<tr>				
					<td>
						<%=prestamo.getNumPrestamo() %>
					</td>
					<td>
						<%=prestamo.getCodUsuario()%>
					</td>
					<td>
						<%=prestamo.getNumSolicitud()%>
					</td>
					<td>
						<%=prestamo.getDeudaPrestamo()%>
					</td>
					<td>
						<%=prestamo.getEstadoPrestamo()%>
					</td>
				</tr>				
				</tr>					
					<% } %>
			</table>
		
	</div>	
</body>
</html>