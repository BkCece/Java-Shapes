package ca.cmpt213.a3.shapes;

public class Rhombus extends ShapeImpl{

    public Rhombus (int x, int y, int size){
        //Coordinates are top-left corner of bounding box
        //Size is numbers of cells on one side of the rhombus
        //All 4 sides are the same size
        //Pass the bounding box size as width and height
        super(x, y, (2 * size) - 1, (2 * size) - 1);
    }

    protected boolean isBorder(int x, int y){
        //Get 'radius' or side length of rhombus
        int radius = super.getWidth()/2;

        //Treat the rhombus like a circle
        //Track distance from the 'radius' to fin the border
        if(getDistance(x, y, super.getLocationX() + radius, super.getLocationY() + radius) == radius)
            return true;

        return false;

    }

    protected boolean isInside(int x, int y){
        //Get one cell less than the 'radius' or side length of rhombus
        int radius = super.getWidth()/2;

        //Treat the rhombus like a circle
        //Track distance from the 'radius' to fin the border
        if(getDistance(x, y, super.getLocationX() + radius, super.getLocationY() + radius) < radius)
            return true;

        return false;
    }

    /**
     * Gets the total distance between two cells
     */
    private int getDistance(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
