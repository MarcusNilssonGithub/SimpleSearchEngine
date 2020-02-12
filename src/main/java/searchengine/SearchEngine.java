package searchengine;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private List<Document> documents;

    public SearchEngine(List<Document> documents){
        this.documents = documents;
    }

    public List<Result> search(String term){
        List<Result> results = new ArrayList<>();
        // TODO: do search and sort
        return results;
    }
}
