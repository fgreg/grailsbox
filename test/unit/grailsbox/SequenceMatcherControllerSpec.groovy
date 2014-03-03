package grailsbox

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
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
			controller.match()

			
		then:
			model.sequenceMatch == sequenceMatch
			model.NucleotideSequence == sequence
		
		where:
			sequence = "TAG"
			sequenceMatch = "ATC"
	}
	
	def 'test invalid input ignored'() {
		
				
		given:
			new DnaService().getMatch(sequence) >> sequenceMatch
			controller.params.NucleotideSequence = sequence
		
		
		when:
			controller.match()

			
		then:
			model.sequenceMatch == sequenceMatch
			model.NucleotideSequence == returnedSequence
		
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
			controller.match()
	
			
		then:
			model.sequenceMatch == sequenceMatch
			model.NucleotideSequence == returnedSequence
		
		where:
			sequence = "tag"
			returnedSequence = "TAG"
			sequenceMatch = "ATC"
	}
}
