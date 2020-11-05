public class stopWord {

    private String word;
    private int score;

    public stopWord (String s) {
        this.word = s;
        score = 0;
    }

    public String getStopWord(){
        return this.word;
    }

    public int getZero(){
        return score;
    }
}
