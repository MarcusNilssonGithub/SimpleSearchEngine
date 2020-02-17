package tfidf;

import document.Document;
import text.TextNormalizer;

public class TermFrequencyCalculator {

    public static TermFrequency calculateTermFrequency(Document document) {
        TermFrequency termFrequency = new TermFrequency();
        TextNormalizer.normalizedTerms(document.getText())
                .forEach(term -> termFrequency.increment(term));
        return lengthNormalize(termFrequency);
    }

    private static TermFrequency lengthNormalize(TermFrequency termFrequency) {
        TermFrequency termFrequencyLengthNormalized = new TermFrequency();
        termFrequency.getTerms()
                .forEach(term -> termFrequencyLengthNormalized.set(term, termFrequency.get(term) / termFrequency.getTermCount()));
        return termFrequencyLengthNormalized;
    }
}
