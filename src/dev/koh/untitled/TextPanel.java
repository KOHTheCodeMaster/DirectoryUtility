package dev.koh.untitled;

import javax.swing.*;
import java.awt.*;

class TextPanel extends JPanel {
//    Time Stamp: 30th December 2K18, 09:34 PM..!!

    private static final int ROWS;
    private static final int COLUMNS;

    //  Initializing the static final members i.e. ROWS & COLUMNS in the Static Initialization Block.
    static {
        ROWS = 10;
        COLUMNS = 20;
    }

    private TextArea textArea;

    TextPanel() {

        // Initialize the textArea.
        init();

        //  Setup the layout manager for the TextPanel.
        setupLayoutManager();

    }

    private void setupLayoutManager() {

        //  Set the Layout as BorderLayout.
        setLayout(new BorderLayout());

        //  Add the textArea component to the TextPanel in the Centre.
        add(textArea, BorderLayout.CENTER);

    }

    private void init() {
        //  Instantiate the textArea.
        this.textArea = new TextArea(ROWS, COLUMNS);
    }

}














