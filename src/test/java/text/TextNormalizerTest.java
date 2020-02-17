package text;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextNormalizerTest {

    @Test
    void termToLowerCase() {
        String expected = "abc";
        assertEquals(expected, TextNormalizer.normalizedTerms("ABC").get(0));
    }

    @Test
    void splitTermsOnNonAlphamericCharacter() {
        String expected1 = "abc";
        String expected2 = "def";

        List<String> terms = TextNormalizer.normalizedTerms("abc def");
        assertEquals(expected1, terms.get(0));
        assertEquals(expected2, terms.get(1));

        terms = TextNormalizer.normalizedTerms("abc,def");
        assertEquals(expected1, terms.get(0));
        assertEquals(expected2, terms.get(1));

        terms = TextNormalizer.normalizedTerms("abc.def");
        assertEquals(expected1, terms.get(0));
        assertEquals(expected2, terms.get(1));

        terms = TextNormalizer.normalizedTerms("abc:def");
        assertEquals(expected1, terms.get(0));
        assertEquals(expected2, terms.get(1));

        terms = TextNormalizer.normalizedTerms("abc/def");
        assertEquals(expected1, terms.get(0));
        assertEquals(expected2, terms.get(1));
    }

    @Test
    void toLowerCaseAndSplit() {
        String expected1 = "abc";
        String expected2 = "def";
        List<String> terms = TextNormalizer.normalizedTerms("ABC DEF");
        assertEquals(expected1, terms.get(0));
        assertEquals(expected2, terms.get(1));
    }

    @Test
    void splitTermsOnSeveralNonAlphamericCharacters() {
        String expected1 = "abc";
        String expected2 = "def";

        List<String> terms = TextNormalizer.normalizedTerms("abc, def");
        assertEquals(expected1, terms.get(0));
        assertEquals(expected2, terms.get(1));

        terms = TextNormalizer.normalizedTerms("abc. def");
        assertEquals(expected1, terms.get(0));
        assertEquals(expected2, terms.get(1));

        terms = TextNormalizer.normalizedTerms("abc: def");
        assertEquals(expected1, terms.get(0));
        assertEquals(expected2, terms.get(1));
    }

    @Test
    void removePunctuationFromTerm() {
        String expected = "abc";
        assertEquals(expected, TextNormalizer.normalizedTerms("abc!").get(0));
        assertEquals(expected, TextNormalizer.normalizedTerms("abc.").get(0));
        assertEquals(expected, TextNormalizer.normalizedTerms("abc,").get(0));
        assertEquals(expected, TextNormalizer.normalizedTerms("abc?").get(0));
        assertEquals(expected, TextNormalizer.normalizedTerms("abc:").get(0));
    }

    @Test
    void removeSeveralNonAlphamericsFromEndOfTerm() {
        String expected = "abc";
        assertEquals(expected, TextNormalizer.normalizedTerms("abc!!").get(0));
        assertEquals(expected, TextNormalizer.normalizedTerms("abc..").get(0));
        assertEquals(expected, TextNormalizer.normalizedTerms("abc,,").get(0));
        assertEquals(expected, TextNormalizer.normalizedTerms("abc??").get(0));
        assertEquals(expected, TextNormalizer.normalizedTerms("abc::").get(0));
    }

    @Test
    void removeNonAlphamericAndSplitToLowerCaseTerms() {
        String expected1 = "abc";
        String expected2 = "efg";
        List<String> words = TextNormalizer.normalizedTerms("ABC! EFG!");
        assertEquals(expected1, words.get(0));
        assertEquals(expected2, words.get(1));
    }

    @Test
    void emptyStringReturnsEmptyList() {
        int expected = 0;
        List<String> words = TextNormalizer.normalizedTerms("");
        assertEquals(expected, words.size());
    }

    @Test
    void onlySpaceReturnsEmptyList() {
        int expected = 0;
        List<String> words = TextNormalizer.normalizedTerms(" ");
        assertEquals(expected, words.size());
    }

    @Test
    void onlyNonAlphamericReturnsEmptyList() {
        int expected = 0;
        assertEquals(expected, TextNormalizer.normalizedTerms("!").size());
        assertEquals(expected, TextNormalizer.normalizedTerms(".").size());
    }

    @Test
    void normalizedTermsFromText() {
        List<String> expected = Arrays.asList("abc", "def", "ghi", "jkl");
        assertEquals(expected, TextNormalizer.normalizedTerms("abc, DEF/ghi. Jkl"));
    }
}
