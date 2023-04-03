import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class Analizator extends Sentence{
    private static final List<Character> VOWELS = Arrays.asList('а','о', 'э', 'е', 'и', 'ы', 'у', 'ё', 'ю', 'я');
    private int countWord = 0;
    private int countWordVowels = 0;
    private int countWordConsonants = 0;
    public Analizator(ArrayList<Word> words) {
        super(words);
    }
    public Analizator(String[] words) {
        super(words);
    }
    public Analizator(String words) {
        super(words);
    }

    public int getCountWords() {
        return countWords.apply(countWord);
    }
    public int getCountWordsVowels() {
        return countWordsVowels.apply(countWordVowels);
    }
    public int getCountWordsConsonants() {
        return countWordsConsonants.apply(countWordConsonants);
    }

    UnaryOperator<Integer> countWords = (countWords) -> getWordsCount();
    UnaryOperator<Integer> countWordsVowels = (countWordVowels) -> {
        for(int i = 1; i <=  getWordsCount(); i++) {
            if (VOWELS.contains(getWordByPosition(i).getOriginalWord().toLowerCase().charAt(0))) {
                countWordVowels++;
            }
        }
        return countWordVowels;
    };
    UnaryOperator<Integer> countWordsConsonants = (countWordConsonants) -> {
        for(int i = 1; i <=  getWordsCount(); i++) {
            if (!VOWELS.contains(getWordByPosition(i).getOriginalWord().toLowerCase().charAt(0))) {
                countWordConsonants++;
            }
        }
        return countWordConsonants;
    };
}
