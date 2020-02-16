package searchengine;

public class TermFrequencyCalculator {

    public static TermFrequency calculateTermFrequency(Document document) {
        TermFrequency termFrequency = new TermFrequency();
        TextNormalizer.normalizedTerms(document.getText())
                .forEach(term -> termFrequency.increment(term));
        return lengthNormalize(termFrequency);
    }

    private static TermFrequency lengthNormalize(TermFrequency termFrequency) {
        int wordCount = termFrequency.getWordCount();
        termFrequency.getTerms()
                .forEach(term -> termFrequency.set(term, termFrequency.get(term) / (double) wordCount));
        return termFrequency;
    }
}
