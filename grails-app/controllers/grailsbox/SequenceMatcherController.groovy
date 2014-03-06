package grailsbox

import grails.converters.JSON

class SequenceMatcherController {

	DnaService dnaService
	
    def index() {
		render(view: "matcher", model: [])
	}
	
	def match(){
		
		def seq = params.NucleotideSequence.toUpperCase().toCharArray() as List
		seq.retainAll(Nucleotide.values().collect(){it.code}.toArray())
		seq = seq.join("")
		
		def match = dnaService.getMatch(seq)
		
		render ([sequence:seq, sequenceMatch:match] as JSON)
	}
	
}
