<%@ page import="evalWeb.BioField" %>



<div class="fieldcontain ${hasErrors(bean: bioFieldInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="bioField.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${bioFieldInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bioFieldInstance, field: 'type', 'error')} ">
	<label for="type">
		<g:message code="bioField.type.label" default="Type" />
		
	</label>
	<g:textField name="type" value="${bioFieldInstance?.type}"/>
</div>

