package evalWeb

import grails.converters.XML
import javax.annotation.Generated

import evalWeb.Participation
	
class ParticipationController {
	def participationControllerService
	 
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def index = {
		
			redirect(action: "list", params: params)
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def list = {
		
		params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
		withFormat{
			html{ 
				return [ participationInstanceList: Participation.list( params ), participationInstanceTotal: Participation.count() ]
			}
			xml{
				render Participation.list() as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def show = {
		
		withFormat{
			html{ 
				return [ participationInstance: Participation.get( params.id )]
			}
			xml{
				render Participation.get(params.id) as XML
			}
		}
		
	}
		
	
}