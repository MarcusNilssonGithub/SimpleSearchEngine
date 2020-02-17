package tfidf;

import document.Document;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ScoredDocumentTest {

    @Test
    void stringifyNameAndScoreOneDecimal() {
        String expected = "DocumentName: Score: 1.10";
        assertEquals(expected, new ScoredDocument(new Document("DocumentName", ""), 1.1).toString());
    }

    @Test
    void stringifyNameAndScoreTwoDecimals() {
        String expected = "DocumentName: Score: 1.10";
        assertEquals(expected, new ScoredDocument(new Document("DocumentName", ""), 1.10).toString());
    }

    @Test
    void compareScore() {
        ScoredDocument smaller = new ScoredDocument(new Document("DocumentName", ""), 1.0);
        ScoredDocument bigger = new ScoredDocument(new Document("DocumentName", ""), 2.0);
        assertTrue(smaller.compareTo(bigger) < 0);
    }
}
