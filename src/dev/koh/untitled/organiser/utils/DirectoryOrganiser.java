package dev.koh.untitled.organiser.utils;

import javax.swing.*;
import java.awt.*;

public class DirectoryOrganiser extends JPanel {

    private JPanel directoryChooserPanel;

    public DirectoryOrganiser(JPanel directoryChooserPanel) {
        this.directoryChooserPanel = directoryChooserPanel;

        setupLayoutManager();
    }

    //  After setting the directoryChooserPanel for the directoryOrganiser, setup the layout manager.
    private void setupLayoutManager() {

        setLayout(new BorderLayout());

        add(directoryChooserPanel, BorderLayout.NORTH);

    }

}














