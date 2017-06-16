/**
 * 
 * Autor: Estrada Mares Alejandro
 * Fecha: 10 de Octubre de 2016
 * Programa: incidencias
 * Descripcion: Trae las incidencias para alvaky
 * 
 */

var manTicket = "manTicket";
var ordFFecha = "ordFFecha";
var calidadParam = "calidadParam";
var datos;
var datosAgua;
var headAgua;


function incidencias(cFechaInicio, cFechaFin){

	var arreglo = leerCookies(document.cookie);
	var cCveCia = arreglo[0][1];
	var cCliente = arreglo[1][1];

	$.ajax({type : "GET",
		url : "incidencias/datos",
		dataType : "json",
		contentType : "application/json",
		data : {
			cCveCia      : cCveCia,
			cCliente     : cCliente,
			cFechaInicio : cFechaInicio,
			cFechaFin    : cFechaFin
		},
		success : function(data) {

			if(data != ""){
				$("#incidencia > tbody").empty();
				
				datos = data;

				$('#incidencia > tbody').append('<tr class="text-center" onclick="detalle('+data.ticketConteo+','+manTicket+');">' +
						'<td class="text-center"> Ticket: </td>'             +
						'<td class="text-center">' + data.ticketConteo       + '</td>'         +
						'</tr>'                                              +

						'<tr class="text-center" onclick="detalle('+data.ordFFechaConteo+','+ordFFecha+');">'                      +
						'<td class="text-center"> Ordenes Fuera de Fecha: </td>' +
						'<td class="text-center">' + data.ordFFechaConteo        + '</td>'     +
						'</tr>'                                                  +

						'<tr class="text-center" onclick="detalle('+data.calidadParamConteo+','+calidadParam+');">'                +
						'<td class="text-center"> Calidad de Parametros: </td>'         +
						'<td class="text-center">' + data.calidadParamConteo + '</td>'  +
				'</tr>');

			}else{
				swal("No Existen Registros");
			}
		},
		error : function(data,status,error) {
			sweetAlert("Oops...", "Algo salio mal intenta mas tarde o contacta a sistemas", "error");
		}

	});
}

function leerCookies(galleta) {

	var arreglo = galleta.split(";");
	var final = [];
	for ( var i in arreglo) {
		final.push(arreglo[i].split("="));
	}
	return final;

}

function detalle(valor,lectura){
	if(valor != 0){
		vistaDetalle();
		if(lectura == "manTicket"){
			var head = ['Ticket','Orden de Servicio',
			            'Tienda','Prioridad','Fecha de Recepcion','Fecha de Ejecucion',
			            'Fecha Limite de Atencion'];
			
			buildDetalle(datos.manTicket, head);
		}
		if(lectura == "ordFFecha"){
			var head = ['Tienda','Orden de Servicio',
			            'Validacion','Fecha de Planeacion','Fecha de Ejecucion',
			            ];
			buildDetalle(datos.ordFFecha, head);
		}
		if(lectura == "calidadParam"){
			
			//Limpieza de encabezado y cuerpo de la tabla
			$("#myTable > thead").empty();
			$("#myTable > tbody").empty();
			
			var sucursal = "";
			var contador = 0;
			
			headAgua = ['Ticket','Orden de Servicio',
			            'Parametro','Descripcion','Fecha de Ejecucion',
			            'Lectura' , 'Valor Maximo','Valor Minimo'];
			
			$('#myTable > thead').append('<th class="text-center"> Tiendas </th>');
			
			for ( var item in datos.calidadParam) {

				datosAgua = datos.calidadParam;
				
				if (datos.calidadParam[item].cTienda3 != sucursal){
					
					sucursal = datos.calidadParam[item].cTienda3;
					//sucursal = sucursal.split(",");
					
					$('#myTable > tbody').append('<tr class="text-center">'
					+ '<td class="text-center" onclick="buildTienda(\''+sucursal+'\');" >' + datos.calidadParam[item].cTienda3 + '</td>' +
					+ '</tr>');
					
				}
			}
		}
	}
	else{
		sweetAlert("Oops...", "No cuenta con detalle este registro", "error");
	}
}

function buildDetalle(arreglo, head){
	
	console.log(head);
	console.log(arreglo);
	
	//Limpieza de encabezado y cuerpo de la tabla
	$("#myTable > thead").empty();
	$("#myTable > tbody").empty();
	
	//Creando el encabezado
	for ( var item in head) {
		
		$('#myTable > thead').append('<th class="text-center">' + head[item] + '</th>');
	}
	
	//Arreglo para los datos
	for ( var item in arreglo) {
		
		$('#myTable > tbody').append(
				'<tr class="text-center">'); 
		
		for ( var elemento in arreglo[item]) {			
			$('#myTable > tbody').append(
					'<td class="text-center">' + arreglo[item][elemento] + '</td>');
		}
		
		$('#myTable > tbody').append('</tr>');
	}	
}

function buildTienda(tienda){
	
	console.log(tienda);
	
	//Construccion de la pantalla de tiendas
	//Limpieza de encabezado y cuerpo de la tabla
	$("#myTable2 > thead").empty();
	$("#myTable2 > tbody").empty();
	
	console.log(headAgua);
	//Creando el encabezado
	for ( var item in headAgua) {
		
		$('#myTable2 > thead').append('<th class="text-center">' + headAgua[item] + '</th>');
	}
	
	console.log(datosAgua);
	//Arreglo para los datos
	for ( var item in datosAgua) {
		
		if (datosAgua[item].cTienda3 ==  tienda){
			$('#myTable2 > tbody').append('<tr class="text-center">'); 
	
			for ( var elemento in datosAgua[item]) {			
				$('#myTable2 > tbody').append(
						'<td class="text-center">' + datosAgua[item][elemento] + '</td>');
			}
			
			$('#myTable2 > tbody').append('</tr>');
		}
	
	}
	
	vistaDetalle2();
	
}


function vistaDetalle() {

	$('#Detalle_Dialog').dialog({
        resizable: false,
        autoOpen: true,
        autoReposition: false,
        height: 500,
        width: 950,
        modal: true});

}

function vistaDetalle2() {

	$('#Detalle_Dialog2').dialog({
        resizable: false,
        autoOpen: true,
        autoReposition: false,
        height: 500,
        width: 950,
        modal: true});

}

function buscarIncidencia(){
	
	var fechaInicio = $('#from').val();
	var fechaFin = $('#to').val();
	
	incidencias(fechaInicio, fechaFin);
	
}
