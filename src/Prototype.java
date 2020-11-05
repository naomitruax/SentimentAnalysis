import java.util.Scanner;
import java.io.*;

public class Prototype {

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

        System.out.println(dictionaryFile);
        System.out.println(stopWordsFile);
        System.out.println(userTextFile);

        //create scanner object
        Scanner dictionaryScanner =  openFile(dictionaryFile);
        Scanner stopWordsScanner = openFile(stopWordsFile);
        Scanner userTextScanner = openFile(userTextFile);

        //following variables store the length that each array will need to be initialized at
        int dictionaryNumLines = countLines(dictionaryFile);
        int stopWordsNumLines = countLines(stopWordsFile);
        //int userText must first be tokenized before it can be sized(?)

        wordScore [] aFinnDictionary = new wordScore[dictionaryNumLines];
        stopWord [] stopWords = new stopWord[stopWordsNumLines];
        stopWordScanner(stopWordsScanner, stopWords);

        wordScore [] wordScores = new wordScore[dictionaryNumLines];
        wordScoreScanner(dictionaryScanner, wordScores);
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
            System.out.println(s);
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

    public static void stopWordScanner(Scanner scan, stopWord [] stopWords){
       int count = 0;
        while(scan.hasNext()){
            String nextWord = scan.next();
            System.out.println(nextWord);
            stopWord nextStopWord = new stopWord(nextWord);
            stopWords[count] = nextStopWord;
            count ++;
        }
    }

        //the dictionary will be parsed into words and scores alphabetically
        //reading and assigning each characteristic (nextString and nextInt) in a for loop
        //String word = scan.next(“\H”);
        //int score = scan.nextInt();
        //this will be done by creating a class wordScore of wordScore objects
        //a constructor will initialize each instance of the wordScore objects with the word and corresponding score

    public static void wordScoreScanner(Scanner scan, wordScore [] wordScores){
       int count = 0;
        while(scan.hasNext()){
            // "\H" not a valid expression
            String word = scan.next();
            int score = scan.nextInt();

            wordScore nextWordScore = new wordScore(word, score);
            wordScores[count] = nextWordScore;
            count ++;
        }
    }
            //the text file will be stored as a string that will be tokenized and used later in the analysis

        //once all inputs have been properly stored, the process of analyzing the users text will commence
        //this will be done through binary search
        //the following structure may be useful when find the value of each post
            //incrementing by getScore() rather than nextInt()

        //private static int addNumbers (Scanner infile) {
            //int sum = 0;
            //while (infile.hasNextInt()) {
                //sum += infile.nextInt();
            //}
            //infile.close();
            //return sum;
        //}

        //not yet sure where the binary search method will be located
        //not entirely sure of the format that i want the program to return
        //as i advance this code, i hope to find more complex and interesting ways of analyzing the input text
        //for example, can i get my program to tell me if there are common words that are not represented in my dictionary?
            //if so, can i add them to my wordScore class with an assigned value?
    }

