package searchengine.engine.tfidf;


import searchengine.document.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TFIDFCalculatorTest {

    @Nested
    class normalizedScore {

        @Test
        @DisplayName("One document one term")
        void oneDocumentOneTerm() {
            Map<Document, TermFrequency> documentTermFrequency = new HashMap<>();
            Map<String, Set<Document>> documentsContainingTerm = new HashMap<>();
            TermFrequency termFrequency = new TermFrequency();

            termFrequency.increment("term1");
            Document document = new Document("document1", "term1");
            documentTermFrequency.put(document, termFrequency);

            Set<Document> documentSet = new HashSet<>();
            documentSet.add(document);
            documentsContainingTerm.put("term1", documentSet);

            TFIDFCalculator tfidfCalculator = new TFIDFCalculator(documentTermFrequency, documentsContainingTerm, 1);
            Double expected = 1.0 * (1.0 + Math.log(1.0 / 1.0));
            assertEquals(expected, tfidfCalculator.score("term1", document));
        }

        @Test
        @DisplayName("Two one-term documents same term")
        void twoDocumentsSameTerm() {
            Map<Document, TermFrequency> documentTermFrequency = new HashMap<>();
            Map<String, Set<Document>> documentsContainingTerm = new HashMap<>();
            TermFrequency termFrequency = new TermFrequency();

            termFrequency.increment("term1");
            Document document1 = new Document("document1", "term1");
            Document document2 = new Document("document2", "term1");
            documentTermFrequency.put(document1, termFrequency);
            documentTermFrequency.put(document2, termFrequency);

            Set<Document> documentSet = new HashSet<>();
            documentSet.add(document1);
            documentSet.add(document2);
            documentsContainingTerm.put("term1", documentSet);

            TFIDFCalculator tfidfCalculator = new TFIDFCalculator(documentTermFrequency, documentsContainingTerm, 2);
            Double expected = 1.0 * (1.0 + Math.log(2.0 / 2.0));
            assertEquals(expected, tfidfCalculator.score("term1", document1));
        }

        @Test
        @DisplayName("Two one-term documents different terms")
        void twoDocumentsDifferentTerms() {
            Map<Document, TermFrequency> documentTermFrequency = new HashMap<>();
            Map<String, Set<Document>> documentsContainingTerm = new HashMap<>();
            TermFrequency document1TermFrequency = new TermFrequency();
            TermFrequency document2TermFrequency = new TermFrequency();

            document1TermFrequency.increment("term1");
            document2TermFrequency.increment("term2");
            Document document1 = new Document("document1", "term1");
            Document document2 = new Document("document2", "term2");
            documentTermFrequency.put(document1, document1TermFrequency);
            documentTermFrequency.put(document2, document2TermFrequency);

            Set<Document> documentSet1 = new HashSet<>();
            Set<Document> documentSet2 = new HashSet<>();
            documentSet1.add(document1);
            documentSet2.add(document2);
            documentsContainingTerm.put("term1", documentSet1);
            documentsContainingTerm.put("term2", documentSet2);

            TFIDFCalculator tfidfCalculator = new TFIDFCalculator(documentTermFrequency, documentsContainingTerm, 2);
            Double expected = 1.0 * (1.0 + Math.log(2.0 / 1.0));
            assertEquals(expected, tfidfCalculator.score("term1", document1));
        }
    }
}
