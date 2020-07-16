package ca.cmpt213.a3.shapes;

import ca.cmpt213.a3.UI.Canvas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextBox extends Rectangle {
    private String message;

    public TextBox(int x, int y, int w, int h, String text) {
        super(x, y, w, h);
        this.message = text;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String text) {

        this.message = text;
    }

    /**
     * Draws rectangle
     * Fills inside with chosen message
     */
    public void draw(Canvas canvas) {
        //Draw rectangle first using ShapeImpl draw()
        super.draw(canvas);

        //Split message into words
        String[] words = getMessage().split(" ");
        List<String> wordList = new ArrayList<>();

        for (String word: words) {
            wordList.add(word);
        }

        String[] msgByRow = new String[super.getHeight() - 2];
        for (int m = 0; m < msgByRow.length; m++)
            msgByRow[m] = " ";

//        System.out.println(wordList);
//        System.out.println(wordList.size());
//        System.out.println(msgByRow.length);

        //If row size < word length

        //Determine which words are in each row
        for (int i = 0; i < msgByRow.length; i++) {

            //Compare the size of each word to available space
            while (wordList.size() > 0) {
                if (msgByRow[i].equals(" ")) {
                    //Check if the word needs to be wrapped
                    if((super.getWidth() - 2) < wordList.get(0).length()){

                        //Iterate through characters in the word
                        for(int l = 0; msgByRow[i].length() < (super.getWidth() - 2); l++){
                            if (l == 0)
                            msgByRow[i] = Character.toString(wordList.get(0).charAt(0));
                            else
                                msgByRow[i] += Character.toString(wordList.get(0).charAt(0));

                            //Remove first char in the word
                            wordList.set(0, wordList.get(0).substring(1));
                        }

                    }else{
                        //Add word to row
                        msgByRow[i] = wordList.get(0) + " ";

                        //Remove word from list once placed
                        wordList.remove(0);
                    }

//                    System.out.println("Message start: " + msgByRow[i] + ", words: " + wordList);

                } else if (((super.getWidth() - 2) - msgByRow[i].length()) >= wordList.get(0).length()) {
                    //Add word to row if it fits in available space
                    msgByRow[i] += wordList.get(0) + " ";

                    //Remove word from list once placed
                    wordList.remove(0);

//                    System.out.println("Message add: " + msgByRow[i] + ", words: " + wordList);

                } else {

                    //trim the trailing space
                    msgByRow[i].trim();


                     //prepend and append spaces to center text
                     int emptySpace = (super.getWidth() - 2) - msgByRow[i].length();

                     //Even number of spaces to distribute to start and end of row
                    for (int k = 0; k < emptySpace/2; k++){
                        msgByRow[i] = " " + msgByRow[i] + " ";
                    }

                     if(emptySpace % 2 != 0){
                     //Odd number of spaces to distribute
                         msgByRow[i] = " " + msgByRow[i];
                     }

                    System.out.println("Message for row " + i + "is: " + msgByRow[i]);

                    //move to next row
                    break;
                }
            }
//            System.out.println("Move to new row: " + msgByRow[i] + ", words: " + wordList);
        }

/**
        int row = 0;
        int col = 0;

        //Loop through all the cells
        for (int y = super.getLocationY() + 1; y < (super.getLocationY() + super.getHeight() - 1); y++) {
            for (int x = super.getLocationX() + 1; x < (super.getLocationX() + super.getWidth() - 1); x++) {
                //Check if at the end of the row's message string
                if (col == (super.getWidth() - 2)) {
                    row++;
                    col = 0;
                    break;
                } else {
                    //Place the character from message at that row
                    canvas.setCellText(x, y, msgByRow[row].charAt(col));
                    col++;
                }
            }

            //Check if all rows have been printed
            if (row == (super.getHeight() - 2))
                break;
        }
*/
    }

}
