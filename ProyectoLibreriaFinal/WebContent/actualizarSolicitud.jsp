<%@page import="beans.SolicitudDTO" %>
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

			<%
			SolicitudDTO solicitud = (SolicitudDTO) request.getAttribute("dataSolicitud");
			%>
			
 <a class="btn-indx" href="menu.jsp">Menú</a><br>
	<div id="div-indx" >	
		<%-- 
		<% if(Boolean.parseBoolean((String) request.getAttribute("actualizar"))){ %>
		--%>
		<form action="ServletSolicitud?rqst=actualizar" name="actualizar" method="post">
			<table align="center">
				<tr>
					<td>
						Número Solicitud:
					</td>
					<td>
						<input  class="input" type="text" name="num_soli" value="<%=solicitud.getNumSolicitud() %>" readonly>
					</td>
				</tr>
				<tr>
					<td>
						Codigo Usuario Solicitante:
					</td>
					<td>
						<input  class="input" type="text" name="cod_usu_soli" value="<%=solicitud.getCodUsuSolicitante() %>" readonly>
					</td>
				</tr>
				<tr>
					<td>
						Codigo Usuario Aprobador:
					</td>
					<td>
						<input  class="input" type="text" name="cod_usu_aprob" value="<%=solicitud.getCodUsuAprobador() %>" readonly>
					</td>
				</tr>
				<tr>
					<td>
						Fecha Creación Solicitud:
					</td>
					<td>
						<input  class="input" type="date" name="fec_cre_soli" value="<%=solicitud.getFecCreacionSoli() %>" readonly>
					</td>
				</tr>
				<tr>
					<td>
						Fecha Aprobación Solicitud:
					</td>
					<td>
						<input  class="input" type="date" name=""fec_apro_soli"" value="<%=solicitud.getFecAprobacionSoli() %>" readonly>
					</td>
				</tr>
				<tr>
					<td>
						Fecha Inicio Prestamo:
					</td>
					<td>
						<input  class="input" type="date" name="fec_ini_pres" value="<%=solicitud.getFecIniPrestamo() %>" readonly>
					</td>
				</tr>
				<tr>
					<td>
						Fecha Devolución Prestamo:
					</td>
					<td>
						<input  class="input" type="date" name="fec_dev_pres" value="<%=solicitud.getFecDevPrestamo() %>" readonly>
					</td>
				</tr>
				<tr>
					<td>
						Estado Solicitud:
					</td>
					<td>
					<select  class="cbo" name="cbo_estado">
						<option value="pendiente" <%if(solicitud.getEstadoSoli().equals("pendiente")){ %>selected<%} %> >Pendiente</option>
						<option value="aceptada" <%if(solicitud.getEstadoSoli().equals("aceptada")){ %>selected<%} %> >Aceptada</option>
						<option value="denegada" <%if(solicitud.getEstadoSoli().equals("denegada")){ %>selected<%} %> >Denegada</option>
					</select>
					</td>
				</tr>
				<tr>
					<td>
						<input  class="button" type="submit" value="Actualizar">
					</td>
				</tr>
			</table>
		</form>
		<%-- 
		<%
		} else{
		%>		
		
		
		<form action="ServletSolicitud?rqst=actualizar" name="actualizar" method="post">
			<table align="center">
				<tr>
					<td>
						Codigo Usuario Aprobador:
					</td>
					<td>
						<input  class="input" type="text" name="anio_libro" value="<%=solicitud.getCodUsuAprobador() %>" required>
					</td>
				</tr>
				<tr>
					<td>
						Fecha Creación Solicitud:
					</td>
					<td>
						<input  class="input" type="date" name="anio_libro" value="<%=solicitud.getFecCreacionSoli() %>" required>
					</td>
				</tr>
				<tr>
					<td>
						Fecha Aprobación Solicitud:
					</td>
					<td>
						<input  class="input" type="date" name="anio_libro" value="<%=solicitud.getFecAprobacionSoli() %>" required>
					</td>
				</tr>
				<tr>
					<td>
						Fecha Inicio Prestamo:
					</td>
					<td>
						<input  class="input" type="date" name="anio_libro" value="<%=solicitud.getFecIniPrestamo() %>" required>
					</td>
				</tr>
				<tr>
					<td>
						Fecha Devolución Prestamo:
					</td>
					<td>
						<input  class="input" type="date" name="anio_libro" value="<%=solicitud.getFecDevPrestamo() %>" required>
					</td>
				</tr>
				<tr>
					<td>
						Estado Solicitud:
					</td>
					<td>
					<select  class="cbo" name="cbo_estado">
						<option value="pendiente" <%if(solicitud.getEstadoSoli().equals("pendiente")){ %>selected<%} %> >Pendiente</option>
						<option value="aceptada" <%if(solicitud.getEstadoSoli().equals("aceptada")){ %>selected<%} %> >Aceptada</option>
						<option value="denegada" <%if(solicitud.getEstadoSoli().equals("denegada")){ %>selected<%} %> >Denegada</option>
					</select>
					</td>
				</tr>
				<tr>
					<td>
						<input  class="button" type="submit" value="Actualizar">
					</td>
				</tr>
			</table>
		</form>
		
		
		<%
		}
		%>
		--%>
	</div>
</body>
</html>