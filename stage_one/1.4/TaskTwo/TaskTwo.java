import java.util.*;

public class TaskTwo {
    public static void main(String[] args) {
        System.out.println("Введите массив: ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String[] splitText = text.split(" ");
        Sentence sentence = new Sentence(splitText);

        Operation uniqueSentence = (sentence1) -> {
            Set<String> s  = new LinkedHashSet<>(sentence1.getStringWords());
            ArrayList<String> s2 = new ArrayList<>(s);
            return s2;
        };
        String[] newSentence = uniqueSentence.getDistinctSentence(sentence).toArray(String[]::new);
        Sentence distinctSentence = new Sentence(newSentence);
        System.out.println(distinctSentence.getOriginalSentence());
    }
}