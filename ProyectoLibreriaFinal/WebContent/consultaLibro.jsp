<%@page import="beans.LibroDTO" %>
<%@page import="beans.DataGenericaDTO" %>
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
				List<LibroDTO> lista = (List<LibroDTO>) request.getAttribute("dataLibro");
				List<DataGenericaDTO> dataGeneroLibro = (List<DataGenericaDTO>) request.getAttribute("dataGeneroLibro");
				String genero="";
			%>
			<table>
				<tr>				
					<td>
						Código de Libro:
					</td>
					<td>
						Descripción Libro:
					</td>
					<td>
						Anio Libro:
					</td>
					<td>
						Genero Libro:
					</td>
					<td>
						Autor Libro:
					</td>
					<td>
						Estado Libro:
					</td>
					<td>
					</td>
				</tr>
				<% for(LibroDTO libro : lista){
					
					for(DataGenericaDTO g : dataGeneroLibro) if(g.getCodigo().equals(libro.getCodGenero())) genero = g.getDescripcion();
					
					%>	
				<tr>			
					<td>
						<%=libro.getCodLibro() %>
					</td>
					<td>
						<%=libro.getDescLibro() %>
					</td>
					<td>
						<%=libro.getAnioLibro() %>
					</td>
					<td>
						<%=genero %>
					</td>
					<td>
						<%=libro.getAutorLibro() %>
					</td>
					<td>
						<%=libro.getEstadoLibro() %>
					</td>
					<td>
						<a class="btn-indx" href="ServletLibro?rqst=buscar&actualizar=true&codigo=<%=libro.getCodLibro()%>">Actualizar</a><br>
					</td>					
				</tr>					
					<% } %>
			</table>
		
	</div>	
</body>
</html>