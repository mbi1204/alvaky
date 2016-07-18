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
							 '<td class="text-center"><input type="checkbox" id="registro" '+ 
							 'name="registro" value="'+data[item]+'" onclick="lecturaRegistro();"/></td>' +'</tr>');
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

function cambiarDisplay(id) {
	if (!document.getElementById){
		return false;
	}
	var fila = document.getElementById(id);
	if (fila.style.display != "none") {
		fila.style.display = "none"; // ocultar fila
	} 
}

function busquedaCompania(){
	
	$.ajax({
		type : "GET",
		url : "CompaniaListado",
		dataType : "json",
		contentType : "application/json",
		data : {
			lActivos : "TRUE"
		},
		success : function(data) {
			
			if(data != ""){
				
				$('#cCompania option').remove();
				$('#cCompania').append('<option selected=\"selected\">Seleccione una compa&ntilde;ia:</option>');
				
				for ( var item in data) {
					$('#cCompania').append('<option value="'+data[item].cCveCia+'">'+data[item].cRazonS+'</option>');
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

function busquedaCliente(){
	var cCompania = $('#cCompania').val();
	
	var fila = document.getElementById("cliente");
	fila.style.display = "";
	
	$.ajax({
		type : "GET",
		url : "ClienteListado",
		dataType : "json",
		contentType : "application/json",
		data : {
			cCveCia : cCompania
		},
		success : function(data) {
			
			if(data != ""){
				
				$('#Cliente option').remove();
				$('#Cliente').append('<option selected=\"selected\">Seleccione un cliente:</option>');
				
				for ( var item in data) {
					$('#Cliente').append('<option value="'+data[item].cCliente+'">'+data[item].cRazonS+'</option>');
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

function leerCookies(galleta) {

	var arreglo = galleta.split(";");
	var final = [];
	for ( var i in arreglo) {
		final.push(arreglo[i].split("="));
	}
	return final;

}

function lecturaRegistro(){
	var objeto = $('#registro');
	console.log(objeto);
}

$(document).ready(function() {
	
	var mensajeError = document.getElementById("mensajeError").innerHTML;
	if(mensajeError != null && mensajeError != ""){
		sweetAlert("Oops...", mensajeError, "error");
	}
	
	listadoUsuarios();
	busquedaCompania();
	cambiarDisplay('cliente');
	cambiarDisplay('estatus');
	
	$('#AddCtUsuarioWeb_Dialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 800,
		buttons : {
			"Guardar" : function() {
				$('#Form_ctUsuarioWeb_Add').submit();
				
			},
			"Cancelar" : function() {
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

