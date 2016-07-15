<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:url var="actionUrl" value="usuarioInsertar" />

<form:form id="Form_ctUsuario_Add" commandName="ctUsuarioWeb" method="POST"
	action="${actionUrl}" class="pure-form pure-form-aligned">

	<fieldset>
		<legend></legend>
		<table>
			<tr>
				<td><form:label path="cUsuarioWeb">
						<spring:message text="Usuario" />
					</form:label></td>
				<td><form:input path="cUsuarioWeb" placeholder="Usuario" size="10"
						maxlength="10" /></td>
			</tr>

			<tr>
				<td><form:label path="cNombre">
						<spring:message text="Nombre" />
					</form:label></td>
				<td><form:input path="cNombre" placeholder="Nombre del Usuario"
						size="80" /></td>
			</tr>

			<tr>
				<td><form:label path="cPassword">
						<spring:message text="Password" />
					</form:label></td>
				<td><form:input path="cPassword" placeholder="Password "
						type="password" size="10" maxlength="10" /></td>
			</tr>
			
			<tr>
				<td><form:label path="iIdPuesto">
						<spring:message text="Puesto" />
					</form:label></td>
				<td><form:select path="iIdPuesto" items="${lista_ctPuesto}"
						itemValue="iIdPuesto" itemLabel="cPuesto" /></td>
			</tr>
		</table>
	</fieldset>
</form:form>