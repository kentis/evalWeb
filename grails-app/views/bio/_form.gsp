<%@ page import="evalWeb.Bio" %>



<div class="fieldcontain ${hasErrors(bean: bioInstance, field: 'fields', 'error')} ">
	<label for="fields">
		<g:message code="bio.fields.label" default="Fields" />
		
	</label>
	<g:each in="${bioInstance.fields}">
    		<p>Name: ${it.name}</p>
    		<p>Type: ${it.type}</p>
	</g:each>
	<g:link controller="bioField" action="create" id="${bioInstance.id}">new Field</g:link>
</div>

