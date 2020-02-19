package searchengine.engine.tfidf;

import searchengine.document.Document;
import searchengine.engine.Engine;
import searchengine.text.TextNormalizer;

import java.util.*;

public class TFIDFEngine extends Engine {
    private Map<Document, TermFrequency> documentToTermFrequency;
    private Map<String, Set<Document>> termToDocumentsContainingTerm;
    private TFIDFCalculator tfidfCalculator;

    public TFIDFEngine(Collection<Document> corpus) {
        super(corpus);
        this.documentToTermFrequency = new HashMap<>();
        this.termToDocumentsContainingTerm = new HashMap<>();
        populateTermFrequencies(this.getCorpus());
        populateDocumentsContainingTerm(this.getCorpus());
        this.tfidfCalculator = new TFIDFCalculator(this.documentToTermFrequency, this.termToDocumentsContainingTerm, this.getCorpus().size());
    }

    @Override
    public List<Document> searchTerm(String term) {
        List<String> normalizedTerms = TextNormalizer.normalizedTermsFromText(term);
        if (normalizedTerms.size() == 0) {
            return new ArrayList<>();
        }
        String normalizedTerm = normalizedTerms.get(0);
        Set<Document> documentsContainingTerm = this.termToDocumentsContainingTerm.get(normalizedTerm);
        if (documentsContainingTerm == null) {
            return new ArrayList<>();
        }
        List<Document> scoredDocuments = new ArrayList<>();
        documentsContainingTerm.forEach(document -> {
            scoredDocuments.add(new ScoredDocument(document, tfidfCalculator.score(normalizedTerm, document)));
        });
        return sort(scoredDocuments);
    }

    private void populateTermFrequencies(Collection<Document> corpus) {
        corpus.forEach(document -> {
            documentToTermFrequency.put(document, TermFrequencyCalculator.calculateTermFrequency(document));
        });
    }

    private void populateDocumentsContainingTerm(Collection<Document> corpus) {
        corpus.forEach(document -> {
            TextNormalizer.normalizedTermsFromText(document.getText()).forEach(term -> {
                if (termToDocumentsContainingTerm.containsKey(term)) {
                    termToDocumentsContainingTerm.get(term).add(document);
                } else {
                    termToDocumentsContainingTerm.put(term, new HashSet<>(Collections.singletonList(document)));
                }
            });
        });
    }

    private List<Document> sort(List<Document> scoredDocuments) {
        Collections.sort(scoredDocuments, Collections.reverseOrder());
        return scoredDocuments;
    }
}
