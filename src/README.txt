# Final Project Overview: Sentiment Text Analysis
My program will read a user input file and analyze the "sentiment" of the text. The program will return a score for the text based on the valence rating of relevant words. 
 
## Input Text Files
There will be three input text files used in my program. The first two will be used in every call to the program, the third will be selected by the user. The command line arguments will be: 

 1. A dictionary of words (AFINN) with corresponding valence ratings
 2. A list of "stop words" 
 3. The text that the user wants analyzed

All files will be accessed and read using a scanner object in three distinct methods. 


## Reading & Storing Text Files
### Scanner Object
The scanner object (which will be used to count and read the input texts) will be imported and initialized in the following manner: 

	private static Scanner openFile(String s) {
        try {
            Scanner scan = new Scanner(new java.io.FileReader(s));
            return scan;
        }
        catch (java.io.FileNotFoundException e) {
            System.out.println ("Error opening file for reading");
            System.exit(1);
            return null; // this stmt will never be reached
        }
    }

### Sizing the Array
The scanner object will move through each input twice, the first time to find the size of the array and a second time to fill it. 

	private static int countLines(String filename) { 
		Scanner infile = openFile(filename); 
		int count = 0; 
		while (infile.hasNextLine()){
			String s = infile.nextLine(); 	
			count++; } 
		infile.close(); // make the file available for reuse 
		return count;}

The value of count will be used when initializing the arrays of strings. 

### "Stop Words"
These words are identified as unlikely to change the sentiment of the post and are therefore marked as 0 for the purpose of  the analysis. The file containing "stop words" will be read by the scanner object and stored  in as objects in a class stopWords. Each instance of stopWords will be assigned zero in order to ensure that these words do not impact the overall score of the posts. . 

### AFINN Dictionary
 The AFINN Dictionary is a list of English words rated for valence with an integer between minus five (negative) and plus five (positive). The characteristics of this list (string and integer) will be parsed by a scanner method and assigned as instance variables in an object class wordScore. These objects will be assigned to indexes of an array of wordScore called afinnWords. 

### User Text
The user input text will be read as a single string and subsequently parsed into multiple strings using a split function. 

String post = “I am excited to complete this project” ;
String[] words = post.split(“ “);

After the split method is called, String [] words will contains "I" "am" "excited" "about" "my" "project" 

## Completing Analysis

I will use binary search to move through  the arrays and locate common words. Once these words have been located, the "getScore" and "getZero" methods will return a corresponding score. This score will increment the total value of the user input text. 

