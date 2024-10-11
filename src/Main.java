import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get("text.txt"));
        StringBuffer text = new StringBuffer(new String(bytes));
        TextProcessor textProcessor = new TextProcessor(text);
        StringBuffer uniqueWord = textProcessor.findUniqueWord();
        System.out.println("The first unique word in the text is: " + uniqueWord);
    }
}