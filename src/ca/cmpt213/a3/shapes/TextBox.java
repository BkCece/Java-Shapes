package ca.cmpt213.a3.shapes;

import ca.cmpt213.a3.UI.Canvas;

public class TextBox extends Rectangle{
    private String message;

    public TextBox(int x, int y, int w, int h, String text){
        super(x, y, w, h);
        this.message = text;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String text){
        this.message = text;
    }

    public void draw(Canvas canvas){

    }
}
