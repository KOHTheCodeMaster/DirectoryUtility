package dev.koh.untitled.organiser.utils;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;

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
        Dimension minimum = new Dimension(200, 100);
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
        testLabel.setText(currentDirectory.getName());

    }
}
