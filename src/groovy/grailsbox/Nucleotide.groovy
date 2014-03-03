package grailsbox

public enum Nucleotide {
	ADENINE("A"), THYMINE("T"),	CYTOSINE("C"),	GUANINE("G")
	
	Nucleotide(String code){
		this.code = code
	}
	
	private final char code;
	public char code(){return code}
}