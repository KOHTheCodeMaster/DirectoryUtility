package dev.koh.untitled;

import javax.swing.*;
import java.awt.*;

class MainFrame extends JFrame {

    //  Dimensions of the MainFrame.
    private static final int HEIGHT = 720;
    private static final int WIDTH = 1280;

    MainFrame(String title) throws HeadlessException {

        //  Set the title for the MainFrame.
        super(title);

        setupDefaultFrameSettings();

    }

    //  setupDefaultFrameSettings() is used to setup the frame settings.
    private void setupDefaultFrameSettings() {

        //  Set Dimensions for the MainFrame.
        Dimension frameDimensions = new Dimension(WIDTH, HEIGHT);
        setSize(frameDimensions);

        //  Set Default Close Operation to be Exit.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //  Set Default Position of MainFrame on startup to be at the Centre of the Screen.
        setLocationRelativeTo(null);

        //  Set the MainFrame visibility to be True.
        setVisible(true);

    }
}













