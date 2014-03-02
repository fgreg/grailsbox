package grailsbox

import grails.transaction.Transactional

@Transactional
class DnaService {

    def getMatch(def nucleotideSequence) {
		return nucleotideSequence.collect{
			switch(it){
				case 'A':
					'T'
					break
				case 'T':
					'A'
					break
				case 'C':
					'G'
					break
				case 'G':
					'C'
					break
			}
		}.join('')
    }
}
