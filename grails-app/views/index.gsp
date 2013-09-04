<%@ page import="evalWeb.Experiment" %>
<%@ page import="evalWeb.Participation" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to EvalWeb</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}

			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
	<body>
		<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<% /* <div id="status" role="complementary">
			<h1>Application Status</h1>
			<ul>
			</ul>
			<h1>Installed Plugins</h1>
			<ul>
			</ul>
		</div> */ %>
		<div class="content" id="welcome" role="main">
			<h1>The Code Readability Experiments</h1>
			<p>
				These experiments measure the perceived level of readability of short code snippets. Upon clicking "Start",
				you will be presented with one of two experiments. The experiment will either be a repeat of a previously conducted 
                                experiment with the purpose for validating or disproving the earlier results. The other possibility is that you will 
				be presented with an experiment which purpose is to measure the relative readability of automatically generated 
				code with manually written code for the network protocol domain.
				You will not be told which of the two experiments you are conducting.
			</p>
			<p>
				Both experiments will present you with 20 code snippets. The code snippets are to be evaluated
				on a scale from 1 to 5 where 5 (closest to the smiley face) represents the most readable code and 1 (closest to the frwony face)
                                is the least readable code. In addition some biographical questions will be asked at the start of the experiment.
			</p>
			<p>
				All results of this study are anonymous. The results will be used to investigate the readability of code and
				analysis of the results may be published in academic literature. In addition, the raw data of the study will
				be made publicly available.
			</p>	
			<p class="centered">
				<%
					def experimentId = -1
					def r = new Random()
					def rnd = r.nextInt(2)
					if(rnd == 0){
						experimentId=6
					}else if(rnd == 1){
						if(Participation.findAllWhere(experiment: Experiment.get(1)).size() < 50){
							experimentId = 1
						}else if(Participation.findAllWhere(experiment: Experiment.get(2)).size() < 50){
							experimentId = 2
						}else if(Participation.findAllWhere(experiment: Experiment.get(3)).size() < 50){
							experimentId =3 
						}else if(Participation.findAllWhere(experiment: Experiment.get(4)).size() < 50){
							experimentId = 4
						}else if(Participation.findAllWhere(experiment: Experiment.get(5)).size() < 50){
							experimentId = 5
						}else {
							experimentId = new Random().nextInt(6) +1
						}

					}
				%>
				<g:link controller="experimentRunner" action="start" id="${experimentId}"> 
				   <input type="button" value="Start" class="button"/> 
				</g:link>
			</p>
		<%/*<ul>
				<g:each in="${Experiment.list()}">
					<li><g:link controller="ExperimentRunner" action="start" id="${it.id}">Run ${it.name}</g:link></li>
				</g:each>
				<li><g:link controller="Experiment">Administer experiment</g:link></li> 
			</ul>
			*/%>
		</div>
	</body>
</html>
