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

function add_ctUsuarioWeb() {
	$('#AddCtUsuarioWeb_Dialog').dialog("option", "title", 'Agregar Usuario');
	$('#AddCtUsuarioWeb_Dialog').dialog('open');

}

function edit_ctUsuario(cUsuario) {
	
	$.get("get_ctUsuario/" + cUsuario, function(result) {
		$("#UpdateCtUsuario_Dialog").html(result);
		$("#UpdateCtUsuario_Dialog").dialog("option", "title", 'Editar Usuario');
		$("#UpdateCtUsuario_Dialog").dialog('open');

		// initializeDatePicker();
	});
	
	


}

function initializeDatePicker() {
	$(".datepicker").datepicker({
		dateFormat : "yy-mm-dd",
		changeMonth : true,
		changeYear : true,
		showButtonPanel : true
	});
}

function resetDialog(form) {

	form.find("input").val("");
}

$(document).ready(function() {
	
	listadoUsuarios();
	
	$('#AddCtUsuarioWeb_Dialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 800,
		buttons : {
			"Save" : function() {
				$('#Form_ctUsuarioWeb_Add').submit();
				
				
				
				
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#Form_ctUsuarioWeb_Add'));

			$(this).dialog('close');
		}
	});

	
	$('#UpdateCtUsuario_Dialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 800,
		buttons : {
			"Save" : function() {
				$('#Form_ctUsuario_Update').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#Form_ctUsuario_Update'));

			$(this).dialog('close');
		}
	});
});