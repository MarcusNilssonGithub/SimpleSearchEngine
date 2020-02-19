package searchengine.engine.tfidf;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TermFrequency {
    private Map<String, Double> termToValue;

    public TermFrequency() {
        termToValue = new HashMap<>();
    }

    public double getTermCount() {
        return termToValue.values().stream().reduce(0.0, Double::sum);
    }

    public void increment(String term) {
        termToValue.merge(term, 1.0, Double::sum);
    }

    public void set(String term, double frequency) {
        termToValue.put(term, frequency);
    }

    public double get(String term) {
        return termToValue.get(term);
    }

    public Set<String> getTerms() {
        return this.termToValue.keySet();
    }
}
