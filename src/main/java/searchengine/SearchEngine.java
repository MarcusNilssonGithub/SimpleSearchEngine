package searchengine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class SearchEngine {
    private List<Document> corpus;
    private List<HashMap<String, Double>> termFreqs;

    public SearchEngine(List<Document> documents) {
        this.corpus = documents;
        this.termFreqs = new ArrayList<>();
        corpus.forEach(document -> termFreqs.add(termFreq(document)));
    }

    public Collection<Result> searchTerm(String term) {
        int hits = 0;
        Collection<Result> results = new ArrayList<>();
        // TODO: do search and sort
        return results;
    }

    private HashMap<String, Double> termFreq(Document document) {
        HashMap<String, Double> termFreq = new HashMap<>();
        String[] words = normalizedWords(document.getText());
        for (String word : words) {
            termFreq.merge(word, 1.0, Double::sum);
        }
        return lengthNormalize(termFreq);
    }

    private String[] normalizedWords(String text) {
        String[] words = text.toLowerCase().split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^a-z]", "");
        }
        return words;
    }

    private HashMap<String, Double> lengthNormalize(HashMap<String, Double> termFrequency) {
        int wordCount = 0;
        for (Double frequency : termFrequency.values()) {
            wordCount += frequency;
        }
        for (String key : termFrequency.keySet()) {
            termFrequency.put(key, termFrequency.get(key) / wordCount);
        }
        return termFrequency;
    }
}
