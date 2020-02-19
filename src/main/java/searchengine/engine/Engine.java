package searchengine.engine;

import searchengine.document.Document;

import java.util.Collection;
import java.util.List;

public abstract class Engine {
    private Collection<Document> corpus;

    public Engine(Collection<Document> corpus) {
        this.corpus = corpus;
    }

    public Collection<Document> getCorpus() {
        return this.corpus;
    }

    public abstract List<Document> searchTerm(String Term);
}
