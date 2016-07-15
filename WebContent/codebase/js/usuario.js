/**
 * Autor: Estrada Mares Alejandro Fecha: 11 de Abril de 2016 Programa: reporte
 * Descripcion: Genera la comunicacion con el server para el llenado de
 * la tabla de usuarios web
 */

function listadoUsuarios(){
	$.ajax({
		type : "GET",
		url : "UsuarioListado",
		dataType : "json",
		contentType : "application/json",
		data : {
			lActivos : "TRUE"
		},
		success : function(data) {
			
			console.log(data);
			
			if(data != ""){
				$("#mytable > tbody").empty();
				for ( var item in data) {
					var activo = data[item].lActivo ? "Activo":"Desactivo";
					$('#mytable > tbody').append('<tr class="text-center">'                 +
							 '<td class="text-center">' + data[item].cNombre                +   '</td>' +
							 '<td class="text-center">' + data[item].cUsuarioWeb            +   '</td>' + 
							 '<td class="text-center">'	+ data[item].ctUsuaCompWeb.cCveCia  +   '</td>' +
							 '<td class="text-center">'	+ data[item].cCliente               +   '</td>' +
							 '<td class="text-center">'	+ activo                            +   '</td>' +
							 '<td class="text-center"><input type="checkbox" name="vehicle" value="Bike"/></td>' +'</tr>');
					}	
				
				}else{
					swal("No Existen Registros");
				}
		},
		error : function(data,status,error) {
			sweetAlert("Oops...", "Algo salio mal intenta mas tarde o contacta a sistemas", "error");
		}
		
	});
}

$(document).ready(function() {
	listadoUsuarios();
});