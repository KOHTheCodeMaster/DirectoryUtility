package dev.koh.untitled.organiser.utils;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

class LeftListPanel extends JPanel {

    static List<FileListElement> filesList = null;

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

    public static List<FileListElement> getFilesList() {
        return filesList;
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

            //  Set the serialNumber as the actionCommand for the checkBox.
            this.checkBox.setActionCommand(String.valueOf(FileListElement.serialNumber));

            //  Update the serialNumberTextField with the serialNumber.
            this.getSerialNumberTextField().setText(String.valueOf(FileListElement.serialNumber));

            //  Increment the serialNumber by 1.
            FileListElement.serialNumber++;
        }

        if (!checkBox.isSelected()) {
            //  Update the serialNumberTextField with the empty string.
            this.getSerialNumberTextField().setText("");

            String currentCheckBoxActionCommand = checkBox.getActionCommand();

            //  Decrement the serialNumber by 1.
            FileListElement.serialNumber--;

            System.out.println("Before");
            displayList();

            //  Fix the serial numbers of the List.
            fixList(currentCheckBoxActionCommand);

            System.out.println("After");
            displayList();

        }

    }

    //  Display filesList.
    private void displayList() {
        for (FileListElement obj : LeftListPanel.filesList) {
            if (!obj.getCheckBox().getActionCommand().equals("null")) {
                System.out.println(obj);
            }
        }
    }

    //  Remove that Element whose checkBox has been de-selected.
    private void fixList(String currentCB) {
        for (int i = 0; i < LeftListPanel.filesList.size(); i++) {

            FileListElement temp = LeftListPanel.filesList.get(i);

            if (temp.checkBox.getActionCommand().equals(currentCB)) {
                LeftListPanel.filesList.remove(temp);
                temp.getCheckBox().setActionCommand(null);
            }
        }
    }

    private void init() {
        //  Instantiate the other Components.
        checkBox = new JCheckBox();
        checkBox.setActionCommand("null");
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

    @Override
    public String toString() {
        return "fileName=" + fileName.getText() +
                ", serialNumberTextField=" + serialNumberTextField.getText() +
                ", checkBox: " + checkBox.getActionCommand();
    }
}
