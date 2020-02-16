package searchengine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TermFrequency extends HashMap<String, Double> {

    private int wordCount;
    private Set<String> terms;

    public TermFrequency() {
        this.wordCount = 0;
        this.terms = new HashSet<>();
    }

    public int getWordCount() {
        return wordCount;
    }

    public void increment(String term) {
        this.merge(term, 1.0, Double::sum);
        this.terms.add(term);
        this.wordCount++;
    }

    public void set(String term, Double frequency) {
        this.put(term, frequency);
    }

    public Set<String> getTerms() {
        return this.terms;
    }
}
