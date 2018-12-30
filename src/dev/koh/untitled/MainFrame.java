package dev.koh.untitled;

import javax.swing.*;
import java.awt.*;

class MainFrame extends JFrame {

    //  Dimensions of the MainFrame.
    private static final int HEIGHT = 720;
    private static final int WIDTH = 1280;

    private StartPanel startPanel;

    private CardLayout cards;

    MainFrame(String title) throws HeadlessException {

        //  Set the title for the MainFrame.
        super(title);

        init();

        //  Set the Default Frame Settings.
        setupDefaultFrameSettings();

        //  Set the Layout Manager.
        setupLayoutManager();

    }

    //  Launch the Organiser Card when the Organiser Button of startPanel is clicked.
    private static void launchOrganiser() {
        System.out.println("Launching the App!");
    }

    private static void launchAppMsg2() {
        System.out.println("Launching the App2!");
    }

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

    private void init() {

        //  Instantiating the startPanel.
        startPanel = new StartPanel();

        initializeListeners();

//        cardLayout = new CardLayout();
//        setLayout(cardLayout);
//        add(startPanel, "startPanel");
//        add(textPanel, "textPanel");

    }

    private void initializeListeners() {

        startPanel.setStartPanelListener(MainFrame::launchOrganiser);

    }

    //  Display the message in the Console during Startup of the App.

    private void setupLayoutManager() {
        cards = new CardLayout();
        setLayout(cards);
        add(startPanel, "startPanel");
    }

    //  setupDefaultFrameSettings() is used to setup the frame settings.

}
