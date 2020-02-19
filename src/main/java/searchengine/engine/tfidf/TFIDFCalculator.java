package searchengine.engine.tfidf;

import searchengine.document.Document;

import java.util.Map;
import java.util.Set;

public class TFIDFCalculator {
    private Map<Document, TermFrequency> documentToTermFrequency;
    private Map<String, Set<Document>> termToDocumentsContainingTerm;
    private int numberOfDocuments;

    public TFIDFCalculator(Map<Document, TermFrequency> documentToTermFrequency, Map<String, Set<Document>> termToDocumentsContainingTerm, int numberOfDocuments) {
        this.documentToTermFrequency = documentToTermFrequency;
        this.termToDocumentsContainingTerm = termToDocumentsContainingTerm;
        this.numberOfDocuments = numberOfDocuments;
    }

    public double score(String term, Document document) {
        return tf(document, term) * idf(term);
    }

    private double tf(Document document, String term) {
        return documentToTermFrequency.get(document).get(term);
    }

    private double idf(String term) {
        // Add 1 to the divisor to avoid division by zero, and to avoid the range 0 to 1 where Math.log is NaN
        return 1 + Math.log(this.numberOfDocuments / (double) termToDocumentsContainingTerm.get(term).size());
    }
}
