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

        return null;
    }

    private  ArrayList<StringBuffer> split (StringBuffer text, char[] delimiters) {
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
}
