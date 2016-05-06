/**
 * Autor: Estrada Mares Alejandro
 * Fecha: 18 de Abril de 2016
 * Programa: reporte
 * Descripcion: Genera las consultas sobre las tiendas y su historial
 * de reportes ejecutivos de 6 meses atras dependiendo de la fecha actual
 * 
 * NOTA: Encabezados 2 filas y 25 renglones
 */

function abrir_Reporte(){
	
	var cSucursal = getGET();
	
	$.ajax({
		type : "GET",
		url : "reporteEjecutivo",
		dataType : "json",
		contentType : "application/json",
		data : {
			cSucursal : cSucursal.sucursal
		},
		success : function(data) {
			
			if(data != ""){
				$("#reporteEje > tbody").empty();
				for ( var item in data) {
					$('#reporteEje > tbody').append('<tr class="text-center">'    +
							 '<td class="text-center">' + data[item].dtFechaV     +   '</td>' +
							 '<td class="text-center">' + data[item].deCloroEnt   +   '</td>' + 
							 '<td class="text-center">'	+ data[item].dePHEnt      +   '</td>' +
							 '<td class="text-center">'	+ data[item].deDurEnt     +   '</td>' +
							 '<td class="text-center">'	+ data[item].deSTDEnt     +   '</td>' +
							 '<td class="text-center">'	+ data[item].deCloroFilt  +   '</td>' +
							 '<td class="text-center">'	+ data[item].dePHFilt     +   '</td>' +
							 '<td class="text-center">'	+ data[item].deDurFilt    +   '</td>' +
							 '<td class="text-center">'	+ data[item].deSTDFilt    +   '</td>' +
							 '<td class="text-center">'	+ data[item].deCloroUV    +   '</td>' +
							 '<td class="text-center">'	+ data[item].dePHUV       +   '</td>' +
							 '<td class="text-center">'	+ data[item].deDurUV      +   '</td>' +
							 '<td class="text-center">'	+ data[item].deSTDUV      +   '</td>' +
							 '<td class="text-center">'	+ data[item].deAlcUV      +   '</td>' +
							 '<td class="text-center">'	+ data[item].deConsSed    +   '</td>' +
							 '<td class="text-center">'	+ data[item].deConsSal    +   '</td>' +
							 '<td class="text-center">'	+ data[item].deConsCarb   +   '</td>' +
							 '<td class="text-center">'	+ data[item].deConsSalP   +   '</td>' +
							 '<td class="text-center">'	+ data[item].cOtRefacc    +   '</td>' +
							 '<td class="text-center">'	+ data[item].deORCant     +   '</td>' +
							 '<td class="text-center">'	+ data[item].cAcciones    +   '</td>' +
							 '<td class="text-center">'	+ data[item].cRecomienda  +   '</td>' +
							 '<td class="text-center">'	+ data[item].cHoraEntrada +   '</td>' +
							 '<td class="text-center">'	+ data[item].cHoraSalida  +   '</td>' +
							 '<td class="text-center">'	+ data[item].cTiempoTot   +   '</td>' +'</tr>');
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

function getGET(){
	
	   var loc = document.location.href;
	   var getString = loc.split('?')[1];
	   var GET = getString.split('&');
	   var get = {};//this object will be filled with the key-value pairs and returned.

	   for(var i = 0, l = GET.length; i < l; i++){
	      var tmp = GET[i].split('=');
	      get[tmp[0]] = unescape(decodeURI(tmp[1]));
	   }
	   
	   return get;
}

function fecha(){
	
	var fecha = new Date();
	var primerDia = new Date(fecha.getFullYear(), fecha.getMonth(), 1);
	var ultimoDia = new Date(fecha.getFullYear(), fecha.getMonth() + 1, 0);
	
	alert(primerDia);
	alert(ultimoDia);
	
	for(valor = 0; valor < 6; valor++){
		alert(fecha.getMonth() - valor);
		if(fecha.getMonth() - valor < 0){
			console.log(fecha.getFullYear()-1);
			console.log(12+(fecha.getMonth() - valor));
		}
	}
}

function pdf(){
	
	var cSucursal = getGET();
	
	window.open("downloadPDF?sucursal="+cSucursal.sucursal);
}