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

			<%
				LibroDTO libro = (LibroDTO) request.getAttribute("dataLibro");
				List<DataGenericaDTO> dataGeneroLibro = (List<DataGenericaDTO>) request.getAttribute("dataGeneroLibro");
			%>
			
 <a class="btn-indx" href="menu.jsp">Menú</a><br>
	<div id="div-indx" >	
		<% if(Boolean.parseBoolean((String) request.getAttribute("actualizar"))){ %>
		
		<form action="ServletLibro?rqst=actualizar" name="actualizar" method="post">
			<table align="center">
				<tr>
					<td>
						Código Libro:
					</td>
					<td>
						<input  class="input" type="text" name="codigo_libro" value="<%=libro.getCodLibro() %>" readonly>
					</td>
				</tr>
				<tr>
					<td>
						Descripción Libro:
					</td>
					<td>
						<input  class="input" type="text" name="desc_libro" value="<%=libro.getDescLibro() %>" required>
					</td>
				</tr>
				<tr>
					<td>
						Año Libro:
					</td>
					<td>
						<input  class="input" type="number" name="anio_libro" value="<%=libro.getAnioLibro() %>" required>
					</td>
				</tr>
				<tr>
					<td>
						Género:
					</td>
					<td>
					<select  class="cbo" name="cbo_genero">
						<% for(DataGenericaDTO g : dataGeneroLibro){ %>
							<option value="<%=g.getCodigo() %>" <%if(g.getCodigo().equals(libro.getCodGenero())){ %>selected<%} %>><%=g.getDescripcion() %></option>
						<% } %>
					</select>
					</td>
				</tr>
				<tr>
					<td>
						Autor Libro:
					</td>
					<td>
						<input  class="input" type="text" name="autor_libro" value="<%=libro.getAutorLibro() %>" required>
					</td>
				</tr>
				<tr>
					<td>
						Estado Libro:
					</td>
					<td>
					<select  class="cbo" name="cbo_estado">
						<option value="stock" <%if(libro.getEstadoLibro().equals("stock")){ %>selected<%} %> >Stock</option>
						<option value="prestado" <%if(libro.getEstadoLibro().equals("prestado")){ %>selected<%} %> >Prestado</option>
						<option value="solicitado" <%if(libro.getEstadoLibro().equals("solicitado")){ %>selected<%} %> >Solicitado</option>
						<option value="baja" <%if(libro.getEstadoLibro().equals("baja")){ %>selected<%} %> >Baja</option>
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
		} else{
		%>		
		
		<form action="ServletLibro?rqst=ingresar" name="actualizar" method="post">
			<table align="center">
				<tr>
					<td>
						Código Libro:
					</td>
					<td>
						<input  class="input" type="text" name="codigo_libro" maxlength="4"  required>
					</td>
				</tr>
				<tr>
					<td>
						Descripción Libro:
					</td>
					<td>
						<input  class="input" type="text" name="desc_libro" required>
					</td>
				</tr>
				<tr>
					<td>
						Año Libro:
					</td>
					<td>
						<input  class="input" type="number" name="anio_libro" maxlength="4" required>
					</td>
				</tr>
				<tr>
					<td>
						Género:
					</td>
					<td>
					<select  class="cbo" name="cbo_genero">
						<% for(DataGenericaDTO g : dataGeneroLibro){ %>
							<option value="<%=g.getCodigo() %>"><%=g.getDescripcion() %></option>
						<% } %>
					</select>
					</td>
				</tr>
				<tr>
					<td>
						Autor Libro:
					</td>
					<td>
						<input  class="input" type="text" name="autor_libro" required>
					</td>
				</tr>
				<tr>
					<td>
						Estado Libro:
					</td>
					<td>
					<select  class="cbo" name="cbo_estado">
						<option value="stock" >Stock</option>
						<option value="prestado">Prestado</option>
						<option value="solicitado"> >Solicitado</option>
						<option value="baja">Baja</option>
					</select>
					</td>
				</tr>
				<tr>
					<td>
						<input  class="button" type="submit" value="Ingresar">
					</td>
				</tr>
			</table>
		</form>
		
		
		<%
		}
		%>
	</div>
</body>
</html>