public class textBlock {
    //while loop passes each comment into new textBlock =
    //comment will be passed as a single string
    //textBlock takes in comment as a string + splits it into individual strings
    //this will involve splitting each user input text into an array of text blocks (txt file of comments separated by lines)

    //textBlock constructor
    //also pass index of the textBlock
    public textBlock(String textBlock, word [] words, int index) {
        int text = index + 1;

        //call split method on a comment to create an array strings filled with each individual word
        String[] textStrings = textBlock.split(" ");

        //array of strings is sorted in alphabetical order
        //  advantages: occurrences of the same word are next to each other
        alphabetize(textStrings);

        //fill new array that replaces textStrings with words objects
        word [] textWords = getWords(textStrings, words);

        System.out.println("Corresponding score and frequency of text " + text + ":");

        //TODO consider adding non dictionary words to words array
        //if i want them included in frequency, this must be completed here

        //update the frequency of the instance variable
        //begin my making an array of words as long as the number of strings in the comment (textBlock)
        word [] uniqueWords = addFrequency(textWords);

        int totalScore = calcScore(uniqueWords);
        System.out.println("Total score is: " + totalScore);

        for (int i = 0; i < uniqueWords.length; i++){
            System.out.println(uniqueWords[i].getWord() + " " + uniqueWords[i].getScore() + " " + uniqueWords[i].getFrequency());
        }
    }

    public int calcScore (word [] uniqueWords){
        int score = 0;
        for(int i = 0; i < uniqueWords.length; i++){
            score = score + uniqueWords[i].getScore();
        }
        return score;
    }

    public word [] getWords (String [] textStrings, word [] dict){
        //counter tells us how many words in the dictionary have we found so far
        //will tell us where in helper array to put the next one
        int numDictWords = 0;
        word [] helperArray = new word [textStrings.length];
        for (int i = 0; i < textStrings.length; i++){
            boolean found = false;
            for (int entry = 0; entry < dict.length; entry++){
                if(dict[entry].getWord().compareTo(textStrings[i]) == 0){
                   helperArray[numDictWords] = dict[entry];
                   numDictWords++;
                   found = true;
                   break;
                }
            }
        }

        //create another array of length word objects that I put (use counter)
        //go through helper array and move them to the new array
        word [] arr = new word [numDictWords];
        for (int j = 0; j < numDictWords; j++){
            arr[j] = helperArray[j];
        }

        return arr;
    }

    public static String[] alphabetize(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                // Compare the element originally at i with the one on its right
                if (arr[j - 1].compareTo(arr[j]) > 0) {
                    // Swap
                    String tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                } else // We found the correct place for the element in the
                    // sorted prefix from 0 up to i (included)
                    break;
            }
        }
        return arr;
    }

    public static word[] alphabetize_2 (word[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                // Compare the element originally at i with the one on its right
                if (arr[j - 1].getWord().compareTo(arr[j].getWord()) > 0) {
                    // Swap
                    word tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                } else // We found the correct place for the element in the
                    // sorted prefix from 0 up to i (included)
                    break;
            }
        }
        return arr;
    }

    public word [] addFrequency (word [] notUnique){
        //create an empty array
        word [] uniqueWords = new word[notUnique.length];
        int length = 0;
        //addToSet will add to the array if it doesn't exist or increment frequency if it does exist
        //for each position of the array, addToSet takes parameter of a word "notUnique" and empty array "uniqueWords"
        for (int i = 0; i < notUnique.length; i++) {
            length = addToSet(notUnique[i], uniqueWords);
        }
        word [] shortArray = new word [length];

        for(int j = 0; j < shortArray.length; j++){
            shortArray[j] = uniqueWords[j];
        }
        return shortArray;
    }

    public int addToSet(word toAdd, word [] arr){
        //check to see if it is in the array (call inSet)
        //if it is, do not add to array, only increment frequency
        int numCells = 0;
        while (arr[numCells] != null) {
            numCells++;
        }
        int index = find(toAdd,arr,numCells);
        //index that is returned == location for word in new array
        if(index != -1){
            arr[index].setFrequency(arr[index].getFrequency()+1);
        } else { //if its not in the array, add word to next empty position in the array
            //k starts at the beginning of the array and increments until it reaches a null index
            //toAdd will go there
            arr[numCells] = toAdd;
            numCells++;
        }
        return numCells;
    }

    public int find (word myWord, word [] arr, int max){
        //iterate through set at each place that my word is equal to that word return true
        //outside for loop return false
        for(int i = 0; i < max; i++){
            //System.out.println(arr[i].getWord());
            if(arr[i].getWord().compareTo(myWord.getWord())== 0) return i;
        }
        return -1;
    }
}




