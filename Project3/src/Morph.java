// Rachael Metzger, Josh Stainbach
// CS 335
// Project 3
// Due 11/19
// Morph
// ---------------------------------------------
// test
// The code below is the start to an image
// morphing interface.
// In this design, there will be two panels
// that will show a 10x10 triangle grid that
// have a movable point on the inner most
// corner of each grid space. There will be
// will be two buttons to select the left and
// right panel, a morph button, and a preview
// morph button. We will also implement a
// JSlider that will allow the user to adjust
// the grid size in later designs
// ---------------------------------------------
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Morph extends JFrame {
    // Container
    private Container c;
    // JPanel
    private JPanel settingsPanel, morph1Panel, morph2Panel;
    // JButton
    private JButton LeftImage, RightImage, StartMorph, PreviewMorph;
    // JLabel
    private JLabel gridSizeLabel;
    // JSlider
    private JSlider GridSlider;
    // JMenuBar
    private JMenuBar bar;
    // JMenu
    private JMenu fileMenu;
    // JMenuItem
    private JMenuItem fileOpen, fileExit;
    // ints
    private int gridSizeVal = 10;
    // Grid Class
    private Grid drawGrid;


    public Morph(){
        // Allocate panels -----------------------------------------
        c = getContentPane();
        settingsPanel = new JPanel();
        morph1Panel = new JPanel();
        morph2Panel = new JPanel();

        // Set Panel Sizes -----------------------------------------
        settingsPanel.setPreferredSize(new Dimension(1000,100));
        morph1Panel.setPreferredSize(new Dimension(500,500));
        morph2Panel.setPreferredSize(new Dimension(500,500));

        // Grid Layout ---------------------------------------------
        GridLayout grid = new GridLayout(1,6);
        settingsPanel.setLayout(grid);

        // JMenu file -------------------------------------------------
        final JFileChooser fileChooser = new JFileChooser(".");
        bar = new JMenuBar();
        this.setJMenuBar(bar);
        fileMenu = new JMenu("File");
        fileOpen = new JMenuItem("Open");
        fileExit = new JMenuItem("Exit");
        fileOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // this will connect to image object just like
                // exercise 4
            }
        });
        fileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        fileMenu.add(fileOpen);
        fileMenu.add(fileExit);
        bar.add(fileMenu);

        // Settings Panel Setup ---------------------------------------
        // JButtons----------------------------------------------------
        LeftImage = new JButton("Left Morph Image");
        RightImage = new JButton("Right Morph Image");
        StartMorph = new JButton("Start Morph");
        PreviewMorph = new JButton("Preview Morph");
        LeftImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // select left panel to work on
            }
        });
        RightImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // select right panel to wokr on
            }
        });
        StartMorph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // start morph
            }
        });
        PreviewMorph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // preview morph image
            }
        });
        // JLabel------------------------------------------------------
        gridSizeLabel = new JLabel("Grid Size: " + gridSizeVal );

        // JSlider-----------------------------------------------------
        GridSlider = new JSlider(SwingConstants.HORIZONTAL,5,10,10 );
        GridSlider.setMajorTickSpacing(1);
        GridSlider.setPaintTicks(true);
        GridSlider.setPaintLabels(true);
        GridSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                gridSizeVal = GridSlider.getValue();
                gridSizeLabel.setText("Grid Size: " + gridSizeVal);
            }
        });
        // add to settingsPanel----------------------------------------
        settingsPanel.add(LeftImage);
        settingsPanel.add(RightImage);
        settingsPanel.add(StartMorph);
        settingsPanel.add(PreviewMorph);
        settingsPanel.add(gridSizeLabel);
        settingsPanel.add(GridSlider);

        // add grids to morph panels ----------------------------------
        drawGrid = new Grid();
        morph1Panel.add(drawGrid);
        drawGrid = new Grid();
        morph2Panel.add(drawGrid);

        // add to Container--------------------------------------------
        c.add(morph1Panel, BorderLayout.WEST);
        c.add(morph2Panel, BorderLayout.EAST);
        c.add(settingsPanel, BorderLayout.SOUTH);

        // Container settings------------------------------------------
        this.setName("Morph");
        this.setSize(1100,650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // Window ---------------------------------------------------------
    public static void main(String args[]){
        Morph M = new Morph();
        M.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
