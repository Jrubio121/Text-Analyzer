// Worked on this class with John, Guillermo, and Keeton


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Sentence {


	private ArrayList<Word> _sentence = new ArrayList<Word>();
	private int _pos;
	private String _sentenceStr;
	private Map<Word, Integer> wordFreq;
	
	public Sentence(String sentence, int pos) {
		
		if(sentence == null) {
			throw new NullPointerException();
		}
		if (_pos < 0) {
			throw new IllegalArgumentException();
		}
		
		_sentenceStr = sentence;
		_pos = pos;
		
		String[] temp = _sentenceStr.split(" ");
		for(int i = 0; i < temp.length; ++i) {
			_sentence.add(new Word(temp[i],pos));
		}
		
		wordFreq = wordFrequency();
	}
	
	public int length() {
		return _sentence.size();
		
	}
	
	public String toString() {
		return _sentenceStr;
	}
	
	public int position() {
		return _pos;
	}
	
	public Word get(int idx) {
		if(idx < 0 || idx >= _sentence.size()) {
			throw new IndexOutOfBoundsException();
		}
		return _sentence.get(idx);
	}
	
	public List<Integer> getWordIndices(Word w) {
		
		List<Integer> temp = new ArrayList<Integer>();
		
		if(w == null) {
			throw new NullPointerException();
		}
		
		for(int i = 0; i < _sentence.size();  ++i) {
			if(_sentence.get(i).toString().equalsIgnoreCase(w.toString())) {
				temp.add(i);
			}
		}
		
		return temp;
	}
	
	public Map<Word, Integer> wordFrequency(){
		
		Map<Word,Integer> map = new LinkedHashMap<Word, Integer>();
		for(int i = 0; i < _sentence.size(); ++i) {
			List<Integer> index = getWordIndices(_sentence.get(i));
			map.put(_sentence.get(i).toLowerCase(), index.size());
		}
		return map;
	}
	
	public Word mostFrequent() {
        for (int i = 0; i < _sentence.size(); i++) {
            if (wordFreq.containsKey(_sentence.get(i))) {
            	wordFreq.put(_sentence.get(i), wordFreq.get(_sentence.get(i)) + 1);
            }
            else {
            	wordFreq.put(_sentence.get(i), 1);
            }
        }
 
        Set<Entry<Word, Integer>> set = wordFreq.entrySet();
        Word key = new Word(" ",_pos);
        int value = 0;
 
        for (Map.Entry<Word, Integer> me : set) {
            if (me.getValue() > value) {
                value = me.getValue();
                key = me.getKey();
            }
        }
 
        return key;
	}
	
}
