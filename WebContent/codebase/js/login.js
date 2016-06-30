/**
 * Autor: Estrada Mares Alejandro
 * Fecha: 30 de Junio de 2016
 * Programa: login
 * Descripcion: Valida usuario y contraseña del usuario que desee hacer uso
 * del calendario, la validacion consisten en evitar campos vacios y que
 * correspondan a lo almacenado en la BD
 */

function validarUsuario(){
	
	var cUsuario = $('#cUsuario').val();
	var cPassword = $('#cPassword').val();
	
	if((cUsuario != "Usuario" & cUsuario != "") & (cPassword != "Password" & cPassword != "")){
		$.ajax({
			type : "POST",
			url : "Login",
			dataType : "json",
			contentType : "application/json",
			data : {
				cUsuario : cUsuario,
				cPassword: cPassword
			},
			success : function(data) {
				
			},
			error : function(data,status,error) {
				sweetAlert("Oops...", "Algo salio mal intenta mas tarde o contacta a sistemas", "error");
			}

		});
	}else{
		sweetAlert("Oops...","Verifica que hayas llenado Usuario y Password","error");
	}
}