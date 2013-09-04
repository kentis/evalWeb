import evalWeb.*
class BootStrap {

    def init = { servletContext ->
	if(!Experiment.get(1)){
		/*def e = new Experiment(name:"Buse-Weimer repeat", description: "<p>This experiment messures the relative quality of code.</p>", randomized: true, snippetsDir: "1")
	
		def bio = new Bio()
		e.bio = bio

		def f = new BioField(name:"How long have you been working as a Software developer?", type: "(String)")
		bio.fields = [f]
		f.save()
		bio.save()
		e.save()


		def eNr = new Experiment(name:"Buse-Weimer repeat Non-random", description: "<p>This experiment messures the relative quality of code.</p>", randomized: false, snippetsDir: "1")
		def bioNr = new Bio()
		eNr.bio = bioNr
		bioNr.fields = []
		bioNr.fields << new BioField(name:"What is your occupation?", type: "(select (programmer student academic other))", sortAs: 1)
		bioNr.fields << new BioField(name:"If other please specify", type: "(String)", sortAs: 2)	
		bioNr.fields << new BioField(name:"How many years have you been working as a Software developer?", type: "(select (n/a 0-5 5-10 10-20 20+))", sortAs: 3)
		bioNr.fields << new BioField(name:"How many years have you been working with Java?", type: "(select (n/a 0-5 5-10 10-20 20+))", sortAs: 4)
		bioNr.fields << new BioField(name:"What is your highest achieved higher education degree?", type: "(select (None Bachelor Master PhD))", sortAs: 5)

	
		bioNr.fields.each{ it.save() }
		bioNr.save()
		eNr.save()

		def e2 = new Experiment(name:"Buse-Weimer repeat 10", description: "<p>This experiment messures the relative quality of code.</p>", randomized: true, snippetsDir: "2")

        	def bio2 = new Bio()
	        e2.bio = bio2

        	def f2 = new BioField(name:"How long have you been working as a Software developer?", type: "(String)")
	        bio2.fields = [f2]
        	f2.save()
	        bio2.save()
        	e2.save()
		*/

		def eb1 = new Experiment(name:"Buse-Weimer 1-20", description: "", randomize: true, snippetsDir: "buse1")
		def biob1 = new Bio()
		eb1.bio = biob1
		biob1.fields = []
		biob1.fields << new BioField(name:"What is your occupation?", type: "(select (programmer student academic other))", sortAs: 1)
		biob1.fields << new BioField(name:"If other please specify", type: "(String)", sortAs: 2)	
		biob1.fields << new BioField(name:"How many years have you been working as a Software developer?", type: "(select (n/a 0-5 5-10 10-20 20+))", sortAs: 3)
		biob1.fields << new BioField(name:"How many years have you been working with Java?", type: "(select (n/a 0-5 5-10 10-20 20+))", sortAs: 4)
		biob1.fields << new BioField(name:"What is your highest achieved higher education degree?", type: "(select (None Bachelor Master PhD))", sortAs: 5)

	
		biob1.fields.each{ it.save() }
		biob1.save()
		eb1.save()

		def eb2 = new Experiment(name:"Buse-Weimer 20-40", description: "", randomize: true, snippetsDir: "buse2")
		def biob2 = new Bio()
		eb2.bio = biob2
		biob2.fields = []
		biob2.fields << new BioField(name:"What is your occupation?", type: "(select (programmer student academic other))", sortAs: 1)
		biob2.fields << new BioField(name:"If other please specify", type: "(String)", sortAs: 2)	
		biob2.fields << new BioField(name:"How many years have you been working as a Software developer?", type: "(select (n/a 0-5 5-10 10-20 20+))", sortAs: 3)
		biob2.fields << new BioField(name:"How many years have you been working with Java?", type: "(select (n/a 0-5 5-10 10-20 20+))", sortAs: 4)
		biob2.fields << new BioField(name:"What is your highest achieved higher education degree?", type: "(select (None Bachelor Master PhD))", sortAs: 5)

	
		biob2.fields.each{ it.save() }
		biob2.save()
		eb2.save()

		def eb3 = new Experiment(name:"Buse-Weimer 40-60", description: "", randomize: true, snippetsDir: "buse3")
		def biob3 = new Bio()
		eb3.bio = biob3
		biob3.fields = []
		biob3.fields << new BioField(name:"What is your occupation?", type: "(select (programmer student academic other))", sortAs: 1)
		biob3.fields << new BioField(name:"If other please specify", type: "(String)", sortAs: 2)	
		biob3.fields << new BioField(name:"How many years have you been working as a Software developer?", type: "(select (n/a 0-5 5-10 10-20 20+))", sortAs: 3)
		biob3.fields << new BioField(name:"How many years have you been working with Java?", type: "(select (n/a 0-5 5-10 10-20 20+))", sortAs: 4)
		biob3.fields << new BioField(name:"What is your highest achieved higher education degree?", type: "(select (None Bachelor Master PhD))", sortAs: 5)

	
		biob3.fields.each{ it.save() }
		biob3.save()
		eb3.save()

		def eb4 = new Experiment(name:"Buse-Weimer repeat 60-80", description: "", randomize: true, snippetsDir: "buse4")
		def biob4 = new Bio()
		eb4.bio = biob4
		biob4.fields = []
		biob4.fields << new BioField(name:"What is your occupation?", type: "(select (programmer student academic other))", sortAs: 1)
		biob4.fields << new BioField(name:"If other please specify", type: "(String)", sortAs: 2)	
		biob4.fields << new BioField(name:"How many years have you been working as a Software developer?", type: "(select (n/a 0-5 5-10 10-20 20+))", sortAs: 3)
		biob4.fields << new BioField(name:"How many years have you been working with Java?", type: "(select (n/a 0-5 5-10 10-20 20+))", sortAs: 4)
		biob4.fields << new BioField(name:"What is your highest achieved higher education degree?", type: "(select (None Bachelor Master PhD))", sortAs: 5)

	
		biob4.fields.each{ it.save() }
		biob4.save()
		eb4.save()


		def eb5 = new Experiment(name:"Buse-Weimer repeat 60-80", description: "", randomize: true, snippetsDir: "buse5")
		def biob5 = new Bio()
		eb5.bio = biob5
		biob5.fields = []
		biob5.fields << new BioField(name:"What is your occupation?", type: "(select (programmer student academic other))", sortAs: 1)
		biob5.fields << new BioField(name:"If other please specify", type: "(String)", sortAs: 2)	
		biob5.fields << new BioField(name:"How many years have you been working as a Software developer?", type: "(select (n/a 0-5 5-10 10-20 20+))", sortAs: 3)
		biob5.fields << new BioField(name:"How many years have you been working with Java?", type: "(select (n/a 0-5 5-10 10-20 20+))", sortAs: 4)
		biob5.fields << new BioField(name:"What is your highest achieved higher education degree?", type: "(select (None Bachelor Master PhD))", sortAs: 5)

	
		biob5.fields.each{ it.save() }
		biob5.save()
		eb5.save()



		
		def e3 = new Experiment(name:"PetriCode Eval", description: "", randomize: true, snippetsDir: "pcEval")
		def bio3 = new Bio()
	        e3.bio = bio3
		bio3.fields = []
		bio3.fields << new BioField(name:"What is your occupation?", type: "(select (programmer student academic other))", sortAs: 1)
                bio3.fields << new BioField(name:"If other please specify", type: "(String)", sortAs: 2)
                bio3.fields << new BioField(name:"How many years have you been working as a Software developer?", type: "(select (n/a 0-5 5-10 10-20 20+))", sortAs: 3)
                bio3.fields << new BioField(name:"How many years have you been working with Java?", type: "(select (n/a 0-5 5-10 10-20 20+))", sortAs: 4)
                bio3.fields << new BioField(name:"What is your highest achieved higher education degree?", type: "(select (None Bachelor Master PhD))", sortAs: 5)
                
                
                bio3.fields.each{ it.save() }
		bio3.save()
		e3.save()

    	}
    }
    def destroy = {
    }
}
