package tfidf;

import document.Document;

import java.util.Map;
import java.util.Set;

public class TFIDFCalculator {
    private Map<Document, TermFrequency> documentTermFrequency;
    private Map<String, Set<Document>> documentsContainingTerm;
    private int numberOfDocuments;

    public TFIDFCalculator(Map<Document, TermFrequency> documentTermFrequency, Map<String, Set<Document>> documentsContainingTerm, int numberOfDocuments) {
        this.documentTermFrequency = documentTermFrequency;
        this.documentsContainingTerm = documentsContainingTerm;
        this.numberOfDocuments = numberOfDocuments;
    }

    public Double score(String term, Document document) {
        return tf(document, term) * idf(term);
    }

    private double tf(Document document, String term) {
        return documentTermFrequency.get(document).get(term);
    }

    private double idf(String term) {
        // Add 1 to the divisor to avoid division by zero, and to avoid the range 0 to 1 where Math.log is NaN
        return Math.log(this.numberOfDocuments / 1.0 + (double) documentsContainingTerm.get(term).size());
    }
}
