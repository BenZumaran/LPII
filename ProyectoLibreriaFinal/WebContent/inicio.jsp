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
		<form action="ServletUsuario?rqst=ingresar" name="ingresar" method="post">
			<table align="center">
				<tr>
					<td>
						Nombre Usuario:
					</td>
					<td>
						<input  class="input" type="text" name="nom_usu" required>
					</td>
				</tr>
				<tr>
					<td>
						Password:
					</td>
					<td>
						<input  class="input" type="password" name="password" required>
					</td>
				</tr>
				<tr>
					<td>
						<input  class="button" type="submit" value="Ingresar">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>