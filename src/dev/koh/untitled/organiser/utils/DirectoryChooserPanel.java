package dev.koh.untitled.organiser.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DirectoryChooserPanel extends JPanel {

    private JButton btn1;
    private JButton fileChooserBtn;
    private JLabel testLbl1;
    private JFileChooser fileChooser;
    private JTextField textField;

    {
        init();
    }

    DirectoryChooserPanel() {

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

        //  Instantiating the Components of the Directory Organiser.

        btn1 = new JButton();
        testLbl1 = new JLabel("Directory Path:");
        fileChooser = new JFileChooser();
        textField = new JTextField(20);

    }

    void resizeBtn() {

        System.out.println("x: " + btn1.getX() + " | Y : " + btn1.getY());
        System.out.println("x: " + textField.getPreferredSize().width + " | Y : " + textField.getPreferredSize().height);

        btn1.setSize(new Dimension(40, 20));
    }

    void updateIcon2() {
        //  Image Centered in the Btn.
        ImageIcon icon = new ImageIcon("res/Icons/directory_icon.png");
        Image img = icon.getImage();
        BufferedImage bi = new BufferedImage(40, 20, BufferedImage.TYPE_INT_ARGB);
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

}
