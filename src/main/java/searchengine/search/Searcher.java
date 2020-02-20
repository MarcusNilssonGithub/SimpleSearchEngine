package searchengine.search;

import searchengine.document.Document;
import searchengine.engine.Engine;

import java.util.ArrayList;
import java.util.List;

public class Searcher {
    private Engine engine;

    public Searcher(Engine engine) {
        this.engine = engine;
    }

    public List<Document> searchTerm(String term) {
        if (term == null || term.split(" ").length < 1) {
            return new ArrayList<>();
        }

        return this.engine.searchTerm(term.split(" ")[0]);
    }
}
