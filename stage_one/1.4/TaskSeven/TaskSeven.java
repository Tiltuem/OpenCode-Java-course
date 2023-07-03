import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TaskSeven {
    public static void main(String[] args) {
        Path file = Paths.get("C:\\\\Users\\\\Kirill\\\\Desktop\\\\text.txt");
        String[] splitText = {};
        try {
            List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
            splitText = lines.toString().split(" ");
        }
        catch (Exception exception) {
            System.out.println("Error: " + exception);
        }

        Operation uniqueSentence = (sentence1) -> {
            Set<String> s  = new LinkedHashSet<>(sentence1.getStringWords());
            ArrayList<String> s2 = new ArrayList<>(s);
            return s2;
        };

        Sentence sentence = new Sentence(splitText);
        String[] newSentence = uniqueSentence.getDistinctSentence(sentence).toArray(String[]::new);
        Sentence distinctSentence = new Sentence(newSentence);
        System.out.println(distinctSentence.getOriginalSentence());
        Analizator sentence2 = new Analizator(newSentence);

        try (FileWriter writer = new FileWriter("C:\\\\Users\\\\Kirill\\\\Desktop\\\\result.txt");PrintWriter printWriter = new PrintWriter(writer);) {
            printWriter.printf("Анализ текста.\nВсего слов - %d\nИз них:\nC гласной - %d\nC согласной - %d", sentence2.getCountWords(), sentence2.getCountWordsVowels(), sentence2.getCountWordsConsonants());
        }
        catch(Exception exception) {
            System.out.println("Error: " + exception);
        }
        finally {
            System.out.println("Анализ проведен.");
        }
        sc.close;
    }
}