package grailsbox

class SequenceMatcherController {

	DnaService dnaService
	
    def index() {
		render(view: "matcher", model: [])
	}
	
	def match(){
		
		def match = dnaService.getMatch(params.NucleotideSequence)
		
		render(view: "matcher", model: [sequenceMatch:match, NucleotideSequence:params.NucleotideSequence])
	}
}
