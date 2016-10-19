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


function incidencias(){

	var arreglo = leerCookies(document.cookie);
	var cCveCia = arreglo[0][1];
	var cCliente = arreglo[1][1];

	$.ajax({type : "GET",
		url : "incidencias/datos",
		dataType : "json",
		contentType : "application/json",
		data : {
			cCveCia   : cCveCia,
			cCliente  : cCliente,
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
			            'Fecha Limite de Atencion' , 'Tecnico'];
			
			buildDetalle(datos.manTicket, head);
		}
		if(lectura == "ordFFecha"){
			var head = ['Tienda','Orden de Servicio',
			            'Validacion','Fecha de Recepción','Fecha de Ejecucion',
			            'Tecnico'];
			buildDetalle(datos.ordFFecha, head);
		}
		if(lectura == "calidadParam"){
			var head = ['Ticket','Orden de Servicio',
			            'Parametro','Descripcion','Fecha de Ejecucion',
			            'Lectura' , 'Valor Maximo','Valor Minimo'];
			buildDetalle(datos.calidadParam , head);
		}
	}
	else{
		sweetAlert("Oops...", "No cuenta con detalle este registro", "error");
	}
}

function buildDetalle(arreglo, head){
	
	var cont = 0;
	
	//Limpieza de encabezado y cuerpo de la tabla
	$("#myTable > thead").empty();
	$("#myTable > tbody").empty();
	
	//Creando el encabezado
	for ( var item in head) {
		
		$('#myTable > thead').append('<td class="text-center">' + head[item] + '</td>');
	}
	
	//Arreglo para los datos
	for ( var item in arreglo) {
		
		$('#myTable > tbody').append(
				'<tr class="text-center"></tr>'); 
		
		for ( var elemento in arreglo[item]) {			
			$('#myTable > tbody').append(
					'<td class="text-center">' + arreglo[item][elemento] + '</td>');
		}
				
				 
	}	
}

function vistaDetalle() {

	$('#Detalle_Dialog').dialog({
        resizable: false,
        autoOpen: true,
        position: {my: "center", at: "center", of: window},
        width: 'auto',
        height: 'auto',
        modal: true});

}

$(document).ready(function() {
	incidencias();
});