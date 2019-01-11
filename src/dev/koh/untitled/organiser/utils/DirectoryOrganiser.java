package dev.koh.untitled.organiser.utils;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class DirectoryOrganiser extends JPanel {

    private JPanel directoryChooserPanel;
    private LeftListPanel leftPanel;
    private RightListPanel rightPanel;
    private JSplitPane splitPane;

    private boolean currentStatus;

    private File currentDirectory;

    {
        init();
    }

    public DirectoryOrganiser(JPanel directoryChooserPanel) {

        //  Initialize the directoryChooserPanel with the one passed in argument by MainFrame.
        this.directoryChooserPanel = directoryChooserPanel;

        setupLayoutManager();
    }

    private void init() {

        //  Initialize the currentStatus attribute with false.
        //  It will be true when the directoryChooserPanel is ready with the current Directory Selected.
        this.currentStatus = false;

        //  Instantiate both the left & the right panels.
        leftPanel = new LeftListPanel();
        rightPanel = new RightListPanel();
        //  Initialize the splitPane with left & right panels.
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);

    }

    //  After setting the directoryChooserPanel for the directoryOrganiser, setup the layout manager.
    private void setupLayoutManager() {

        setLayout(new BorderLayout());
        add(directoryChooserPanel, BorderLayout.NORTH);
        add(splitPane, BorderLayout.CENTER);

    }

    //  Begin the Organiser Panels.
    public void fireStartMajorPanels(File currentDirectory) {

        //  Set the currentDirectory selected by directoryChooserPanel for DirectoryOrganiser.
        setCurrentDirectory(currentDirectory);

        //  Update the content of the Left & Right Panels.
        leftPanel.showFiles(currentDirectory);
    }

    public boolean isCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(boolean currentStatus) {
        this.currentStatus = currentStatus;
    }

    void setCurrentDirectory(File currentDirectory) {
        this.currentDirectory = currentDirectory;
    }
}














