package ca.cmpt213.a3.UI;

import ca.cmpt213.a3.shapes.Shape;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PicturePanel extends JPanel{

    private static final int BORDER_WIDTH = 2;

    private Canvas canvas;
    private List<Shape> shapes = new ArrayList<>();
    private String title;

    public PicturePanel(String title, int sizeX, int sizeY) {
        this.title = title;
        canvas = new Canvas(sizeX, sizeY);

        // Setup the JPanel base class
        setBorder(BorderFactory.createLineBorder(Color.BLUE, BORDER_WIDTH));
        setLayout(new BorderLayout());

        add(new JLabel(title), BorderLayout.NORTH);

        CanvasIcon icon = new CanvasIcon(canvas);
        add(new JLabel(icon), BorderLayout.CENTER);
    }

    public String getTitle() {
        return title;
    }

    public void addFront(Shape shape) {
        // Add the shape at the end of the list so it's drawn last (top/front)
        shapes.add(shape);
        redraw();
    }

    public void addBack(Shape shape) {
        // Place shape at start of list so it's drawn first (bottom/back).
        shapes.add(0, shape);
        redraw();
    }

    private void redraw() {
        for (Shape shape : shapes) {
            shape.draw(canvas);
        }
    }

    public void writePictureToFile(String path) {
        File file = new File(path);
        try {
            FileWriter writer = new FileWriter(file);
            for (int y = 0; y < canvas.getSizeY(); y++) {
                for (int x= 0; x < canvas.getSizeX(); x++) {
                    Color color = canvas.getCellColor(x, y);
                    String colorChar = colourToString(color);
                    char text = canvas.getCellText(x, y);
                    writer.write(colorChar + text + ", ");
                }
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String colourToString(Color color) {
        if (color == Color.WHITE) return " ";		// Background is white, so display nothing.
        if (color == Color.LIGHT_GRAY) return "L";
        if (color == Color.GRAY) return "G";
        if (color == Color.DARK_GRAY) return "D";
        if (color == Color.BLACK) return "B";
        if (color == Color.RED) return "R";
        if (color == Color.PINK) return "P";
        if (color == Color.ORANGE) return "O";
        if (color == Color.YELLOW) return "Y";
        if (color == Color.GREEN) return "G";
        if (color == Color.MAGENTA) return "M";
        if (color == Color.CYAN) return "C";
        if (color == Color.BLUE) return "U";
        return "?";
    }

}
