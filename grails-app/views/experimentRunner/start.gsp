
<%@ page import="evalWeb.Experiment" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'experiment.label', default: 'Experiment')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-experiment" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
			</ul>
		</div>
		<div id="iwelcome-experiment" class="content" role="main">
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<p>${result.experiment?.description}</p>
			<g:form name="startForm" action="next" id="${result.participation.id}">
				<table class="bio">
					<g:each in="${result.fields}" var="bf" status="i">
					<tr>
						<td>${bf[0]}</td>
						<td>${bf[1]}</td>
					</tr>
					</g:each>
				</table>
				<g:hiddenField name="first" value="true"/>
				<g:submitButton value="Start" name="start" />
			</g:form>
		</div>
	</body>
</html>
