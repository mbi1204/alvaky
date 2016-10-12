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
			
			console.log(data);

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
		if(lectura == "manTicket"){
			for ( var item in datos.manTicket) {
				console.log(datos.manTicket[item]);
			}
		}
		if(lectura == "ordFFecha"){
			for ( var item in datos.ordFFecha) {
				console.log(datos.ordFFecha[item]);
			}
		}
		if(lectura == "calidadParam"){
			for ( var item in datos.calidadParam) {
				console.log(datos.calidadParam[item]);
			}
		}
	}
	else{
		sweetAlert("Oops...", "No cuenta con detalle este registro", "error");
	}
}



$(document).ready(function() {
	incidencias();
});