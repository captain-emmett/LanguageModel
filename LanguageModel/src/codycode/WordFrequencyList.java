package codycode;

public class WordFrequencyList implements Iterable<WordFrequency> {

	  private WordFrequency[] data;   // exactly the size, no optimization

	  public WordFrequencyList() {
	    data = new WordFrequency[0];
	  }

	  public java.util.Iterator<WordFrequency> iterator() {
	    return new WordFrequencyListIterator(data);
	  }

	  // the data at from index may be more frequent than its predecessor(s).
	  // bubble it forward until they are in sorted order
	  private void bubbleForward(int fromIndex) {
	    for (int i = fromIndex; i > 0; i--) {
	      if (data[i].freq() <= data[i - 1].freq()) {   // done
	        return;
	      }
	      // else swap
	      WordFrequency temp = data[i];
	      data[i] = data[i - 1];
	      data[i - 1] = temp;
	    }
	  }

	  public void add(String word) {
	    word = word.toLowerCase();
	    for (int i = 0; i < data.length; i++) {
	      if (word.equals(data[i].word())) {
	        data[i].increment();
	        bubbleForward(i);
	        return;
	      }
	    }
	    data = java.util.Arrays.copyOf(data, data.length + 1);
	    data[data.length - 1] = new WordFrequency(word);
	    bubbleForward(data.length - 1);
	  }

	  public String toString() {
	    StringBuilder b = new StringBuilder();
	    String separator = "";
	    for (int i = 0; i < data.length; i++) {
	      b.append(separator + data[i].word() + "/" + data[i].freq());
	      separator = ", ";
	    }
	    return b.toString();
	  }
	}
