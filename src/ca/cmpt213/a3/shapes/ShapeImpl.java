package ca.cmpt213.a3.shapes;

import java.awt.Color;
import ca.cmpt213.a3.UI.Canvas;

/**
 * Abstract class for base-level implementation of shared functionalities required by its derived classes
 */
abstract class ShapeImpl implements Shape{

    //Shape attributes
    private int locationX;
    private int locationY;
    private char borderChar = '*'; //default *
    private Color color = Color.blue; //default blue
    protected int width;
    protected int height;

    public ShapeImpl(int x, int y, int w, int h){
        this.locationX = x;
        this.locationY = y;
        this.width = w;
        this.height = h;
    }

    public int getLocationX(){
        return locationX;
    }
    public int getLocationY(){
        return locationY;
    }
    public void setBorderChar(char c){
        this.borderChar = c;
    }
    public char getBorderChar(){
        return borderChar;
    }
    public void setColor(Color color){
        this.color = color;
    }

    public Color getColor(){
        return color;
    }

    protected int getWidth(){
        return width;
    }
    protected int getHeight(){
        return height;
    }

    /**
     * Draws to the canvas
     * Sets cell colour and/or border character
     */
    public void draw(Canvas canvas){
        for(int x = locationX; x <= (locationX + width - 1); x++){
            for(int y = locationY; y <= (locationY + height - 1); y++){
                if(isBorder(x, y)){
                    //Coloured background and border character
                    canvas.setCellColor(x, y, getColor());
                    canvas.setCellText(x, y, getBorderChar());
                }else if(isInside(x, y)){
                    //Coloured background
                    canvas.setCellColor(x, y, getColor());
                    canvas.setCellText(x, y, ' ');
                }
                //else not drawn at all
            }
        }
    }

    protected abstract boolean isBorder(int x, int y);
    protected abstract boolean isInside(int x, int y);
}
