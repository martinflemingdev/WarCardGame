package sandbox;

public class DictionaryWord implements Comparable<DictionaryWord> {

	//instance variables
	private String word;
	private String definition;
	
	//constructor
	
	public DictionaryWord(String word, String defintion) {
		this.word = word;
		this.definition = defintion;
	}
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public String getDefinition() {
		return definition;
	}
	
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	
	@Override 
	public String toString() {
		return word + " - " + definition;
	}

	@Override
	public int compareTo(DictionaryWord o) {
		return this.toString().compareToIgnoreCase(o.toString());
	}


}
