package dev.koh.untitled;

import dev.koh.untitled.organiser.utils.DirectoryChooserPanel;
import dev.koh.untitled.organiser.utils.DirectoryOrganiser;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    //  Dimensions of the MainFrame.
    private static final int HEIGHT = 720;
    private static final int WIDTH = 1280;

    private StartPanel startPanel;
    private DirectoryOrganiser directoryOrganiser;
    private DirectoryChooserPanel directoryChooserPanel;

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

    private static void launchAppMsg2() {
        System.out.println("Launching the App2!");
    }

    private void init() {

        //  Instantiating the startPanel.
        startPanel = new StartPanel();

        setupDirectoryOrganiser();

        initializeListeners();

//        cardLayout = new CardLayout();
//        setLayout(cardLayout);
//        add(startPanel, "startPanel");
//        add(textPanel, "textPanel");

    }

    private void setupDirectoryOrganiser() {
        //  Instantiating the directoryChooserPanel.
        directoryChooserPanel = new DirectoryChooserPanel();

        //  Instantiating the directoryOrganiser.
        directoryOrganiser = new DirectoryOrganiser(directoryChooserPanel);

    }

    //  Display the message in the Console during Startup of the App.

    private void initializeListeners() {

        //  Switch Card to the directoryOrganiser when the startPanel btn is clicked.
        startPanel.setStartPanelListener(this::launchOrganiser);

        //  Update the currentStatus of the directoryOrganiser when the
        //  directoryChooserPanel is ready with the current Directory.
        directoryChooserPanel.setCurrentStatusListener((boolean b) -> {
            directoryOrganiser.setCurrentStatus(b);
            directoryOrganiser.beginMajorPanel();
        });

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

    private void setupLayoutManager() {
        cards = new CardLayout();
        setLayout(cards);
        add(startPanel, "startPanel");
        add(directoryOrganiser, "directoryOrganiser");
    }

    //  Launch the Organiser Card when the Organiser Button of startPanel is clicked.
    private void launchOrganiser() {
        cards.show(this.getContentPane(), "directoryOrganiser");
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static int getWIDTH() {
        return WIDTH;
    }
}
