package evalWeb

import grails.converters.XML
import javax.annotation.Generated
	
class ExportController {
	def exportControllerService
	 
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def exp = {
		
			if(exportControllerService && (exportControllerService.metaClass.pickMethod("exp", [Object.class] as Class[]) ||exportControllerService.metaClass.pickMethod("exp", [Object.class, Object.class] as Class[]) )){
				def result
				if(exportControllerService.metaClass.pickMethod("exp", [Object.class, Object.class] as Class[])) result = exportControllerService.exp(params, request)
				else result = exportControllerService.exp(params)
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