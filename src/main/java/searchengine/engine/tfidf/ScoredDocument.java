package searchengine.engine.tfidf;

import java.text.DecimalFormatSymbols;
import java.util.Locale;
import searchengine.document.Document;

import java.text.DecimalFormat;

import static java.lang.String.format;

public class ScoredDocument extends Document implements Comparable<ScoredDocument> {
    private static final DecimalFormat df2 = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(
        Locale.US));
    private final Double score;

    public ScoredDocument(Document document, double score) {
        super(document.getName(), document.getText());
        this.score = score;
    }

    @Override
    public String toString() {
        return format("%s: Score: %s", this.getName(), df2.format(this.score));
    }

    @Override
    public int compareTo(ScoredDocument other) {
        return this.score.compareTo(other.score);
    }
}
