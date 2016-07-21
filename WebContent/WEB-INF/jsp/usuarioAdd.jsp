<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:url var="actionUrl" value="usuarioInsertar" />

<form:form id="Form_ctUsuarioWeb_Add" commandName="ctUsuarioWeb" method="POST"
	action="${actionUrl}" class="pure-form pure-form-aligned">

	<fieldset>
		<legend></legend>
		<table>
			<tr>
				<td><form:label path="cNombre">
						<spring:message text="Nombre" />
					</form:label></td>
				<td><form:input id="cNombre" path="cNombre" placeholder="Nombre del Usuario"
						size="50" class="validar" onblur="valida();"/></td>
			</tr>
			
			<tr>
				<td><form:label path="cUsuarioWeb">
						<spring:message text="Usuario" />
					</form:label></td>
				<td><form:input id="cUsuarioWeb" path="cUsuarioWeb" placeholder="Usuario" size="10" 
						maxlength="10" class="validar" onblur="valida();"/></td>
			</tr>
			
			<tr>
				<td><form:label path="cPassword">
						<spring:message text="Password" />
					</form:label></td>
				<td><form:input id="cPassword" path="cPassword" placeholder="Password "
						type="password" size="10" maxlength="10" class="validar" onblur="valida();"/></td>
			</tr>
			
			<tr>
				<td><form:label path="ctUsuaCompWeb.cCveCia">
						<spring:message text="Compañia" />
					</form:label></td>
				<td><form:select path="ctUsuaCompWeb.cCveCia" id="cCompania" name="cCompania" 
				onchange="busquedaCliente();" class="validar" onblur="valida();"/>
				</td>
			</tr>
			
			<tr id="cliente">
				<td><form:label path="cCliente">
						<spring:message text="Cliente" />
					</form:label></td>
				<td>
					<form:select path="cCliente" id="Cliente" name="Cliente" class="validar" onblur="valida();"/>	  		
				</td>
			</tr>
			
			<tr id="estatus">
				<td><form:label path="lActivo">
						<spring:message text="Estatus"/>
					</form:label></td>
				<td><form:checkbox path="lActivo" id="lActivo" name="lActivo" class="validar"/></td>
			</tr>

		</table>
	</fieldset>
</form:form>