package ca.cmpt213.a3.shapes;

/**
 * Celina Wright
 * 301380112
 * ckwright@sfu.ca
 */

import ca.cmpt213.a3.UI.Canvas;

import java.awt.Color;

/**
 * Interface specifying methods that need to be supported in order to draw them onto the canvas
 * Each shape location is the top left X & Y coordinates as integers
 * All shapes are drawn with a border (character) and have a coloured background
 * draw() method allows and shape object to draw itself onto a passed canvas
 */
public interface Shape {
    int getLocationX();
    int getLocationY();
    void setBorderChar(char c);
    char getBorderChar();
    void setColor(Color color);
    Color getColor();
    void draw(Canvas canvas);
}
