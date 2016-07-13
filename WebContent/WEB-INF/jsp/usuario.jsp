<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuarios</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="./codebase/reporte.css"/>
<link rel="stylesheet" type="text/css" href="./codebase/sweetalert.css">
<link rel="stylesheet" type="text/css" href="./codebase/tabla.css">
</head>
<body>
	<!-- Encabezado -->
	<div class="header" id="header"></div>
	<!-- Fin Encabezado -->

	<!-- Menu -->
	<div class="menu" id="menu"></div>
	<!-- Fin Menu -->

	<!-- Contenido -->
	<div class="content" id="content">

		<!-- Titulo de la pantalla -->
		<div class="sample" id="sample">
			<div class="name" id="name">Gestión de Usuarios</div>
			<div class="dsc" id="dsc"></div>
			<div class="clear" id="clear"></div>
		</div>
		<!-- Fin Titulo de la pantalla -->

		<!-- Contenido Principal -->
		<div class="scheduler" id="scheduler">
			<div class="dhx_cal_container" id="scheduler_her" style="border-style:none">
				<div class="usuario">
					<h1>Gestión de Usuarios</h1>
					<table id="mytable" class = "mytable">
						<thead>
							<tr>
								<th>Nombre</th>
								<th>Usuario</th>
								<th>Estatus</th>
								<th>Seleccione</th>
							</tr>
						</thead>
						<tbody></tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- Fin Contenido Principal -->
	</div>
	<!-- Fin Contenido -->
</body>
</html>