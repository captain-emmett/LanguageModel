package codycode;


public class MyHashTable {
	private HashTableEntry[] table;
	private int size;
	
	private static final int Initial_Capacity = 7;
	
	public MyHashTable(){
		table = new HashTableEntry[Initial_Capacity];
		size = 0;
	}
	
	public void add(String key, String follower) {
		if (size >= table.length / 2) {
			resizeTable();
		}
		
		int hash = hashFunction(key);
		while (table[hash] !=null && !table[hash].empty() && !table[hash].key().equals(key)) {
			hash = (hash + 1) % table.length;
		}
		
		if(table[hash] == null || table[hash].empty()) {
			table[hash] = new HashTableEntry(key);
			size++;
		}
		table[hash].add(follower);
	}
	
	private void resizeTable() {
	    int newCapacity = (table.length * 2) + 1;
	    HashTableEntry[] oldTable = table;
	    table = new HashTableEntry[newCapacity];

	    size = 0;
	    for (HashTableEntry entry : oldTable) {
	        if (entry != null && !entry.empty()) {
	            add(entry.key(), entry.list().toString());
	        }
	    }
	}
	
	private int hashFunction(String key) {
		return Math.abs(key.hashCode() % table.length);
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        for (HashTableEntry entry : table) {
            if (entry != null && !entry.empty()) {
                sb.append(entry).append("\n");
            }
        }
        return sb.toString();
    }
	
	public class HashTableEntry {
		  private boolean isEmpty;
		  private String key;
		  private long numFollowingWords;  // total of the frequencies in the list
		  private WordFrequencyList list;

		  public HashTableEntry() {   // constructor for empty hash table entry
		    isEmpty = true;
		    key = null;
		    numFollowingWords = 0;
		    list = new WordFrequencyList();
		  }

		  public HashTableEntry(String key) {   // constructor for non-empty hash table entry
		    isEmpty = false;
		    this.key = key;
		    numFollowingWords = 0;
		    list = new WordFrequencyList();
		  }

		  public boolean empty() {
			  return isEmpty;
		  }

		  public String key() {
		    return key;
		  }

		  public long total() {
		    return numFollowingWords;
		  }

		  public WordFrequencyList list() {
		    return list;
		  }

		  // add follower as one of the words that can follow this word
		  public void add(String follower) {
		    list.add(follower);
		    numFollowingWords++;
		  }

		  // randomly select and return one of the followers.  The probability that
		  // a given follower is selected should be proportional to its frequency
		  // in the training set divided by numFollowingWords
		  public String select() {
		    return "hello world";
		  }

		  public String toString() {
		    if (isEmpty) return "empty";
		    return key + "/" + numFollowingWords + "(" + list + ")";
		  }
	}
	
	
}
