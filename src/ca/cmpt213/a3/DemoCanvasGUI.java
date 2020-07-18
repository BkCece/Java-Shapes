package ca.cmpt213.a3;

/**
 * Celina Wright
 * 301380112
 * ckwright@sfu.ca
 */

import ca.cmpt213.a3.UI.Canvas;
import ca.cmpt213.a3.UI.CanvasIcon;

import javax.swing.*;
import java.awt.*;


/**
 * Demo program showing how to use a Canvas
 */
public class DemoCanvasGUI {
    // Default size of the panels
    private static final int SIZE_X = 12;
    private static final int SIZE_Y = 15;

    public static void main(String[] args) {
        // Sample function showing use of Canvas, which will be needed when writing your Shapes.
        Canvas canvas = new Canvas(SIZE_X, SIZE_Y);
        sampleDraw(canvas);


        // You may ignore the rest of this function.
        // - the JFrame is creating the graphical UI
        // - the JLabel and CanvasIcon are what PicturePanel will do for you to display your shape
        // - other calls setup the GUI's window's behaviour
        JFrame frame = new JFrame();
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
        frame.add(new JLabel(new CanvasIcon(canvas)));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    /**
     * Demonstrate the use of a Canvas, in the same way that your Shape objects must interact with Canvas.
     * Each of your shape objects must have a draw(...) method which accepts a Canvas to draw itself into.
     * Use the Canvas's methods to set cell colours and text in order to draw your shapes.
     */
    private static Canvas sampleDraw(Canvas canvas) {
        // Draw characters onto the canvas
        canvas.setCellText(0, 0, 'S');
        canvas.setCellText(1, 1, '!');
        canvas.setCellText(canvas.getSizeX()-1, canvas.getSizeY()-1, 'B');

        // Setting cell colours in the canvas
        for (int i = 0; i < 5; i++) {
            canvas.setCellColor(i + 3, 8, Color.RED);
            canvas.setCellColor(5, i + 6, Color.GREEN);
        }

        // Setting cell colour and text:
        for (int i = 0; i < 5; i++) {
            int pos = i + 9;
            canvas.setCellColor(pos, pos, Color.YELLOW);
            canvas.setCellText(pos, pos, (char)('A' + i));
        }

        // Trying to draw off the canvas is just ignored
        // (useful when drawing a shape beyond the bounds of the canvas; you
        //  can ignore the fact that it's off the page!)
        canvas.setCellText(canvas.getSizeX(), canvas.getSizeY(), 'E');

        return canvas;
    }
}

