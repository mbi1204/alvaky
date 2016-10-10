/**
 * 
 * Autor: Estrada Mares Alejandro
 * Fecha: 10 de Octubre de 2016
 * Programa: incidencias
 * Descripcion: Trae las incidencias para alvaky
 * 
 */

function incidencias (){
	$.ajax({type : "GET",
			url : "incidencias",
			dataType : "json",
			contentType : "application/json",
			data : {
				cCveCia   : cCveCia,
				cCliente  : cCliente,
				cSucursal : cSucursal.sucursal
			},
			success : function(data) {
				
				var cNomSucursal;
				if(data != ""){
					$("#incidencia > tbody").empty();
					for ( var item in data) {
						cNomSucursal = data[item].cNomSuc;
						$('#incidencia > tbody').append('<tr class="text-center">'    +
								 '<td class="text-center">' + data[item].dtFechaV     +   '</td>' +
								 '</tr>');
						}
					document.getElementById("name").innerHTML="Historico de Visitas<br/>"+cNomSucursal+"<br/>Suc. "+cSucursal.sucursal;
					
					}else{
						swal("No Existen Registros");
					}
			},
			error : function(data,status,error) {
				sweetAlert("Oops...", "Algo salio mal intenta mas tarde o contacta a sistemas", "error");
			}
			
		});
}