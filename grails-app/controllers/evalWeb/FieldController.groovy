package evalWeb

import grails.converters.XML
import javax.annotation.Generated

import evalWeb.BioField
	
class FieldController {
	def fieldControllerService
	 
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def index = {
		
			redirect(action: "list", params: params)
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def list = {
		
		params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
		withFormat{
			html{ 
				return [ bioFieldInstanceList: BioField.list( params ), bioFieldInstanceTotal: BioField.count() ]
			}
			xml{
				render BioField.list() as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def show = {
		
		withFormat{
			html{ 
				return [ bioFieldInstance: BioField.get( params.id )]
			}
			xml{
				render BioField.get(params.id) as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def delete = {
		
		def bioFieldInstance = BioField.get(params.id)
        if (bioFieldInstance) {
            try {
                bioFieldInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'bioField.label', default: 'bioField'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'bioField.label', default: 'bioField'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'bioField.label', default: 'bioField'), params.id])}"
            redirect(action: "list")
        }
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def edit = {
		
        def bioFieldInstance = BioField.get(params.id)
        if (!bioFieldInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'bioField.label', default: 'bioField'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [bioFieldInstance: bioFieldInstance]
        }
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def update = {
		
		if(fieldControllerService && (fieldControllerService.metaClass.pickMethod("update", [Object.class] as Class[]) || fieldControllerService.metaClass.pickMethod("update", [Object.class, Object.class] as Class[]))){
			def bioFieldInstance
			def success
			if(fieldControllerService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (bioFieldInstance, success) = fieldControllerService.update( params, request )
			else (bioFieldInstance, success) = fieldControllerService.update( params )
			
			withFormat {
				html { render(view: "show", model: [bioFieldInstance: bioFieldInstance]) }
                xml { render bioFieldInstance as XML }
			
			}
		} else {
			def bioFieldInstance = BioField.get(params.id)
			if (bioFieldInstance) {
        	    if (params.version) {
            	    def version = params.version.toLong()
                	if (bioFieldInstance.version > version) {

                    	bioFieldInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'bioField.label', default: 'bioField')] as Object[], "Another user has updated this bioField while you were editing")
 	                   render(view: "edit", model: [bioFieldInstance: bioFieldInstance])
    	                return
        	        }
            	}
	            bioFieldInstance.properties = params
    	        if (!bioFieldInstance.hasErrors() && bioFieldInstance.save(flush: true)) {
        	        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'bioField.label', default: 'bioField'), bioFieldInstance.id])}"
            	    withFormat {
            	    	html { 
            	    		render(view: "edit", model: [bioFieldInstance: bioFieldInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [bioFieldInstance: bioFieldInstance])
            			}
            			xml { render bioFieldInstance as XML }
            		}
            	}
            	else {
            		withFormat {
            	    	html { 
            	    		render(view: "edit", model: [bioFieldInstance: bioFieldInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [bioFieldInstance: bioFieldInstance])
            			}
            			xml { render text:"<errors>${flash.message}</errors>", contentType:"text/xml",encoding:"UTF-8" }
            		}
                	
            	}
        	}
        	else {
            	flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'bioField.label', default: 'bioField'), params.id])}"
            	redirect(action: "list")
        	}
        }
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def create = {
		
		def bioFieldInstance = new BioField()
		bioFieldInstance.properties = params
		return [bioFieldInstance: bioFieldInstance]
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def save = {
		
		if(fieldControllerService && (fieldControllerService.metaClass.pickMethod("create", [Object.class] as Class[]) || fieldControllerService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] ))){
			def bioFieldInstance
			def success
			if(fieldControllerService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (bioFieldInstance, success) = fieldControllerService.create( params, request )
			else (bioFieldInstance, success) = fieldControllerService.create( params )
			withFormat {
				html { render(view: "show", model: [bioFieldInstance: bioFieldInstance]) }
                xml { render bioFieldInstance as XML }
			
			}
		} else {
			def _params = params.bioField ? params.bioField : params
			
			def bioFieldInstance = new BioField(_params)
    	    if (bioFieldInstance.save(flush: true)) {
        	    flash.message = "${message(code: 'default.created.message', args: [message(code: 'bioField.label', default: ' BioField'), bioFieldInstance.id])}"
            	redirect(action: "show", id: bioFieldInstance.id)
	        }
    	    else {
        	    render(view: "create", model: [bioFieldInstance: bioFieldInstance])
	        }
	    }		
		
	}
		
	
}