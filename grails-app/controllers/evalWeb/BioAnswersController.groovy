package evalWeb

import grails.converters.XML
import javax.annotation.Generated

import evalWeb.BioAnswers
	
class BioAnswersController {
	def bioAnswersControllerService
	 
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def index = {
		
			redirect(action: "list", params: params)
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def list = {
		
		params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
		withFormat{
			html{ 
				return [ bioAnswersInstanceList: BioAnswers.list( params ), bioAnswersInstanceTotal: BioAnswers.count() ]
			}
			xml{
				render BioAnswers.list() as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def show = {
		
		withFormat{
			html{ 
				return [ bioAnswersInstance: BioAnswers.get( params.id )]
			}
			xml{
				render BioAnswers.get(params.id) as XML
			}
		}
		
	}
		
	
}