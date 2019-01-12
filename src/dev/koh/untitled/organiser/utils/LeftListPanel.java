package dev.koh.untitled.organiser.utils;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

class LeftListPanel extends JPanel {

    private List<FileListElement> filesList = null;

    {
        init();
    }

    LeftListPanel() {

        //  Setup Layout.
        setupLayout();

        //  Set the Border.
        setupBorder();

    }

    private void init() {

        //  Set the Minimum Size.
        Dimension minimum = new Dimension(640, 100);
        setMinimumSize(minimum);

    }

    void initializeList() {
        this.filesList = new LinkedList<>();

        filesList.add(new FileListElement("a1"));
        filesList.add(new FileListElement("a3"));
        filesList.add(new FileListElement("a5"));
        filesList.add(new FileListElement("a2"));
        filesList.add(new FileListElement("a4"));
    }

    private void addFileList() {
        //  Add The fileList to the LeftListPanel.
        for (FileListElement obj : this.filesList)
            add(obj);

        //  Applying validate method to ensure the components are added & displayed instantly.
        //  Otherwise, components are displayed when splitPane's divider is moved explicitly.
        this.validate();
    }

    private void setupBorder() {

        Border outterBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border innerBorder = BorderFactory.createEtchedBorder();
        setBorder(BorderFactory.createCompoundBorder(outterBorder, innerBorder));

    }

    private void setupLayout() {
        setLayout(new FlowLayout(FlowLayout.LEADING));
    }

    void showFiles(File currentDirectory) {
        addFileList();
        /*
        try {
            //  Using canonical Path i.e. removing '.', '..' & Symbolic Links with their
            //  Absolute Path.
            testLabel.setText(currentDirectory.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
         */
    }
}

class FileListElement extends JPanel {

    private static int serialNumber = 1;
    private JLabel fileName;
    private JCheckBox checkBox;
    private JTextField serialNumberTextField;

    {
        init();
        initializeListeners();
    }

    FileListElement(String fileName) {

        //  Initialize the fileName with each individual file while walking the file tree.
        this.fileName = new JLabel(fileName);

        setupLayout();

    }

    private void initializeListeners() {
        checkBox.addActionListener(this::checkBoxActionPerformed);
    }

    private void checkBoxActionPerformed(ActionEvent event) {

        if (checkBox.isSelected()) {
            System.out.println(fileName.getText());

            this.getSerialNumberTextField().setText(FileListElement.serialNumber++ + "");

        }

        if (!checkBox.isSelected()) {
            System.out.println("...");
            this.getSerialNumberTextField().setText("");
            FileListElement.serialNumber--;

            //  Fix the serial numbers of the List.
//            fixList();

        }

    }

    private void fixList() {

    }

    private void init() {
        //  Instantiate the other Components.
        checkBox = new JCheckBox();
        serialNumberTextField = new JTextField(4);
    }

    private void setupLayout() {

        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(serialNumberTextField);
        add(checkBox);
        add(fileName);
    }

    public JLabel getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName.setText(fileName);
    }

    public JCheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(JCheckBox checkBox) {
        this.checkBox = checkBox;
    }

    JTextField getSerialNumberTextField() {
        return serialNumberTextField;
    }

    public void setSerialNumberTextField(JTextField serialNumberTextField) {
        this.serialNumberTextField = serialNumberTextField;
    }

}
