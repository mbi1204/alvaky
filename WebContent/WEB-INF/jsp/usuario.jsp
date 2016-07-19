<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuarios</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="./codebase/reporte.css"/>
<link rel="stylesheet" type="text/css" href="./codebase/sweetalert.css">

<link rel="stylesheet" type="text/css" href="./codebase/boton.css">
<link rel="stylesheet" type="text/css" href="./codebase/font-awesome-4.0.3/css/font-awesome.css">
<link rel="stylesheet" type="text/css" href="./codebase/pure-0.4.2.css">
<link rel="stylesheet" type="text/css" href="./codebase/jquery-ui-1.10.4.custom.css">
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
				<div id="AddCtUsuarioWeb_Dialog" style="display: none;">
				<%@ include file="usuarioAdd.jsp"%>
				</div>
				<a class="boton" onclick="add_ctUsuarioWeb();">Agregar Usuario </a>
				<a class="boton">Modificar Usuario</a>
				<a class="boton" onclick="borraRegistro();">Borrar Usuario</a>
				<div class="usuario">
					<table id="mytable" class = "pure-table pure-table-bordered pure-table-striped">
						<thead>
							<tr>
								<th>Nombre</th>
								<th>Usuario</th>
								<th>Compañia</th>
								<th>Cliente</th>
								<th>Estatus</th>
								<th>Seleccione</th>
							</tr>
						</thead>
						<tbody></tbody>
					</table>
				</div>
				<p id="mensajeError" style="display:none;">${mensaje}</p>
			</div>
		</div>
		<!-- Fin Contenido Principal -->
	</div>
	<!-- Fin Contenido -->
	
	<script type="text/javascript" src="codebase/js/lib/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="codebase/js/lib/jquery-ui-1.10.4.custom.js"></script>
	<script type="text/javascript" src="codebase/js/lib/jquery.ui.datepicker.js"></script>
	<script type="text/javascript" src="codebase/js/lib/sweetalert.min.js"></script>
	<script type="text/javascript" src="codebase/js/usuario.js"></script>
</body>
</html>