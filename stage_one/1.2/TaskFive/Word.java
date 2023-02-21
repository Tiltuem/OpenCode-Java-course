public class Word {
    private char[] word;
    public char[] getWords() {
        return word;
    }
    public Word (String word) {
        this.word = new 
    }
    public void setWord(char[] word) {
        this.word = word;
    }
    public int getSymbolCount() {
        return word.length;
    }
    public String getOriginalWord() {
        String originalWord = "";
        for (char symbol : word) {
            originalWord += symbol;
        }
        return originalWord;
    }


}
