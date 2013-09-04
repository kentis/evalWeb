package evalWeb

import grails.converters.XML
import javax.annotation.Generated

import evalWeb.Experiment
	
class ExperimentController {
	def experimentControllerService
	 
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def index = {
		
			redirect(action: "list", params: params)
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def list = {
		
		params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
		withFormat{
			html{ 
				return [ experimentInstanceList: Experiment.list( params ), experimentInstanceTotal: Experiment.count() ]
			}
			xml{
				render Experiment.list() as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def show = {
		
		withFormat{
			html{ 
				return [ experimentInstance: Experiment.get( params.id )]
			}
			xml{
				render Experiment.get(params.id) as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def delete = {
		
		def experimentInstance = Experiment.get(params.id)
        if (experimentInstance) {
            try {
                experimentInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'experiment.label', default: 'experiment'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'experiment.label', default: 'experiment'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'experiment.label', default: 'experiment'), params.id])}"
            redirect(action: "list")
        }
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def edit = {
		
        def experimentInstance = Experiment.get(params.id)
        if (!experimentInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'experiment.label', default: 'experiment'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [experimentInstance: experimentInstance]
        }
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def update = {
		
		if(experimentControllerService && (experimentControllerService.metaClass.pickMethod("update", [Object.class] as Class[]) || experimentControllerService.metaClass.pickMethod("update", [Object.class, Object.class] as Class[]))){
			def experimentInstance
			def success
			if(experimentControllerService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (experimentInstance, success) = experimentControllerService.update( params, request )
			else (experimentInstance, success) = experimentControllerService.update( params )
			
			withFormat {
				html { render(view: "show", model: [experimentInstance: experimentInstance]) }
                xml { render experimentInstance as XML }
			
			}
		} else {
			def experimentInstance = Experiment.get(params.id)
			if (experimentInstance) {
        	    if (params.version) {
            	    def version = params.version.toLong()
                	if (experimentInstance.version > version) {

                    	experimentInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'experiment.label', default: 'experiment')] as Object[], "Another user has updated this experiment while you were editing")
 	                   render(view: "edit", model: [experimentInstance: experimentInstance])
    	                return
        	        }
            	}
	            experimentInstance.properties = params
    	        if (!experimentInstance.hasErrors() && experimentInstance.save(flush: true)) {
        	        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'experiment.label', default: 'experiment'), experimentInstance.id])}"
            	    withFormat {
            	    	html { 
            	    		render(view: "edit", model: [experimentInstance: experimentInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [experimentInstance: experimentInstance])
            			}
            			xml { render experimentInstance as XML }
            		}
            	}
            	else {
            		withFormat {
            	    	html { 
            	    		render(view: "edit", model: [experimentInstance: experimentInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [experimentInstance: experimentInstance])
            			}
            			xml { render text:"<errors>${flash.message}</errors>", contentType:"text/xml",encoding:"UTF-8" }
            		}
                	
            	}
        	}
        	else {
            	flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'experiment.label', default: 'experiment'), params.id])}"
            	redirect(action: "list")
        	}
        }
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def create = {
		
		def experimentInstance = new Experiment()
		experimentInstance.properties = params
		return [experimentInstance: experimentInstance]
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def save = {
		
		if(experimentControllerService && (experimentControllerService.metaClass.pickMethod("create", [Object.class] as Class[]) || experimentControllerService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] ))){
			def experimentInstance
			def success
			if(experimentControllerService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (experimentInstance, success) = experimentControllerService.create( params, request )
			else (experimentInstance, success) = experimentControllerService.create( params )
			withFormat {
				html { render(view: "show", model: [experimentInstance: experimentInstance]) }
                xml { render experimentInstance as XML }
			
			}
		} else {
			def _params = params.experiment ? params.experiment : params
			
			def experimentInstance = new Experiment(_params)
    	    if (experimentInstance.save(flush: true)) {
        	    flash.message = "${message(code: 'default.created.message', args: [message(code: 'experiment.label', default: ' Experiment'), experimentInstance.id])}"
            	redirect(action: "show", id: experimentInstance.id)
	        }
    	    else {
        	    render(view: "create", model: [experimentInstance: experimentInstance])
	        }
	    }		
		
	}
		
	
}