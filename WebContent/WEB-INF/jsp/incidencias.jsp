<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Incidencias</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="./codebase/reporte.css"/>
<link type="text/css" rel="stylesheet" href="./codebase/dhtmlxscheduler3.css"/>
<link rel="stylesheet" type="text/css" href="./codebase/sweetalert.css">
</head>
<body>

	<!-- Encabezado -->
		<div class = "header" id = "header"></div>
	<!-- Fin Encabezado -->
	
	<div class = "content" id = "content">
	
		<!-- Titulo de la pantalla -->
		<div class = "sample" id = "sample" ></div>
		<div style="text-align:center;">
			<table id="incidencia"  border = "1" style="margin-left: 25%; width:30%;">
				<thead>
					<tr>
						<th colspan="2" class="text-center" width="15%"> INCIDENCIAS </th>
					</tr>
				</thead>
   		  		<tbody></tbody>
   		  	</table>
	</div>
</div>

	<!-- Script -->
	<script type="text/javascript" src = "codebase/js/lib/jquery-3.1.0.js"></script>
	<script type="text/javascript" src = "codebase/js/lib/jquery-ui-1.10.4.custom.js"></script>
	<script type="text/javascript" src = "codebase/js/lib/jquery.ui.datepicker.js"></script>
	<script src="codebase/js/lib/sweetalert.min.js"></script> 
	<script type="text/javascript" src = "codebase/js/incidencias.js"></script>
	<!-- Fin Script -->

</body>
</html>