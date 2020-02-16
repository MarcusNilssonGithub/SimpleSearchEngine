package search;

import document.Document;

import java.util.Collection;

public interface Engine {
    void build(Collection<Document> corpus);
    Collection<Document> searchTerm(String Term);
}
