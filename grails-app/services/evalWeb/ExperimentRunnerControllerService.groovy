package evalWeb
import org.codehaus.groovy.grails.web.util.WebUtils
import org.k1s.GrSexp.GrSexp

class ExperimentRunnerControllerService{
	def grailsApplication
	def start(params){
		def retval = [:]

		retval['experiment'] = evalWeb.Experiment.get(params.id)
		def p = new evalWeb.Participation(experiment: retval.experiment)
		p.startTime = new Date()
		p.save()
		retval['participation'] = p
		
		def fields = []
		
		retval['experiment'].bio.fields.sort{ bf -> bf.sortAs  }.each{ bf ->
			def field = FieldHelper.codeForSExp(bf.type, bf.id)
			fields << [bf.name, field]
		}
		retval['fields'] = fields
		log.info("starting experiment: ${retval['experiment'].id}")
		return retval
	}

	def next(params){
		def session = WebUtils.retrieveGrailsWebRequest().getSession()
		def p = Participation.get(params.id)
		
		if(params.first == "true"){
			p.firstSnippetStart = new Date()
			session.snippets = [:]
			session.answerTimes = [:]
			def ba = new BioAnswers(answers: [:])
			params.each{k,v ->
				if(k.startsWith("bioField")){
					//println "k: $k"
					ba.answers[k] = v
					
				}
			}
			//println "recording bio: ${ba.answers}"
			p.bioAnswers = ba
			ba.save()
			p.save()
			//println "p.bioAnswers.answers: ${p.bioAnswers.answers}"

		}else{
			if((params.snippetName == null || params.eval == null) && params.next == "Next"){
				throw new RuntimeException("params.snippetName: ${params.snippetName}, params.eval: ${params.eval}");
			}else if(params.skip == "Skip"){
				session.snippets[params.snippetName] = "skipped"
				session.answerTimes[params.snippetName] = new Date()
			}else if(params.snippetName != null && params.eval != null){
				session.snippets[params.snippetName] = params.eval
				session.answerTimes[params.snippetName] = new Date()
			} 
			
		}
	
	
		def allSnippets = grailsApplication.mainContext.getResource("/WEB-INF/snippets/${p.experiment.snippetsDir}/").file.listFiles()
		def snippetTotal = allSnippets.size()
		//allSnippets = (allSnippets as List)*.toString()
		allSnippets = allSnippets - session.snippets.keySet()
		def alls = []
		allSnippets.each{
			if(! session.snippets.keySet().contains(it.toString())) alls << it
		}
		allSnippets = alls
		//println "allsnippets reduced: $allSnippets"
		//println "removed ${session.snippets.keySet()}"
		if(params.stop == "Finish" || allSnippets.size() == 0){
			//stop
			def retval = { ctrl -> ctrl.redirect(action:"stop", params: params)}
			return retval
		}	
	

		def random = new Random();
		def retval = [:]
		retval.participation = p
		
		//println "ddaaadfsfsdfdsFSDAFDSAFASDFasdfasd"
		//println params
		//println grailsApplication.mainContext.getResource('/WEB-INF/resources').file
		allSnippets = allSnippets.sort{
			def idx = it.toString().substring(it.toString().lastIndexOf('/')+1)
			idx = idx.substring(0,idx.indexOf('.'))
			return idx.toInteger()
		}
	
		//println p.experiment
		//println p.experiment.randomize
		if(p.experiment.randomize){	
			//println "getting random snippet"
			retval.snippetName = allSnippets[random.nextInt(allSnippets.size())]
			retval.snippet = retval.snippetName.text
			retval.snippetName = retval.snippetName.toString()
		}else{
			//println "getting non-random snippet"
			retval.snippetName = allSnippets[0]
                        retval.snippet = retval.snippetName.text
                        retval.snippetName = retval.snippetName.toString()
		}
		//retval.snippet = grailsApplication.mainContext.getResource("/WEB-INF/snippets/${p.experiment.id}/").file.listFiles().toString()
		//retval.snippet += "<br/> "+p.toString()
		//println getResource("/").getFile().toString()
		retval['snippetTotal'] = snippetTotal
		retval['snippetNo'] = snippetTotal - allSnippets.size() + 1
		return retval
	}
	
			

	def stop(params){
		//println "stopping"
		//println params
		def session = WebUtils.retrieveGrailsWebRequest().getSession()
		def part = Participation.get(params.id)
		//println "stopping 2"
		
		part.answers = session.snippets
		def answersTimes = [:]
		session.answerTimes.keySet().each{
			answersTimes[it] = session.answerTimes[it].toString()
		}
		part.answersTimes = answersTimes
		session.snippets = null
		session.answerTimes = null
		part.stopTime = new Date()
		part.save()
		//println "stopping 4"
		//println "${[part: part, experiment: part.experiment]}"
		//println "stopping 5"
		log.info "finished experiment: ${part.experiment.id}"
		return [part: part, experiment: part.experiment]
	}
}
