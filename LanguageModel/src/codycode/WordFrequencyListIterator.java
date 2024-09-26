package codycode;

import java.util.Iterator;

public class WordFrequencyListIterator implements Iterator<WordFrequency> {

	private WordFrequency[] data;
	private int currentIndex;
	
	public WordFrequencyListIterator(WordFrequency[] data) {
		this.data = data;
		this.currentIndex = 0;
	}
	
	public boolean hasNext() {
		return currentIndex < data.length;
	}

	public WordFrequency next() {
		if(!hasNext()) {
			throw new java.util.NoSuchElementException();
				
		}
		
		WordFrequency wordFrequency = data[currentIndex];
		currentIndex++;
		return wordFrequency;
	}

}
