package evalWeb

class BioFieldControllerService{
	def grailsApplication

	def create(params){
		println "BB"
		def retval = [:]
		def bioField = new BioField()
		bioField.name = params.name
		bioField.type = params.type
		if (!bioField.save()) {
    			bioField.errors.allErrors.each {
       				 println it
    			}
		}
		println params
		if(params.bioId){	
			def bio = Bio.get(params.bioId)
			bio.fields << bioField
			bio.save()
		}
		retval['bioFieldInstance'] = bioField
		println "$bioField"
		return retval
	}
}
