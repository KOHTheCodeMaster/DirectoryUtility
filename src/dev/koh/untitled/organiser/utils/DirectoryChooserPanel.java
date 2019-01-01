package dev.koh.untitled.organiser.utils;

import dev.koh.untitled.MainFrame;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class DirectoryChooserPanel extends JPanel {

    private JButton btn1;
    private JButton fileChooserBtn;
    private JLabel testLbl1;
    private JFileChooser fileChooser;
    private JTextField textField;

    private Font font;

    {
        init();
        initializeEventListeners();
    }

    public DirectoryChooserPanel() {

        //  Setup Flow Layout.
        setupLayoutManager();

    }

    private void setupLayoutManager() {

        setLayout(new FlowLayout(FlowLayout.CENTER));

        add(testLbl1);
        add(textField);
        add(btn1);

    }

    private void init() {

        //  Setup the Size for the DirectoryChooserPanel.
        setupPanelSize();

        //  Instantiating the Components of the Directory Organiser.
        btn1 = new JButton();
        testLbl1 = new JLabel("Directory Path:");
        textField = new JTextField(40);

        //  Setup fileChooser.
        setupFileChooser();

        //  Initialize & Set the font for the components including testLbl1 & textField.
        setupFont();

        //  Set Image Icon to Btn1.
        setupImageIcon();

    }

    private void setupFileChooser() {

        //  Instantiate the fileChooser.
        fileChooser = new JFileChooser();


    }

    private void setupPanelSize() {

        //  setPreferredSize sets the Size for the layout manager.
        //  setSize sets the size for the individual component.

        //  Divide the HEIGHT of the MainFrame by number of Rows in DirectoryOrganiser i.e. 7.
        int height = MainFrame.getHEIGHT() / 7;

        setPreferredSize(new Dimension(200, height));

    }

    private void setupFont() {

        //  Instantiating the font component.
        font = new Font("Verdana", Font.PLAIN, 24);

        //  Apply font to testLbl1 & textField.
        testLbl1.setFont(font);
        textField.setFont(font);

    }

    //  Set the Image Icon for the btn1.
    private void setupImageIcon() {

        ImageIcon imageIcon = new ImageIcon("res/Icons/directory_icon2.png");
        Image img = imageIcon.getImage();
        Image newImage = img.getScaledInstance(imageIcon.getIconWidth(), imageIcon.getIconHeight(), Image.SCALE_SMOOTH);

        btn1.setIcon(new ImageIcon(newImage));

    }

    private void initializeEventListeners() {

        //  Handle the Actions to be performed when btn1 is clicked.
        btn1.addActionListener(this::btn1ActionPerformed);

    }

    private void btn1ActionPerformed(ActionEvent event) {

//        System.out.println("test msg.");
        File file = new File("res/Icons/directory_icon2.png");
        System.out.println("Video Extension: " + Utils.getExtension(file));

        if (Utils.isVideoFile(new File("a.mkv")))
            System.out.println("Video File.");

    }


    /*
    //  2 Methods used to adjust the image icon to the size of the JButton btn1.
    void updateIcon2() {
        //  Image Centered in the Btn.
        ImageIcon icon = new ImageIcon("res/Icons/directory_icon2.png");
        Image img = icon.getImage();
        BufferedImage bi = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.createGraphics();
        g.drawImage(img, 0, 0, null);
        icon = new ImageIcon(bi);
        btn1.setIcon(icon);
    }

    void updateIcon1() {
        //  Image Centered in the Btn.
        ImageIcon icon = new ImageIcon("res/Icons/directory_icon.png");
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(90, 30, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        btn1.setIcon(icon);
    }
    */
}

class videoFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {

        //  Allow the Directories to be shown in the FileChooser.
        if (f.isDirectory())
            return true;

//        Extension extension = Utils.getExtension(f);

        return (Utils.isVideoFile(f));
    }

    @Override
    public String getDescription() {
        return "Video Files";
    }
}
