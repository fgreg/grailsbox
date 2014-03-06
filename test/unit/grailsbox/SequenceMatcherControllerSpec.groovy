package grailsbox

import grails.test.mixin.*
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(SequenceMatcherController)
@Mock([DnaService])
class SequenceMatcherControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def 'index action'() {

        when:
        controller.index()

        then:
        response.status == 200
    }
	
	def 'match action'() {

		
		given:
			new DnaService().getMatch(sequence) >> sequenceMatch
			controller.params.NucleotideSequence = sequence
		
		
		when:
			def model = controller.match()

			
		then:
			response.json.sequence == sequence
			response.json.sequenceMatch == sequenceMatch
		
		where:
			sequence = "TAG"
			sequenceMatch = "ATC"
	}
	
	def 'test invalid input ignored'() {
		
				
		given:
			new DnaService().getMatch(sequence) >> sequenceMatch
			controller.params.NucleotideSequence = sequence
		
		
		when:
			def model = controller.match()

			
		then:
			response.json.sequence == returnedSequence
			response.json.sequenceMatch == sequenceMatch
		
		where:
			sequence = "TdviAplG"
			returnedSequence = "TAG"
			sequenceMatch = "ATC"
	}
	
	def 'test input capitalized'(){
		given:
			new DnaService().getMatch(sequence) >> sequenceMatch
			controller.params.NucleotideSequence = sequence
	
	
		when:
			def model = controller.match()
	
			
		then:
			response.json.sequence == returnedSequence
			response.json.sequenceMatch == sequenceMatch
		
		where:
			sequence = "tag"
			returnedSequence = "TAG"
			sequenceMatch = "ATC"
	}
}
