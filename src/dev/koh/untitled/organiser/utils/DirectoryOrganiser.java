package dev.koh.untitled.organiser.utils;

import javax.swing.*;
import java.awt.*;

public class DirectoryOrganiser extends JPanel {

    private DirectoryChooserPanel directoryChooserPanel;

    public DirectoryOrganiser() {

        //  Instantiating the Components of DirectoryOrganiser.
        directoryChooserPanel = new DirectoryChooserPanel();

        setupLayoutManager();

    }


    private void setupLayoutManager() {

        setLayout(new BorderLayout());

        add(directoryChooserPanel, BorderLayout.NORTH);

    }


}














