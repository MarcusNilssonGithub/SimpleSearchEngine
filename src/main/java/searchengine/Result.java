package searchengine;

public class Result {
    private Document document;
    private float score;

    public Result(Document document, float score){
        this.document = document;
        this.score = score;
    }
}
