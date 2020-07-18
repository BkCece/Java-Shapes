package ca.cmpt213.a3.shapes;

/**
 * Celina Wright
 * 301380112
 * ckwright@sfu.ca
 */

import ca.cmpt213.a3.UI.Canvas;

import java.util.ArrayList;
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

        //Add words to word list
        List<String> wordList = new ArrayList<>();
        for (int w = 0; w < words.length; w++) {
                wordList.add(words[w]);
        }

        //Adjust for preceding spaces
        if(getMessage().charAt(0) == ' '){
            wordList.remove(0);
            wordList.set(0, " " + wordList.get(0));
        }

        //System.out.println(wordList);

        //Initialize empty array to store each row's message
        String[] msgByRow = new String[super.getHeight() - 2];
        for (int m = 0; m < msgByRow.length; m++)
            msgByRow[m] = " ";

        //Determine which words are in each row
        for (int i = 0; i < msgByRow.length; i++) {

            //Compare the size of each word to available space
            while (wordList.size() > 0) {
                if (msgByRow[i].equals(" ")) {

                    //Check if the word needs to be wrapped
                    if((super.getWidth() - 2) < wordList.get(0).length()){

                        //Iterate through characters in the word
                        for(int l = 0; l < (super.getWidth() - 2); l++){
                            if (l == 0){
                                msgByRow[i] = Character.toString(wordList.get(0).charAt(0));

                            }else{
                                msgByRow[i] += Character.toString(wordList.get(0).charAt(0));
                            }

                            //Remove first char in the word
                            wordList.set(0, wordList.get(0).substring(1));
                        }

                    }else{
                        //Add word to row
                        msgByRow[i] = wordList.get(0) + " ";

                        //Remove word from list once placed
                        wordList.remove(0);
                    }

                } else if (((super.getWidth() - 2) - msgByRow[i].length()) >= wordList.get(0).length()) {
                    //Add word to row if it fits in available space
                    msgByRow[i] += wordList.get(0) + " ";

                    //Remove word from list once placed
                    wordList.remove(0);

                } else {
                    //move to next row
                    break;
                }
            }

            //Trim trailing spaces
            msgByRow[i] = msgByRow[i].stripTrailing();

            //Center the message row
            int numEmptySpaces = (super.getWidth() - 2) - msgByRow[i].length();

            //Check for free cells to fill with spaces
            if (numEmptySpaces != 0){
                for (int n = 0; n < numEmptySpaces/2; n++)
                    msgByRow[i] = " " + msgByRow[i] + " ";

                //Offset with extra space prepended, if uneven
                if(numEmptySpaces % 2 != 0)
                    msgByRow[i] = " " + msgByRow[i];
            }

//            System.out.println("Message for row " + i + "is: " + msgByRow[i]);
        }

        /**
         * Display the message to canvas
         */
        int row = 0;
        int col = 0;

        //Loop through all the cells
        for (int y = super.getLocationY() + 1; y < (super.getLocationY() + super.getHeight() - 1); y++) {
            for (int x = super.getLocationX() + 1; x < (super.getLocationX() + super.getWidth() - 1); x++) {
                    //Place the character from message at that row
                    canvas.setCellText(x, y, msgByRow[row].charAt(col));
                    col++;
            }
            row++;
            col = 0;
        }
    }

}
