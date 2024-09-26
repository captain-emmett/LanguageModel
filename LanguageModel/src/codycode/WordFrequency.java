package codycode;

public class WordFrequency {
	  private String word;
	  private long frequency;

	  public WordFrequency(String word) {
	    this.word = word;
	    frequency = 1;
	  }

	  public String word() {
	    return this.word;
	  }
	  public long freq() {
	    return this.frequency;
	  }

	  public void increment() {
	    this.frequency++;
	  }
	}