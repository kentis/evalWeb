
<%@ page import="evalWeb.Participation" %>
<%@ page import="evalWeb.Experiment" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'participation.label', default: 'Participation')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-participation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-participation" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${participationInstanceList}" status="i" var="participationInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><g:link action="show" id="${participationInstance.id}">${participationInstance.id}</g:link></td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${participationInstanceTotal}" />
			</div>
		</div>
		<div id="list-participation" class="content scaffold-list" role="main">
			<%
				def experiments = Experiment.list()
			%>
			<g:each in="${experiments}" status="i" var="experimentInstance">
			<h2>${experimentInstance.name}</h2>
			<table>
				<%
					def participations = Participation.findAllWhere(experiment: experimentInstance)  

					def results = [:]
					participations.each { p ->
						p.answers.each{ k,v ->
							if(results.containsKey(k)){
								results[k] << v
							} else {
								results[k] = [v]
							}	
						}
					}
				%>
				<g:each in="${results}" var="k,v">
				<tr>
					<td>${k}</td>
					<g:each in="${v}" var="res">
						<td>${res}</td>
					</g:each>
					<td style="color: red">
						<% def avg = 0
						v.each{ if(it != "skipped") avg += it.toInteger()  }
						if(v.findAll{it != "skipped" }.size() > 0){
						avg = avg / v.findAll{it != "skipped" }.size()}
						else avg= "undefined"%>
						${avg}
					</td>	
				</tr>
				</g:each>
			
				
			</table>
			</g:each>
		
</div>
	</body>
</html>
