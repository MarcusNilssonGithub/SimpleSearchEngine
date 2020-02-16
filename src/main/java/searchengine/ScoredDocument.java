package searchengine;

import java.text.DecimalFormat;

import static java.lang.String.format;


public class ScoredDocument implements Comparable<ScoredDocument> {
    private static final DecimalFormat df2 = new DecimalFormat("#.00");
    private final Document document;
    private final Double score;

    public ScoredDocument(Document document, double score) {
        this.document = document;
        this.score = score;
    }

    @Override
    public String toString() {
        return format("%s: Score: %s", this.document.getName(), df2.format(this.score));
    }

    @Override
    public int compareTo(ScoredDocument other) {
        return this.score.compareTo(other.score);
    }
}
