/**
 * Autor: Estrada Mares Alejandro Fecha: 11 de Abril de 2016 Programa: reporte
 * Descripcion: Genera la comunicacion con el server para el llenado de la tabla
 * de usuarios web
 */
var pasar = false;
function listadoUsuarios() {
	$
			.ajax({
				type : "GET",
				url : "UsuarioListado",
				dataType : "json",
				contentType : "application/json",
				data : {
					lActivo : "TRUE"
				},
				success : function(data) {

					arreglo = data;

					if (data != "") {
						$("#mytable > tbody").empty();
						var contador = 0;
						for ( var item in data) {

							var activo = data[item].lActivo ? "Activo"
									: "Desactivo";
							$('#mytable > tbody')
									.append(
											'<tr class="text-center">'
													+ '<td class="text-center">'
													+ data[item].cNombre
													+ '</td>'
													+ '<td class="text-center">'
													+ data[item].cUsuarioWeb
													+ '</td>'
													+ '<td class="text-center">'
													+ data[item].ctUsuaCompWeb.cCveCia
													+ '</td>'
													+ '<td class="text-center">'
													+ data[item].cCliente
													+ '</td>'
													+ '<td class="text-center">'
													+ activo
													+ '</td>'
													+ '<td class="text-center"><input type=\"checkbox\" id=\"registro\" name=\"registro\" value="'
													+ contador + '" /></td>'
													+ '</tr>');
							contador++;
						}

					} else {
						swal("No Existen Registros");
					}
				},
				error : function(data, status, error) {
					sweetAlert(
							"Oops...",
							"Algo salio mal intenta mas tarde o contacta a sistemas",
							"error");
				}

			});
}

function add_ctUsuarioWeb() {
	$('#AddCtUsuarioWeb_Dialog').dialog("option", "title", 'Agregar Usuario');
	$('#AddCtUsuarioWeb_Dialog').dialog('open');

}

function edit_ctUsuario(cUsuario) {

	var lista = [];

	$('#registro:checked').each(function() {
		lista.push(arreglo[$(this).val()]);
	});

	if (lista == null || lista == "") {
		swal("Selecciona al menos un registro")
	} else {
		var json = JSON.stringify(lista);

		/*
		 * $.get("UsuarioGet",json, function(result) {
		 * $("#UpdateCtUsuario_Dialog").html(result);
		 * $("#UpdateCtUsuario_Dialog").dialog("option", "title", 'Editar
		 * Usuario'); $("#UpdateCtUsuario_Dialog").dialog('open'); });
		 */

		$
				.ajax({
					type : "GET",
					url : "UsuarioGet",
					dataType : "json",
					contentType : "application/json",
					data : {
						listUsuarios : json
					},
					success : function(data) {

						if (data != null && data != "") {

							$.get("UsuarioModificar", function(result) {
								$("#UpdateCtUsuario_Dialog").html(result);
								$("#UpdateCtUsuario_Dialog").dialog("option",
										"title", 'Editar Usuario');
								$("#UpdateCtUsuario_Dialog").dialog('open');
							});

						} else {
							// swal("Exito!", "Registro Eliminado", "success");
							sweetAlert("Oops...", data, "error");
						}

					},
					error : function(data, status, error) {
						sweetAlert(
								"Oops...",
								"Algo salio mal intenta mas tarde o contacta a sistemas",
								"error");
					}

				});
	}
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
	if (!document.getElementById) {
		return false;
	}
	var fila = document.getElementById(id);
	if (fila.style.display != "none") {
		fila.style.display = "none"; // ocultar fila
	}
}

function busquedaCompania() {

	$
			.ajax({
				type : "GET",
				url : "CompaniaListado",
				dataType : "json",
				contentType : "application/json",
				data : {
					lActivos : "TRUE"
				},
				success : function(data) {

					if (data != "") {

						$('#cCompania option').remove();
						$('#cCompania')
								.append(
										'<option selected=\"selected\">Seleccione una compa&ntilde;ia:</option>');

						for ( var item in data) {
							$('#cCompania').append(
									'<option value="' + data[item].cCveCia
											+ '">' + data[item].cRazonS
											+ '</option>');
						}

					} else {
						swal("No Existen Registros");
					}
				},
				error : function(data, status, error) {
					sweetAlert(
							"Oops...",
							"Algo salio mal intenta mas tarde o contacta a sistemas",
							"error");
				}

			});

}

