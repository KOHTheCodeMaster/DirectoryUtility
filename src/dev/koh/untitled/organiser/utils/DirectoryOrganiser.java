package dev.koh.untitled.organiser.utils;

import javax.swing.*;
import java.awt.*;

public class DirectoryOrganiser extends JPanel {

    private JPanel directoryChooserPanel;
    private JPanel majorPanel;

    private boolean currentStatus;

    public DirectoryOrganiser(JPanel directoryChooserPanel) {

        //  Initialize the currentStatus attribute with false.
        //  It will be true when the directoryChooserPanel is ready with the current Directory Selected.
        this.currentStatus = false;

        //  Initialize the directoryChooserPanel with the one passed in argument by MainFrame.
        this.directoryChooserPanel = directoryChooserPanel;

        setupLayoutManager();
    }

    //  After setting the directoryChooserPanel for the directoryOrganiser, setup the layout manager.
    private void setupLayoutManager() {

        setLayout(new BorderLayout());
        add(directoryChooserPanel, BorderLayout.NORTH);

    }

    //  Begin the Organiser Panels.
    public void beginMajorPanel() {
        System.out.println("Major Panels Started!");
    }


    public boolean isCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(boolean currentStatus) {
        this.currentStatus = currentStatus;
    }
}














