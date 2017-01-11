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
<link rel="stylesheet" href="codebase/js/lib/jquery-ui-1.12.1.custom/jquery-ui.css">
</head>
<body>

	<!-- Encabezado -->
		<div class = "header" id = "header"></div>
	<!-- Fin Encabezado -->
	
	<!-- Menu -->
	<div class = "menu" id = "menu"><%@ include file="menu.jsp" %></div>
	<!-- Fin Menu -->
	
	<div class = "content" id = "content">
	
		<!-- Titulo de la pantalla -->
		<div class = "sample" id = "sample" ></div>
		
		<div>
			<h4>Elija un rango de fechas:</h4>
			<label for="from">De:</label>
			<input type="text" id="from" name="from">
			<label for="to">A:</label>
			<input type="text" id="to" name="to">
			
			<input type="button" value="Buscar" onclick="buscarIncidencia();"/>
		</div>
		
		<br>
		<br>
		
		<div style = "text-align:center;">
			<table id="incidencia" class="incidencia"  border = "1" style = "margin-left: 25%; width:30%;" >
				<thead>
					<tr>
						<th colspan="2" class="text-center" width="15%"> INCIDENCIAS </th>
					</tr>
				</thead>
   		  		<tbody></tbody>
   		  	</table>
		</div>

		<div id="Detalle_Dialog" title="Detalle de Incidencias" style="overflow: scroll; height: 450px; width: 450px;">
			<table id="myTable" style="margin: 0 auto;">
				<thead>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
		
	</div>

	<!-- Script -->
	<script type="text/javascript" src = "codebase/js/lib/jquery-3.1.1.js"></script>
	<script src="codebase/js/lib/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
	<script src="codebase/js/lib/sweetalert.min.js"></script> 
	<script type="text/javascript" src = "codebase/js/incidencias.js"></script>
	
	<script>
	
	$.datepicker.regional['es'] = {
			 closeText: 'Cerrar',
			 prevText: '< Ant',
			 nextText: 'Sig >',
			 currentText: 'Hoy',
			 monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
			 monthNamesShort: ['Ene','Feb','Mar','Abr', 'May','Jun','Jul','Ago','Sep', 'Oct','Nov','Dic'],
			 dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
			 dayNamesShort: ['Dom','Lun','Mar','Mié','Juv','Vie','Sáb'],
			 dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','Sá'],
			 weekHeader: 'Sm',
			 dateFormat: 'dd/mm/yy',
			 firstDay: 1,
			 isRTL: false,
			 showMonthAfterYear: false,
			 yearSuffix: ''
			 };
	
	  $( function() {
	    $( "#from" ).datepicker( $.datepicker.regional['es'] );
	    $( "#to" ).datepicker( $.datepicker.regional['es'] );
	  } );
	</script>
	
	<!-- Fin Script -->

</body>
</html>