function busquedaCliente() {
	var cCompania = $('#cCompania').val();

	var fila = document.getElementById("cliente");
	fila.style.display = "";

	$
			.ajax({
				type : "GET",
				url : "ClienteListado",
				dataType : "json",
				contentType : "application/json",
				data : {
					cCveCia : cCompania
				},
				success : function(data) {

					if (data != "") {

						$('#Cliente option').remove();
						$('#Cliente')
								.append(
										'<option selected=\"selected\">Seleccione un cliente:</option>');

						for ( var item in data) {
							$('#Cliente').append(
									'<option value="' + data[item].cCliente+ '">' + data[item].cCliente +'.-'+ data[item].cRazonS + '</option>');
						}

					} else {
						swal("No Existen Registros");
					}
				},
				error : function(data, status, error) {
					sweetAlert(
							"Oops...",
							"Algo salio mal intenta mas tarde o contacta a sistemas",
							"error");
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

function borraRegistro() {

	var lista = [];

	$('#registro:checked').each(function() {
		lista.push(arreglo[$(this).val()]);
	});

	if (lista == null || lista == "") {
		swal("Selecciona al menos un registro")
	} else {
		console.log(lista);
		swal(
				{
					title : "Estas seguro?",
					text : "Si borras el registro no podras recuperarlo!",
					type : "warning",
					showCancelButton : true,
					confirmButtonColor : "#DD6B55",
					confirmButtonText : "Si, Borralo!",
					closeOnConfirm : false
				},
				function() {

					var json = JSON.stringify(lista);

					$
							.ajax({
								type : "GET",
								url : "UsuarioEliminar",
								dataType : "json",
								contentType : "application/json",
								data : {
									listUsuarios : json
								},
								success : function(data) {

									if (data != null && data != "") {

										sweetAlert("Oops...", data, "error");

									} else {
										swal("Exito!", "Registro Eliminado",
												"success");
										location.href = "usuario";
									}

								},
								error : function(data, status, error) {
									sweetAlert(
											"Oops...",
											"Algo salio mal intenta mas tarde o contacta a sistemas",
											"error");
								}

							});
					swal("Deleted!", "Your imaginary file has been deleted.",
							"success");
				});
	}
}

function valida(){
	if($('#cNombre').val() == null || $('#cNombre').val() == ""){
		$('#cNombre').css("box-shadow","0 0 5px #d45252");
		$('#cNombre').css("border-color", "#b03535");
		}else{
			$('#cNombre').css("box-shadow","0 0 5px #5cd053");
			$('#cNombre').css("border-color", "#28921f");
			}
	
	if($('#cUsuarioWeb').val() == null || $('#cUsuarioWeb').val() == ""){
		$('#cUsuarioWeb').css("box-shadow","0 0 5px #d45252");
		$('#cUsuarioWeb').css("border-color", "#b03535");
		}else{
			$('#cUsuarioWeb').css("box-shadow","0 0 5px #5cd053");
			$('#cUsuarioWeb').css("border-color", "#28921f");
			}
			
	if($('#cPassword').val() == null || $('#cPassword').val() == ""){
		$('#cPassword').css("box-shadow","0 0 5px #d45252");
		$('#cPassword').css("border-color", "#b03535");
		}else{
			$('#cPassword').css("box-shadow","0 0 5px #5cd053");
			$('#cPassword').css("border-color", "#28921f");
			}
	
	if($('#cCompania').val() == null || $('#cCompania').val() == ""){
		$('#cCompania').css("box-shadow","0 0 5px #d45252");
		$('#cCompania').css("border-color", "#b03535");
		}else{
			$('#cCompania').css("box-shadow","0 0 5px #5cd053");
			$('#cCompania').css("border-color", "#28921f");
			}
	
	if($('#Cliente').val() == null || $('#Cliente').val() == ""){
		$('#Cliente').css("box-shadow","0 0 5px #d45252");
		$('#Cliente').css("border-color", "#b03535");
		}else{
			$('#Cliente').css("box-shadow","0 0 5px #5cd053");
			$('#Cliente').css("border-color", "#28921f");
			pasar = true;
			}
}

$(document).ready(function() {

	var mensajeError = document.getElementById("mensajeError").innerHTML;
	if (mensajeError != null && mensajeError != "") {
		sweetAlert("Oops...", mensajeError, "error");
	}

	valida();
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
				if(pasar == true){
					$('#Form_ctUsuarioWeb_Add').submit();
				}
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
		dialogClass: "guardar",
		buttons : {
			"Guardar" : function() {
				$('#Form_ctUsuarioWeb_Update').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#Form_ctUsuarioWeb_Update'));

			$(this).dialog('close');
		}
	});
});
