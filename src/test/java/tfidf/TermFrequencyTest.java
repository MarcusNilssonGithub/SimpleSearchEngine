package tfidf;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TermFrequencyTest {

    @Test
    void termCountZeroOnStart() {
        Double expected = 0.0;
        assertEquals(expected, (Double) new TermFrequency().getTermCount());
    }

    @Test
    void termCountOneWhenOneTerm() {
        TermFrequency termFrequency = new TermFrequency();
        Double expected = 1.0;
        termFrequency.increment("term1");
        assertEquals(expected, (Double) termFrequency.getTermCount());
    }

    @Test
    void incrementValueIfTermExists() {
        TermFrequency termFrequency = new TermFrequency();
        Double expected = 2.0;
        termFrequency.increment("term1");
        termFrequency.increment("term1");
        assertEquals(expected, (Double) termFrequency.get("term1"));
    }

    @Test
    void returnSetOfTerms() {
        TermFrequency termFrequency = new TermFrequency();
        termFrequency.increment("term1");
        termFrequency.increment("term2");
        Set<String> expected = new HashSet<>();
        expected.add("term1");
        expected.add("term2");
        assertEquals(expected, termFrequency.getTerms());
    }
}
