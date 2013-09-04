
<%@ page import="evalWeb.Experiment" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'experiment.label', default: 'Experiment')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-experiment" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-experiment" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list experiment">
				<g:if test="${experimentInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="experiment.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${experimentInstance}" field="name"/></span>
					
				</li>
				</g:if>
		
				<g:if test="${experimentInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="experiment.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label">${experimentInstance.description}</span>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
                                        <span id="description-label" class="property-label"><g:message code="experiment.randomize.label" default="Randomize" /></span>

                                                <span class="property-value" aria-labelledby="description-label">${experimentInstance.randomize}</span>

                                </li>
				<li class="fieldcontain">
				<g:if test="${experimentInstance?.bio}">
					<span id="bio-label" class="property-label"><g:message code="experiment.bio.label" default="Bio" /></span>
					
						<span class="property-value" aria-labelledby="bio-label"><g:link controller="bio" action="show" id="${experimentInstance?.bio?.id}">${experimentInstance?.bio?.encodeAsHTML()}</g:link></span>
					
								</g:if>

				<g:if test="${! (experimentInstance?.bio)}">
					
					 <span id="bio-label" class="property-label"><g:message code="experiment.bio.label" default="Bio" /></span>
					<span class="property-value" aria-labelledby="bio-label">
						<g:link controller="Bio" action="save" id="${experimentInstance.id}">New Bio</g:link>
					</span>

				</g:if>
			</li>

			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${experimentInstance?.id}" />
					<g:link class="edit" action="edit" id="${experimentInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
