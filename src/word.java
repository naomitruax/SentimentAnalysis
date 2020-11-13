public class word {
    //consider frequency instance variable?

    private String content;
    private int score;
    private int frequency;

    public word(String s, int i) {

        this.content = s;
        this.score = i;
    }

    public String getWord() {
        return this.content;
    }

    public int getScore() {
        return score;
    }

    public void setFrequency(int f) {
        this.frequency = f;
    }
}






