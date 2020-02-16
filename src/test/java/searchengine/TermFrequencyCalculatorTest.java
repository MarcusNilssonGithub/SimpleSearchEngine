package searchengine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TermFrequencyCalculatorTest {

    @Test
    void calculateTermFrequency() {
        Double expected = 1.0;
        assertEquals(expected, TermFrequencyCalculator.calculateTermFrequency(new Document("DocumentName", "term1")).get("term1"));
    }

    @Test
    void doDocumentLengthNormalization() {
        Double expected = 0.5;
        assertEquals(expected, TermFrequencyCalculator.calculateTermFrequency(new Document("DocumentName", "term1 term2")).get("term1"));
        expected = 1 / 3.0;
        assertEquals(expected, TermFrequencyCalculator.calculateTermFrequency(new Document("DocumentName", "term1 term2 term3")).get("term1"));
    }
}
