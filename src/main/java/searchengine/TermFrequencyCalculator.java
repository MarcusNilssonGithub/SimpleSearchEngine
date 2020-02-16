package searchengine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TermFrequencyCalculator {

    public static Map<String, Double> calculateTermFrequency(Document document) {
        Map<String, Double> termFrequency = new HashMap<>();
        List<String> terms = TextNormalizer.normalizedTerms(document.getText());
        terms.forEach(term -> termFrequency.merge(term, 1.0, Double::sum));
        return lengthNormalize(termFrequency);
    }

    private static Map<String, Double> lengthNormalize(Map<String, Double> termFrequency) {
        double wordCount = termFrequency.values().stream()
                .reduce(0.0, Double::sum);
        termFrequency.keySet()
                .forEach(key -> termFrequency.put(key, termFrequency.get(key) / wordCount));
        return termFrequency;
    }
}
