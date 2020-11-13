public class textBlock {
    //while loop passes each comment into new textBlock =
    //comment will be passed as a single string
    //textBlock takes in comment as a string + splits it into individual strings
    //this will involve splitting each user input text into an array of text blocks (txt file of comments separated by lines)

    //textBlock constructor
    public textBlock(String textBlock, word [] words) {
        //call split method on a comment to create an array strings filled with each individual word
        String[] textStrings = textBlock.split(" ");

        //array of strings is sorted in alphabetical order
        //  advantages: occurrences of the same word are next to each other
        alphabetize(textStrings);

        //fill new array that replaces textStrings with words objects
        word [] textWords = getWords(textStrings, words);

        System.out.println("");
        System.out.println("userFile.txt words with corresponding score:");

        //test to ensure that words array (of textWords) is alphabetized
        for (int i = 0; i < textWords.length; i++){
            System.out.println(textWords[i].getWord() + " " + textWords[i].getScore());
        }
    }

    public word [] getWords (String [] textStrings, word [] dict){
        word [] helperArray = new word [textStrings.length];
        //this loop
        for (int i = 0; i < textStrings.length; i++){
            for (int entry = 0; entry < dict.length; entry++){
                if(dict[entry].getWord().compareTo(textStrings[i]) == 0){
                   helperArray[i] = dict[entry];
                   break;
                }
            }
        }
        //if we add frequency instance variable, we can create an array of word objects
        //update the frequency of the instance variable
        //create an array of words as long as the number of string in the block
        return helperArray;
    }

    public static String[] alphabetize(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                // Compare the element originally at i with the one on its right
                //System.out.println(arr[j-1] + " " + arr[j] + " " + arr[j - 1].compareTo(arr[j]));
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
                //System.out.println(arr[j-1] + " " + arr[j] + " " + arr[j - 1].compareTo(arr[j]));
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
}




