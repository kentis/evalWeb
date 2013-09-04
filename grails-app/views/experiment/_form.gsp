<%@ page import="evalWeb.Experiment" %>



<div class="fieldcontain ${hasErrors(bean: experimentInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="experiment.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${experimentInstance?.name}"/>
</div>


<div class="fieldcontain ${hasErrors(bean: experimentInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="experiment.description.label" default="Description" />
		
	</label>
	<g:textArea name="description" value="${experimentInstance?.description}"/>
</div>
<% /*<div class="fieldcontain ${hasErrors(bean: experimentInstance, field: 'snippets', 'error')} ">
	<label for="snippets">
		<g:message code="experiment.snippets.label" default="Snippets" />
		
	</label>
	<g:select name="snippets" from="${evalWeb.Snippet.list()}" multiple="multiple" optionKey="id" size="5" value="${experimentInstance?.snippets*.id}" class="many-to-many"/>
</div>*/%>

<div class="fieldcontain ${hasErrors(bean: experimentInstance, field: 'bio', 'error')} ">
	<label for="bio">
		<g:message code="experiment.bio.label" default="Bio" />
		
	</label>
	<g:select id="bio" name="bio.id" from="${evalWeb.Bio.list()}" optionKey="id" value="${experimentInstance?.bio?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

