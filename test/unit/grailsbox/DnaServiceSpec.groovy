package grailsbox

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(DnaService)
class DnaServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test simple pair"() {
		
		expect:
		service.getMatch("AACGTGTTTACG") == "TTGCACAAATGC"
		
    }
}
