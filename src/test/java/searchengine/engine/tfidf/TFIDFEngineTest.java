package searchengine.engine.tfidf;

import searchengine.document.Document;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TFIDFEngineTest {

    @Test
    void returnEmptyListIfTermNotExists() {
        Collection<Document> corpus = new ArrayList<>();
        corpus.add(new Document("document1", "term1"));
        TFIDFEngine tfidfEngine = new TFIDFEngine(corpus);

        int expectedSize = 0;
        assertEquals(expectedSize, tfidfEngine.searchTerm("term2").size());
    }

    @Test
    void returnEmptyListIfTermIsEmpty() {
        Collection<Document> corpus = new ArrayList<>();
        corpus.add(new Document("document1", "term1"));
        TFIDFEngine tfidfEngine = new TFIDFEngine(corpus);

        int expectedSize = 0;
        assertEquals(expectedSize, tfidfEngine.searchTerm("").size());
    }

    @Test
    void returnEmptyListIfTermIsNonAlphameric() {
        Collection<Document> corpus = new ArrayList<>();
        corpus.add(new Document("document1", "term1"));
        TFIDFEngine tfidfEngine = new TFIDFEngine(corpus);

        int expectedSize = 0;
        assertEquals(expectedSize, tfidfEngine.searchTerm("!").size());
    }

    @Test
    void returnEmptyListIfTermIsNull() {
        Collection<Document> corpus = new ArrayList<>();
        corpus.add(new Document("document1", "term1"));
        TFIDFEngine tfidfEngine = new TFIDFEngine(corpus);

        int expectedSize = 0;
        assertEquals(expectedSize, tfidfEngine.searchTerm(null).size());
    }

    @Test
    void noCorpusReturnsEmptyList() {
        Collection<Document> corpus = new ArrayList<>();
        TFIDFEngine tfidfEngine = new TFIDFEngine(corpus);

        int expectedSize = 0;
        assertEquals(expectedSize, tfidfEngine.searchTerm("term1").size());
    }

}