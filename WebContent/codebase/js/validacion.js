/**
 * Autor: Estrada Mares Alejandro Fecha: 4 de Julio de 2016 Programa: reporte
 * Descripcion:Se aceptan todo tipo de 
 * validaciones numericas, texto, etc
 */

function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode;
   if (charCode > 31 && (charCode < 48 || charCode > 57))
      return false;

   return true;
}
