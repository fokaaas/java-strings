import java.util.ArrayList;

public class TextProcessor {
    private final StringBuffer text;

    public TextProcessor(StringBuffer text) {
        this.text = text;
    }

    public StringBuffer findUniqueWord () {
        char[] sentenceDelimiters = {'.', '!', '?'};
        char[] wordDelimiters = {' ', ',', ':'};
        ArrayList<StringBuffer> sentences = split(text, sentenceDelimiters);
        ArrayList<StringBuffer> firstSentenceWords = split(sentences.getFirst(), wordDelimiters);
        ArrayList<StringBuffer> otherSentenceWords = new ArrayList<>();
        for (int i = 1; i < sentences.size(); i++) {
            ArrayList<StringBuffer> wordsInSentence = split(sentences.get(i), wordDelimiters);
            otherSentenceWords.addAll(wordsInSentence);
        }
        for (StringBuffer word : firstSentenceWords) {
            if (isUniqueInOtherSentences(word, otherSentenceWords)) {
                return word;
            }
        }
        throw new RuntimeException("No unique word found");
    }

    private ArrayList<StringBuffer> split (StringBuffer text, char[] delimiters) {
        ArrayList<StringBuffer> parts = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < text.length(); i++) {
            if (isDelimiter(text.charAt(i), delimiters)) {
                if (start < i) {
                    parts.add(new StringBuffer(text.substring(start, i).trim()));
                }
                start = i + 1;
            }
        }
        if (start < text.length()) {
            parts.add(new StringBuffer(text.substring(start).trim()));
        }
        return parts;
    }

    private boolean isDelimiter(char c, char[] delimiters) {
        for (char delimiter : delimiters) {
            if (c == delimiter) return true;
        }
        return false;
    }

    private boolean isUniqueInOtherSentences(StringBuffer word, ArrayList<StringBuffer> otherSentenceWords) {
        for (StringBuffer otherWord : otherSentenceWords) {
            if (equalsIgnoreCase(word, otherWord)) return false;
        }
        return true;
    }

    private boolean equalsIgnoreCase(StringBuffer sb1, StringBuffer sb2) {
        return sb1.toString().equalsIgnoreCase(sb2.toString());
    }
}
