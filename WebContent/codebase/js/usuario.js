/**
 * Autor: Estrada Mares Alejandro Fecha: 11 de Abril de 2016 Programa: reporte
 * Descripcion: Genera la comunicacion con el server para el llenado de
 * la tabla de usuarios web
 */

$.ajax({
		type : "GET",
		url : "UsuarioListado",
		dataType : "json",
		contentType : "application/json",
		data : {
			lActivos : "TRUE"
		},
		success : function(data) {
			
			if(data != ""){
				$("#mytable > tbody").empty();
				for ( var item in data) {
					$('#mytable > tbody').append('<tr class="text-center">'                     +
							 '<td class="text-center">' + data[item].cNombre                    +   '</td>' +
							 '<td class="text-center">' + data[item].cUsuario                   +   '</td>' + 
							 '<td class="text-center">'	+ data[item].CtUsuaCompWeb.cCveCia      +   '</td>' +
							 '<td class="text-center">'	+ data[item].cCliente                   +   '</td>' +
							 '<td class="text-center">'	+ data[item].lActivo                    +   '</td>' +'</tr>');
					}
				
				}else{
					swal("No Existen Registros");
				}
		},
		error : function(data,status,error) {
			sweetAlert("Oops...", "Algo salio mal intenta mas tarde o contacta a sistemas", "error");
		}
		
	});