package search;

import document.Document;

import java.util.Collection;

public abstract class Engine {
    private Collection<Document> corpus;

    public Engine(Collection<Document> corpus) {
        this.corpus = corpus;
    }

    public Collection<Document> getCorpus() {
        return this.corpus;
    }

    public abstract Collection<Document> searchTerm(String Term);
}
