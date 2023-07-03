public class Sentence {
    private Word[] words;

    public Word[] getWords() {
        return words;
    }

    public void setWords(Word[] words) {
        this.words = words;
    }

    public Sentence(String[] words) {
        this.words = new Word[words.length];
        for (int i = 0; i < words.length; i++) {
            this.words[i] = new Word(words[i]);
        }
    }

    public int getWordsCount() {
        return words.length;
    }

    public String getOriginalSentence() {
        String originalSentence = "";
        for (Word word : words) {
            originalSentence += word;
        }
        return originalSentence;
    }

    public Word getWordByPosition(int pos) {
        return words[pos - 1];
    }
}
