import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel {

    public Grid(){
        this.setMaximumSize(new Dimension(500,500));
        this.setPreferredSize(new Dimension(500,500));
    }

    // Paint component --------------------------------------------------
    public void paint(Graphics g){
        drawGrid(g);
        drawPoints(g);
    }
    // draw Grid --------------------------------------------------------
    public void drawGrid(Graphics g){
        // takes care of creating the grid and the cross line
        // for each square
        int HSize = (500-20)/10;
        int WSize = (500-20)/10;
        Graphics2D g2 = (Graphics2D) g;

        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++) {
                // set color and thickness
                g2.setColor(Color.black);
                //g2.setStroke(new BasicStroke((height + width) / (rows * cols)));

                // north line
                g2.drawLine(i * WSize, j * HSize, (i + 1) * WSize, (j) * HSize);
                // south Line
                g2.drawLine((i) * WSize, (j + 1) * HSize, (i + 1) * WSize, (j + 1) * HSize);
                // west Line
                g2.drawLine(i * WSize, j * HSize, i * WSize, (j + 1) * HSize);
                // east Line
                g2.drawLine((i + 1) * WSize, (j) * HSize, (i + 1) * WSize, (j + 1) * HSize);
                // diagonal Line
                g2.drawLine(i * WSize, j * HSize, (i +1) * WSize, ( j + 1) * HSize);
            }
    }

    public void drawPoints(Graphics g){
        // takes care of finding the inner corners
        // and drawing a dot
        int HSize = (500-20)/10;
        int WSize = (500-20)/10;
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.blue);
        g2.setStroke(new BasicStroke(10));

        for (int i = 0; i < 10; i ++){
            for (int j = 0; j < 10; j++){
                // top row
                if (i < 10-1){
                    if (j < 10-1){
                        g2.drawLine((i +1) * WSize, ( j + 1) * HSize, (i +1) * WSize, ( j + 1) * HSize);
                    }
                }
            }
        }
    }

}
