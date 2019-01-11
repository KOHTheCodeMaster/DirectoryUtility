package dev.koh.untitled.organiser.utils;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class LeftListPanel extends JPanel {

    private JLabel testLabel;

    {
        init();
    }

    LeftListPanel() {

        //  Setup Layout.
        setupLayout();

        //  Set the Border.
        setupBorder();

    }

    private void init() {

        //  Instantiate the testLabel.
        testLabel = new JLabel();

        //  Set the Minimum Size.
        Dimension minimum = new Dimension(640, 100);
        setMinimumSize(minimum);

    }

    private void setupBorder() {

        Border outterBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border innerBorder = BorderFactory.createEtchedBorder();
        setBorder(BorderFactory.createCompoundBorder(outterBorder, innerBorder));

    }

    private void setupLayout() {
        setLayout(new FlowLayout(FlowLayout.LEADING));
        add(testLabel);
    }

    void showFiles(File currentDirectory) {
        try {
            //  Using canonical Path i.e. removing '.', '..' & Symbolic Links with their
            //  Absolute Path.
            testLabel.setText(currentDirectory.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
