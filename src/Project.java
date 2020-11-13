import java.util.Scanner;
import java.io.*;

public class Project {

    public static void main (String[] args) {

        //error statement
        if(args.length != 3){
            System.err.println("USAGE: java Prototype AFINN.txt stopWords.txt userFile.txt");
            System.exit(1);
        }

        //input text files in the following order: AFINN dictionary, the stop words, and the text to be analyzed
        //command line arguments will take file names
        String dictionaryFile = args[0];
        String stopWordsFile = args[1];
        //more searching is necessary in order to determine what kind of data set this should be
        String userTextFile = args[2];

        //create scanner object
        Scanner dictionaryScanner =  openFile(dictionaryFile);
        Scanner stopWordsScanner = openFile(stopWordsFile);
        Scanner userTextScanner = openFile(userTextFile);

        //following variables store the length that each array will need to be initialized at
        int dictionaryNumLines = countLines(dictionaryFile);
        int stopWordsNumLines = countLines(stopWordsFile);
        //int userText must first be tokenized before it can be sized(?)

        word [] words = new word[stopWordsNumLines + dictionaryNumLines];

        words = stopWordScanner(stopWordsScanner, words);
        words = wordScoreScanner(dictionaryScanner, words, stopWordsNumLines);

        words = textBlock.alphabetize_2(words);

        System.out.println("AFINN.txt and stopWords.txt words with corresponding score:");
        //test to ensure that words array (of stop words and dictionary words) is alphabetized
        for (int i = 0; i < words.length; i++){
            System.out.println(words[i].getWord() + " " + words[i].getScore());
        }

        textBlock [] textBlocks = new textBlock[1];
        textBlocks = userTextScanner(userTextScanner, textBlocks, words);



    }



    //must figure out how large the array is
        //once to count the lines
    public static int countLines(String filename) {
            Scanner scan = openFile(filename);
            int count = 0;
            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                count++;
            }
            scan.close(); // make the file available for reuse
            return count;
        }

    public static Scanner openFile(String s) {
        try {
            //System.out.println(s);
            //File currentFile = new File(s);
            //Scanner scan = new Scanner(currentFile);
            Scanner scan = new Scanner(new java.io.FileReader(s));
            return scan;
        }
        catch (java.io.FileNotFoundException e) {
            System.out.println ("Error opening file for reading");
            System.exit(1);
            return null; // this stmt will never be reached
        }
    }
        //each file will have a separate scanner method
            //the stop words will be parsed into words each assigned a value of zero

    public static word [] stopWordScanner(Scanner scan, word [] stopWords){
       int count = 0;
        while(scan.hasNext()){
            String nextWord = scan.next();
            //System.out.println(nextWord);

            word nextWordScore = new word(nextWord, 0);
            stopWords[count] = nextWordScore;
            count ++;
        }
        return stopWords;
    }
        //the dictionary will be parsed into words and scores alphabetically
        //reading and assigning each characteristic (nextString and nextInt) in a for loop
        //this will be done by creating a class wordScore of wordScore objects
        //a constructor will initialize each instance of the wordScore objects with the word and corresponding score

    public static word [] wordScoreScanner(Scanner scan, word [] wordScores, int offset){
       int count = offset;
        while(scan.hasNext()){
            String line = scan.nextLine();
            String[] tokens = line.split("\t");

            String nextWord = tokens[0];
            int score = Integer.parseInt(tokens[1]);
            //System.out.println(nextWord + " " + score);

            word nextWordScore = new word(nextWord, score);
            wordScores[count] = nextWordScore;
            count ++;
        }
        return wordScores;
    }

    //scanner for user input
    public static textBlock [] userTextScanner (Scanner scan, textBlock [] textBlocks, word [] words){
        //each post will exist on its own line
        int count = 0;
        while(scan.hasNext()){
            String line = scan.nextLine();

            textBlock nextTextBlock = new textBlock(line, words);

            textBlocks[count] = nextTextBlock;
            count ++;
        }
        return textBlocks;
    }
}

