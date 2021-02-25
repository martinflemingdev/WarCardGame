package sandbox;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {

	//instance variables
	List<DictionaryWord> dictionary; 
	
	public Dictionary() {
		this.dictionary = new ArrayList<>();
	}
	
	public List<DictionaryWord> getDictionary() {
		return dictionary;
	}
	
	public void setDictionary(List<DictionaryWord> newDictionary) {
		this.dictionary = newDictionary;
	}
	
	public void addWord(DictionaryWord word) {
		dictionary.add(word);
	}
	
	public void displayDictionary () {
		System.out.println("***************************************************************");
		for (DictionaryWord word : dictionary) {
			System.out.println();
			System.out.println(word.toString());
		} System.out.println();
		System.out.println("***************************************************************");
	}
	
}
