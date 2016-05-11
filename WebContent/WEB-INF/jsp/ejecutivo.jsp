<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ejecutivo</title>
<link type="text/css" rel="stylesheet" href="./codebase/reporte.css"/>
<link type="text/css" rel="stylesheet" href="./codebase/dhtmlxscheduler3.css"/>
<link rel="stylesheet" type="text/css" href="./codebase/sweetalert.css">
</head>
<body onload="abrir_Reporte();">
	<!-- Encabezado -->
	<div class = "header" id = "header"></div>
	<!-- Fin Encabezado -->
	
	<!-- Menu -->
	<div class = "menu" id = "menu">
		<ul id = "listaMeses">
			<li><a onclick="pdf();" target="_blank">Prueba de Exportación PDF</a></li>
			<li><a onclick="excel();" target="_blank">Prueba de Exportación Excel</a></li>
		</ul>
	</div>
	<!-- Fin Menu -->
	
	<!-- Contenido -->
	<div class = "content" id = "content">
	
		<!-- Titulo de la pantalla -->
		<div class = "sample" id = "sample" >
			<div class = "name" id = "name"></div>
			<div class = "dsc" id = "dsc"></div>
			<div class = "clear" id = "clear"></div>
		</div>
		<!-- Fin Titulo de la pantalla -->
		
		<!-- Tabla de sucursales -->
				<div id="table" class = "table">
					<table id="reporteEje" class = "reporteEje">
						<thead>
							<tr>
								<th rowspan="2" class="text-center" width="14%">Fecha de Visita</th>
								<th colspan="4" class="text-center" width="12%">Agua Cruda</th>
								<th colspan="4" class="text-center" width="12%">Agua Suavizada</th>
								<th colspan="5" class="text-center" width="12%">Agua Filtrada</th>
								<th colspan="4" class="text-center" width="12%">Consumibles</th>
								<th colspan="2" class="text-center" width="12%">Refacciones</th>
								<th rowspan="2" class="text-center" width="14%">Acciones Realizadas</th>
								<th rowspan="2" class="text-center" width="14%">Comentarios Realizados</th>
								<th colspan="3" class="text-center" width="12%">Tiempos Reales de Trabajo</th>
							</tr>
							<tr>
								<!-- Agua Cruda -->
								<th class="text-center" width="3%">Chlorine (Cloro) 0.2 - 1.5 ppm</th>
								<th class="text-center" width="3%">pH 6.5 - 8.5</th>
								<th class="text-center" width="3%">Total Hardness (Dureza) 0 - 500 ppm</th>
								<th class="text-center" width="3%">Total Dissolved Solid (STD) <br/>0 - 1000 ppm</th>
								
								<!-- Agua Suavizada -->
								<th class="text-center" width="3%">Chlorine (Cloro) 0.2 - 1.5 ppm</th>
								<th class="text-center" width="3%">pH 6.5 - 8.5</th>
								<th class="text-center" width="3%">Total Hardness (Dureza) 0 - 500 ppm</th>
								<th class="text-center" width="3%">Total Dissolved Solid (STD) <br/>0 - 1000 ppm</th>
								
								<!-- Agua Filtrada -->
								<th class="text-center" width="3%">Chlorine (Cloro) &lt; - 1.5 ppm</th>
								<th class="text-center" width="3%">pH 6.8 - 7.4</th>
								<th class="text-center" width="3%">Total Hardness (Dureza) 17 - 85 ppm</th>
								<th class="text-center" width="3%">Total Dissolved Solid (STD) <br/>70 - 200 ppm</th>
								<th class="text-center" width="3%">Alkalinity (Alcalinidad) <br/>&lt; - 100 ppm</th>
								
								<!-- Consumibles -->
								<th class="text-center" width="3%">Sed.</th>
								<th class="text-center" width="3%">Sal</th>
								<th class="text-center" width="3%">Carbon</th>
								<th class="text-center" width="3%">Sal pellet</th>
								
								<!-- Refacciones -->
								<th class="text-center" width="6%">Otras</th>
								<th class="text-center" width="6%">Cantidad</th>
								
								<!-- Tiempos Reales de Trabajo -->
								<th class="text-center" width="4%">Hora de Llegada</th>
								<th class="text-center" width="4%">Hora de Salida</th>
								<th class="text-center" width="4%">Tiempo Total</th>
							</tr>
						</thead>
						<tbody></tbody>
					</table>
				</div>
		<!-- Fin Tabla de sucursales -->
	</div>
	<!-- Fin Contenido -->
	<!-- Scrips  -->
	<script type="text/javascript" src = "codebase/js/lib/jquery-1.10.2.js"></script>
	<script type="text/javascript" src = "codebase/js/lib/jquery-ui-1.10.4.custom.js"></script>
	<script type="text/javascript" src = "codebase/js/lib/jquery.ui.datepicker.js"></script>
	<script src="codebase/js/lib/sweetalert.min.js"></script> 
	<script type="text/javascript" src = "codebase/js/reporteEjecutivo.js"></script>
	<!-- Fin Scripts -->
</body>
</html>