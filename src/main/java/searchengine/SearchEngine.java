package searchengine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchEngine {
    private List<Document> corpus;
    private List<HashMap<String, Integer>> termFreqs;

    public SearchEngine(List<Document> documents) {
        this.corpus = documents;
        this.termFreqs = new ArrayList<>();

        for (Document document : corpus) {
            termFreqs.add(termFreq(document));
        }
    }

    public List<Result> searchTerm(String term) {
        List<Result> results = new ArrayList<>();
        // TODO: do search and sort
        return results;
    }

    private HashMap<String, Integer> termFreq(Document document) {
        HashMap<String, Integer> termFreq = new HashMap();
        String[] words = normalizedWords(document.getText());
        for (String word : words) {
            Integer count = termFreq.get(word);
            if (count == null) {
                termFreq.put(word, 1);
            } else {
                termFreq.put(word, count + 1);
            }
        }

        return termFreq;
    }

    private String[] normalizedWords(String text) {
        String[] words = text.toLowerCase().split(" ");
        String word;
        for (int i = 0; i < words.length; i++) {
            word = words[i].replaceAll("[^a-z]", "");
            words[i] = word;
        }
        return words;
    }

}
