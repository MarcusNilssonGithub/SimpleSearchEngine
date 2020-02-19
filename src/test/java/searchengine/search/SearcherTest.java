package searchengine.search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import searchengine.document.Document;
import searchengine.engine.tfidf.TFIDFEngine;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class SearcherTest {

    @Test
    void returnDocument() {
        Collection<Document> documents = new ArrayList<>();
        documents.add(new Document("document1", "term1"));
        Searcher searcher = new Searcher( new TFIDFEngine(documents));
        int expectedSize = 1;
        String expectedName = "document1";
        assertEquals(expectedSize, searcher.searchTerm("term1").size());
        assertEquals(expectedName, searcher.searchTerm("term1").get(0).getName());
    }

    @Test
    void searchFirstTermIfSeveral() {
        Collection<Document> documents = new ArrayList<>();
        documents.add(new Document("document1", "term1"));
        Searcher searcher = new Searcher( new TFIDFEngine(documents));
        int expectedSize = 1;
        assertEquals(expectedSize, searcher.searchTerm("term1 term2 term3").size());
    }
}