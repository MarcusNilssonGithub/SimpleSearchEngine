package search;

import document.Document;

import java.util.Collection;

public class Searcher {
    private Engine engine;

    public Searcher(Engine engine) {
        this.engine = engine;
    }

    public Collection<Document> searchTerm(String term) {
        return this.engine.searchTerm(term);
    }
}
