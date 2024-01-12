// import the necessary packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// create a class that extends JFrame
public class SampleGUI extends JFrame {

    // declare the components
    private JMenuBar menuBar;
    private JMenu fileMenu, editMenu, helpMenu;
    private JMenuItem openItem, saveItem, exitItem, copyItem, pasteItem, aboutItem;
    private JLabel label;

    // constructor
    public SampleGUI() {
        // set the title, size and default close operation of the frame
        setTitle("Sample GUI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create the menu bar and the menus
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");

        // set the mnemonics for the menus
        fileMenu.setMnemonic(KeyEvent.VK_F);
        editMenu.setMnemonic(KeyEvent.VK_E);
        helpMenu.setMnemonic(KeyEvent.VK_H);

        // create the menu items and set the accelerators
        openItem = new JMenuItem("Open");
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        saveItem = new JMenuItem("Save");
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        exitItem = new JMenuItem("Exit");
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
        copyItem = new JMenuItem("Copy");
        copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        pasteItem = new JMenuItem("Paste");
        pasteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
        aboutItem = new JMenuItem("About");
        aboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));

        // add the menu items to the menus
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        helpMenu.add(aboutItem);

        // add the menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        // set the menu bar for the frame
        setJMenuBar(menuBar);

        // create a label to display the selected menu item
        label = new JLabel("No menu item selected");

        // add the label to the center of the frame
        add(label, BorderLayout.CENTER);

        // create an action listener for the menu items
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get the source of the event
                JMenuItem source = (JMenuItem) e.getSource();

                // set the text of the label to the text of the source
                label.setText(source.getText());
            }
        };

        // add the action listener to the menu items
        openItem.addActionListener(listener);
        saveItem.addActionListener(listener);
        exitItem.addActionListener(listener);
        copyItem.addActionListener(listener);
        pasteItem.addActionListener(listener);
        aboutItem.addActionListener(listener);
    }

    // main method
    public static void main(String[] args) {
        // create an instance of the class
        SampleGUI gui = new SampleGUI();

        // make the frame visible
        gui.setVisible(true);
    }
}