package dev.koh.untitled.organiser.utils;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

class RightListPanel extends JPanel {

    private String testLabel;

    {
        init();
    }

    RightListPanel() {

        //  Setup Layout.
        setupLayout();

        //  Set the Etched Border.
        setupBorder();
    }

    private void init() {

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

        setLayout(new GridBagLayout());

    }
}
