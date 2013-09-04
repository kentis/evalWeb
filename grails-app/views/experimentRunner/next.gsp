<%@ page import="evalWeb.Experiment" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'experiment.label', default: 'Experiment')}" />
		<script language="javascript">function checkOneSelected(){
				var numSelected = 0
				for (i = 0; i < document.getElementsByName('eval').length; i++) {
			            if (document.getElementsByName('eval')[i].checked) {
					numSelected = numSelected + 1
				    }
				}
				if(numSelected != 1){
					alert("Please select one value.");
				}
				return numSelected == 1
			}
		</script>
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-experiment" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<g:form name="startForm" action="next" id="${result.participation.id}">	

		<div class="nav" role="navigation">
			<ul>
				<li style="valign: right;">${result.snippetNo}/${result.snippetTotal}</li>
			</ul>

			<ul style="float:right; margin-top: -1.5em;">
				<li><g:submitButton value="Skip" style="margin-right: 1em" onclick="return confirm('Are you sure you want to skip this snippet?')"  name="skip"/></li>
				<li><g:submitButton value="Finish" style=""  onclick="return confirm('Are you sure you want to end the experiment?')"  name="stop"/></li>

			</ul>
		</div>
		<div id="iwelcome-experiment" class="content" role="main">
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<div style="line-height:0em;">
			${result.snippet}
			</div>
				<p>
				</p>
				<div id="radiop">
					<ul class="radiolist">
				<li style="display: inline; list-style-type: none;">
				<g:img style="max-height: 1em;" dir="images" file="bad.svg" />
				</li>


						<g:radioGroup name="eval"  labels="[1,2,3,4,5]"  values="[1,2,3,4,5]" value=" " >
						<li style="display: inline; list-style-type: none; ">
						<label class="radiolabel"> 
						${it.radio}<br/>${it.label}
						</label>
						</li>
					</g:radioGroup>
				<li style="display: inline; list-style-type: none; ">
				<g:img style="max-height: 1em;" dir="images" file="good.svg"/>
				</li>

					</ul></div>
				<g:hiddenField name="snippetName" value="${result.snippetName}" />
				<g:submitButton style="float:right;margin-right: 5em;" value="Next" name="next" onClick="return checkOneSelected()" />
				<br/>
				<br/>
			</g:form>
		</div>
	</body>
</html>
