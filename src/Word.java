// Worked on this class with John, Guillermo, and Keeton

public class Word{

	private String _word;
	private int _pos;


	
	public Word(String word, int pos) {
		if(word == null) {
			throw new NullPointerException();
		}
		else if (pos < 0) {
			throw new IllegalArgumentException();
		}
		
		_word = word;
		_pos = pos;

		
	}
	
	public int length() {
		return _word.length();
	}
	
	public String toString() {
		
		return _word;
	}
	
	public Word toLowerCase() {
		
		Word lowerCase = new Word(_word.toLowerCase(), _pos);
		
		return lowerCase;
	}
	
	public int position() {
		return _pos;
	}
	
	public int uniqueChars() {
		_word = _word.toLowerCase();
		String unique = "";
		for(int i =0; i < _word.length(); ++i) {
			if(!unique.contains(String.valueOf(_word.charAt(i)))) {
				unique = unique + _word.charAt(i);
			}
		}
		
		return unique.length();
	}
	
	public boolean equals(Object obj) {

		if(obj == null) {
			return false;
		}
		else if (obj.getClass() != this.getClass()) {
			return false;
		}
		
		Word temp = ((Word)obj);
		temp = temp.toLowerCase();
		
		if(temp.toString().equalsIgnoreCase(this.toString())) {
			return true;
		}
		else
			return false;
		
		
	}
	
	public int hashCode() {
		
		return _word.toLowerCase().hashCode();
	}
}
