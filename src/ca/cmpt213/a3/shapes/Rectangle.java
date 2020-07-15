package ca.cmpt213.a3.shapes;

public class Rectangle extends ShapeImpl{

    public Rectangle (int x, int y, int w, int h){
        super(x, y, w, h);
    }

    protected boolean isBorder(int x, int y){
        //return true if border
        if(super.getLocationX() == x) //top border
            return true;
        else if (super.getLocationY() == y) //left border
            return true;
        else if((super.getLocationX() + super.getWidth() - 1) == x) //right border
            return true;
        else if ((super.getLocationY() + super.getHeight() - 1) == y) //bottom border
            return true;

        //return false if not
        return false;
    }

    protected boolean isInside(int x, int y){
        //return true if inside
        if((super.getLocationX() < x) && ((super.getLocationX() + super.getWidth() - 1) > x))
            return true;
        else if ((super.getLocationY() < y) && ((super.getLocationY() + super.getHeight() - 1) > y))
            return true;

        //return false if not
        return false;
    }
}
