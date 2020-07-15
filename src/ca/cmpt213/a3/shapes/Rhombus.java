package ca.cmpt213.a3.shapes;

public class Rhombus extends ShapeImpl{

    public Rhombus (int x, int y, int size){
        //Side lengths are all the same for a rhombus
        //Size is like a 'radius' for the rhombus
        super(x, y, size, size);
    }

    protected boolean isBorder(int x, int y){


        return true;
    }

    protected boolean isInside(int x, int y){
        return true;
    }
}
