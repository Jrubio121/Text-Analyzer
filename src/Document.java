// Worked on this class with John, Guillermo, and Keeton

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Document {


	private List<Sentence> _document = new ArrayList<Sentence>();
	private String _documentStr;
	private Map<Word, Integer> _wordFreq;
	
	public Document(String document) {
		
		if(document == null) {
			throw new NullPointerException();
		}
		
		_documentStr = document;
		String[] temp = document.split("\\.");
		for(int i = 0; i < temp.length; ++i) {
			_document.add(new Sentence(temp[i],i));
		}
		
		_wordFreq = wordFrequency();
	}
	
	public int length() {
		return _document.size();
	}
	
	public String toString() {
		return _documentStr;
	}
	
	public int getNumWords() {
		int words = 0;
		for(int i =0; i < _document.size(); ++i) {
			String[] temp = _document.get(i).toString().split(" ");
			words += temp.length;
		}
		
		return words;
	}
	
	public Sentence get(int idx) {
		if(idx < 0 || idx >= _document.size()) {
			throw new IndexOutOfBoundsException();
		}
		
		return _document.get(idx);
	}
	
	public Map<Word, Integer> wordFrequency(){
		
		Sentence full = new Sentence(_documentStr.replace('.', ' '),0);
		return full.wordFrequency();
		}
	
	

}
