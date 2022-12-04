<%@page import="beans.UsuarioDTO" %>
<%@page import="beans.DataGenericaDTO" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
<title>Automatización Libreria</title>
<link rel="stylesheet" href="estilos.css">
</head>
<body>
	<a class="btn-indx" href="menu.jsp">Menú</a><br>
	<div id="div-indx" >	
		<form action="ServletUsuario?rqst=actualizar" name="actualizar" method="post">
			<%
				UsuarioDTO usuario = (UsuarioDTO) request.getAttribute("dataUsuario");
				List<DataGenericaDTO> dataGeneroLibro = (List<DataGenericaDTO>) request.getAttribute("dataGeneroLibro");
				List<DataGenericaDTO> dataTipoDocumento = (List<DataGenericaDTO>) request.getAttribute("dataTipoDocumento");
			%>
			<input  class="input" type="hidden" name="txt_tipo_usu" value="<%=usuario.getTipoUsuario() %>">
			<input  class="input" type="hidden" name="txt_img_usu" value="<%=usuario.getImgUsuario() %>">
			<input  class="input" type="hidden" name="admin_usu" value="<%=usuario.isAdminUsuario() %>">
			<table align="center">
				<tr>
					<td>
						Nombre Usuario:
					</td>
					<td>
						<input  class="input" type="text" name="txt_cod" value="<%=usuario.getCodUsuario() %>" readonly>
					</td>
				</tr>
				<tr>
					<td>
						Nombres:
					</td>
					<td>
						<input  class="input" type="text" name="txt_nombre" value="<%=usuario.getNomUsuario() %>" required>
					</td>
				</tr>
				<tr>
					<td>
						Apellido Paterno:
					</td>
					<td>
						<input  class="input" type="text" name="txt_ape_paterno" value="<%=usuario.getApePatUsuario() %>" required>
					</td>
				</tr>
				<tr>
					<td>
						Apellido Materno:
					</td>
					<td>
						<input  class="input" type="text" name="txt_ape_materno" value="<%=usuario.getApeMatUsuario() %>" required>
					</td>
				</tr>
				<tr>
					<td>
						Números de Documento:
					</td>
					<td>
						<input  class="input" type="number" maxlength="15" name="txt_doc_usu" value="<%=usuario.getNumDocUsuario() %>" required>
					</td>
				</tr>
				<tr>
					<td>
						Fecha de Nacimiento:
					</td>
					<td>
						<input  class="input" type="date" name="fec_nac_usu" value="<%=usuario.getFecNacUsuario() %>" required>
					</td>
				</tr>
				<tr>
					<td>
						<input  class="button" type="submit" value="Actualizar">
					</td>
				</tr>
			</table>
		</form>
		<a class="btn-indx" href="ServletUsuario?rqst=listar">Cambiar Contraseña</a><br>
	</div>	
</body>
</html>