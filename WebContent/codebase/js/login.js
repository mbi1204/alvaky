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
		$('#form_Login').submit();
	}else{
		sweetAlert("Oops...","Verifica que hayas llenado Usuario y Password","error");
	}
}

function validarUsuarioEnter(e){
	if (e.keyCode == 13) {
        validarUsuario();
    }
}