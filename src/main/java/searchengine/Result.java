package searchengine;

public class Result {
    private Document document;
    private double score;

    public Result(Document document, double score) {
        this.document = document;
        this.score = score;
    }

    @Override
    public String toString() {
        return this.document.getName() + ": Score: " + this.score;
    }
}

