package evalWeb

import grails.converters.XML
import javax.annotation.Generated
	
class ExperimentRunnerController {
	def experimentRunnerControllerService
	 
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def start = {
		
			if(experimentRunnerControllerService && (experimentRunnerControllerService.metaClass.pickMethod("start", [Object.class] as Class[]) ||experimentRunnerControllerService.metaClass.pickMethod("start", [Object.class, Object.class] as Class[]) )){
				def result
				if(experimentRunnerControllerService.metaClass.pickMethod("start", [Object.class, Object.class] as Class[])) result = experimentRunnerControllerService.start(params, request)
				else result = experimentRunnerControllerService.start(params)
				if(result instanceof Closure){
                                        return result(this)
                } else {
				    withFormat {
            	    	html { 
            	    		return [result: result]
            			}
           			    xml { render result as XML }
            		}
            	}
			}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def next = {
		
			if(experimentRunnerControllerService && (experimentRunnerControllerService.metaClass.pickMethod("next", [Object.class] as Class[]) ||experimentRunnerControllerService.metaClass.pickMethod("next", [Object.class, Object.class] as Class[]) )){
				def result
				if(experimentRunnerControllerService.metaClass.pickMethod("next", [Object.class, Object.class] as Class[])) result = experimentRunnerControllerService.next(params, request)
				else result = experimentRunnerControllerService.next(params)
				if(result instanceof Closure){
                                        return result(this)
                } else {
				    withFormat {
            	    	html { 
            	    		return [result: result]
            			}
           			    xml { render result as XML }
            		}
            	}
			}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def stop = {
		
			if(experimentRunnerControllerService && (experimentRunnerControllerService.metaClass.pickMethod("stop", [Object.class] as Class[]) ||experimentRunnerControllerService.metaClass.pickMethod("stop", [Object.class, Object.class] as Class[]) )){
				def result
				if(experimentRunnerControllerService.metaClass.pickMethod("stop", [Object.class, Object.class] as Class[])) result = experimentRunnerControllerService.stop(params, request)
				else result = experimentRunnerControllerService.stop(params)
				if(result instanceof Closure){
                                        return result(this)
                } else {
				    withFormat {
            	    	html { 
            	    		return [result: result]
            			}
           			    xml { render result as XML }
            		}
            	}
			}
		
	}
		
	
}