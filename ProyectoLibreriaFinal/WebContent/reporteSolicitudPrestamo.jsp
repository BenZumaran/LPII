<%@page import="beans.SolicitudDTO" %>
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
				List<SolicitudDTO> lista = (List<SolicitudDTO>) request.getAttribute("dataSolicitud");
			%>
			<table>
				<tr>				
					<td>
						Número de Solicitud:
					</td>
					<td>
						Solicitante:
					</td>
					<td>
						Aprobador:
					</td>
					<td>
						Creacion Solicitud:
					</td>
					<td>
						Aprobación Solicitud:
					</td>
					<td>
						Fecha Inicio Prestamo:
					</td>
					<td>
						Fecha Devolución Prestamo:
					</td>
					<td>
						Estado Solicitud
					</td>
				</tr>
				<tr>				
					<td>
					</td>
					<td>
					</td>
					<td>
					</td>
					<td>
					</td>
					<td>
					</td>
					<td>
					</td>
					<td>
					</td>
					<td>
						<form action="ServletSolicitud?rqst=filtrar&nomfilro=estado" name="Buscar" method="post">
							<select id="sel1" class="cbo" name="cbo_estado">
								<option value="listar" default></option>
								<option value="pendiente" >Pendiente</option>
								<option value="aceptada" >Aceptada</option>
								<option value="denegada" >Denegada</option>
							</select>
							<input id="btn5" class="btn-indx" type="submit" value="Buscar">
						</form>
					</td>
				</tr>
				<% for(SolicitudDTO solicitud : lista){
					%>	
				<tr>			
					<td>
						<%=solicitud.getNumSolicitud() %>
					</td>
					<td>
						<%=solicitud.getCodUsuSolicitante() %>
					</td>
					<td>
						<%=solicitud.getCodUsuAprobador() %>
					</td>
					<td>
						<%= solicitud.getFecCreacionSoli() %>
					</td>
					<td>
						<%= solicitud.getFecAprobacionSoli() %>
					</td>
					<td>
						<%= solicitud.getFecIniPrestamo()%>
					</td>
					<td>
						<%= solicitud.getFecDevPrestamo()%>
					</td>
					<td>
						<%= solicitud.getEstadoSoli()%>
					</td>			
					<td>
						<a class="btn-indx" href="ServletSolicitud?rqst=buscar&actualizar=true&numero=<%=solicitud.getNumSolicitud()%>">Actualizar</a><br>
					</td>		
				</tr>					
					<% } %>
			</table>
		
	</div>	
</body>
</html>