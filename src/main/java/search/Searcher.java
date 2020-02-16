package search;

import document.Document;

import java.util.Collection;

public class Searcher {
    private Collection<Document> corpus;
    private Engine engine;

    public Searcher(Engine engine, Collection<Document> documents) {
        this.corpus = documents;
        this.engine = engine;
        this.engine.build(corpus);
    }

    public Collection<Document> searchTerm(String term) {
        return this.engine.searchTerm(term);
    }
}
