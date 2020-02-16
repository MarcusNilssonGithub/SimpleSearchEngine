package searchengine;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TextNormalizer {

    public static List<String> normalizedTerms(String text) {
        return lowerCaseTerms(text).stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private static List<Optional<String>> lowerCaseTerms(String text) {
        return Arrays.asList(text.toLowerCase().split("\\W")).stream()
                .map(TextNormalizer::removeEmptyStrings)
                .collect(Collectors.toList());
    }

    private static Optional<String> removeEmptyStrings(String term) {
        return term.length() == 0 ? Optional.empty() : Optional.of(term);
    }
}
