package evalWeb

class BioControllerService{
	def grailsApplication

	def show(params){
		def retval = [bioInstance: Bio.get(params.id)]
		return retval
	}

	def create(params){
		println "AAAAA"
		def retval = [:]
		def bio = new Bio()
		if (!bio.save()) {
    			bio.errors.allErrors.each {
       				 println it
    			}
		}
		if(params.id){	
			def experiment = Experiment.get(params.id)
			experiment.bio = bio
			experiment.save()
		}
		retval['bioInstance'] = bio
		println Bio.findAll()
		return retval
	}
}
