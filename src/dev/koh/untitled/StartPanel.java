package dev.koh.untitled;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class StartPanel extends JPanel {

    private StartPanelListener startPanelListener;

    private JButton testBtn1;
    private JLabel testLbl1;

    private Font font;
    private GridBagConstraints gbc;

    StartPanel() {

        init();

        setLayoutManager();

    }

    private void init() {


        //  Instantiating the Test Label.
        testLbl1 = new JLabel("Welcome To File Utility Centre.");

        //  Instantiating the Button.
        testBtn1 = new JButton("File Organiser");

        //  Instantiating the font.
        font = new Font("Verdana", Font.BOLD, 20);

        initializeGridBagConstraints();

        setupActionListeners();

    }

    private void setupActionListeners() {

        testBtn1.addActionListener(this::actionPerformed);

    }

    private void setLayoutManager() {

        //  Set the layout as GridBagLayout.
        setLayout(new GridBagLayout());

        setupGridBagLayout();

    }

    private void setupGridBagLayout() {

        //          ROW 1.
        adjustTestLbl1();

        //          ROW 2.
        adjustTestBtn1();

    }

    private void adjustTestLbl1() {

        this.testLbl1.setFont(this.font);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(this.testLbl1, gbc);

    }

    private void adjustTestBtn1() {

        testBtn1.setFont(font);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(testBtn1, gbc);

    }

    private void initializeGridBagConstraints() {

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.NONE;

    }

    private void fireStartOrganiser() {
        if (startPanelListener != null)
            startPanelListener.launchApp();
    }

    public void setStartPanelListener(StartPanelListener startPanelListener) {
        this.startPanelListener = startPanelListener;
    }

    //  Action Performed by btn1.
    private void actionPerformed(ActionEvent event) {
        fireStartOrganiser();
    }
}
