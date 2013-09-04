package evalWeb

import grails.converters.XML
import javax.annotation.Generated

import evalWeb.Bio
	
class BioController {
	def bioControllerService
	 
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def index = {
		
			redirect(action: "list", params: params)
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def list = {
		
		params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
		withFormat{
			html{ 
				return [ bioInstanceList: Bio.list( params ), bioInstanceTotal: Bio.count() ]
			}
			xml{
				render Bio.list() as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def show = {
		
		withFormat{
			html{ 
				return [ bioInstance: Bio.get( params.id )]
			}
			xml{
				render Bio.get(params.id) as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def delete = {
		
		def bioInstance = Bio.get(params.id)
        if (bioInstance) {
            try {
                bioInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'bio.label', default: 'bio'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'bio.label', default: 'bio'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'bio.label', default: 'bio'), params.id])}"
            redirect(action: "list")
        }
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def edit = {
		
        def bioInstance = Bio.get(params.id)
        if (!bioInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'bio.label', default: 'bio'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [bioInstance: bioInstance]
        }
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def update = {
		
		if(bioControllerService && (bioControllerService.metaClass.pickMethod("update", [Object.class] as Class[]) || bioControllerService.metaClass.pickMethod("update", [Object.class, Object.class] as Class[]))){
			def bioInstance
			def success
			if(bioControllerService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (bioInstance, success) = bioControllerService.update( params, request )
			else (bioInstance, success) = bioControllerService.update( params )
			
			withFormat {
				html { render(view: "show", model: [bioInstance: bioInstance]) }
                xml { render bioInstance as XML }
			
			}
		} else {
			def bioInstance = Bio.get(params.id)
			if (bioInstance) {
        	    if (params.version) {
            	    def version = params.version.toLong()
                	if (bioInstance.version > version) {

                    	bioInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'bio.label', default: 'bio')] as Object[], "Another user has updated this bio while you were editing")
 	                   render(view: "edit", model: [bioInstance: bioInstance])
    	                return
        	        }
            	}
	            bioInstance.properties = params
    	        if (!bioInstance.hasErrors() && bioInstance.save(flush: true)) {
        	        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'bio.label', default: 'bio'), bioInstance.id])}"
            	    withFormat {
            	    	html { 
            	    		render(view: "edit", model: [bioInstance: bioInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [bioInstance: bioInstance])
            			}
            			xml { render bioInstance as XML }
            		}
            	}
            	else {
            		withFormat {
            	    	html { 
            	    		render(view: "edit", model: [bioInstance: bioInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [bioInstance: bioInstance])
            			}
            			xml { render text:"<errors>${flash.message}</errors>", contentType:"text/xml",encoding:"UTF-8" }
            		}
                	
            	}
        	}
        	else {
            	flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'bio.label', default: 'bio'), params.id])}"
            	redirect(action: "list")
        	}
        }
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def create = {
		
		def bioInstance = new Bio()
		bioInstance.properties = params
		return [bioInstance: bioInstance]
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def save = {
		
		if(bioControllerService && (bioControllerService.metaClass.pickMethod("create", [Object.class] as Class[]) || bioControllerService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] ))){
			def bioInstance
			def success
			if(bioControllerService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (bioInstance, success) = bioControllerService.create( params, request )
			else (bioInstance, success) = bioControllerService.create( params )
			withFormat {
				html { render(view: "show", model: [bioInstance: bioInstance]) }
                xml { render bioInstance as XML }
			
			}
		} else {
			def _params = params.bio ? params.bio : params
			
			def bioInstance = new Bio(_params)
    	    if (bioInstance.save(flush: true)) {
        	    flash.message = "${message(code: 'default.created.message', args: [message(code: 'bio.label', default: ' Bio'), bioInstance.id])}"
            	redirect(action: "show", id: bioInstance.id)
	        }
    	    else {
        	    render(view: "create", model: [bioInstance: bioInstance])
	        }
	    }		
		
	}
		
	
}