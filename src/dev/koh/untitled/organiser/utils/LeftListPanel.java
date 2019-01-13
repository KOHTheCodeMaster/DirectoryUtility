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

        filesList = new LinkedList<>();
    }

    //  Add the list of file extracted from the currentDirectory to the LeftListPanel.
    private void addFileList() {
        //  Add The fileList to the LeftListPanel.
        add(new FileListElement("a1"));
        add(new FileListElement("a2"));
        add(new FileListElement("a3"));
        add(new FileListElement("a4"));
        add(new FileListElement("a5"));

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

    //  Instantiate the Components.
    private void init() {
        checkBox = new JCheckBox();
        checkBox.setActionCommand("null");
        serialNumberTextField = new JTextField(4);
    }

    private void initializeListeners() {
        checkBox.addActionListener(this::checkBoxActionPerformed);
    }

    private void checkBoxActionPerformed(ActionEvent event) {

        //  When the checkBox is Selected.
        if (checkBox.isSelected()) {
            //  Set the serialNumber as the actionCommand for the checkBox.
            this.checkBox.setActionCommand(String.valueOf(FileListElement.serialNumber));

            //  Update the serialNumberTextField with the serialNumber.
            this.getSerialNumberTextField().setText(String.valueOf(FileListElement.serialNumber));

            //  this here refers to the current object of FileListItem whose checkBox is selected.
            LeftListPanel.filesList.add(this);

            //  Increment the serialNumber by 1.
            FileListElement.serialNumber++;
        }

        //  When the checkBox is De-Selected.
        if (!checkBox.isSelected()) {
            //  Update the serialNumberTextField with the empty string.
            this.getSerialNumberTextField().setText("");

            //  Extract the actionCommand from the checkBox & store it in currentCheckBoxActionCommand.
            String currentCheckBoxActionCommand = checkBox.getActionCommand();

            //  Parse the actionCommand from the checkBox into integer.
            //  tempSerialNumber will be set to -1 if the actionCommand of the checkBox which is
            //  currently deselected is not a valid Integer.
            int tempSerialNumber = currentCheckBoxActionCommand.equals("null") ? -1 :
                    Integer.parseInt(currentCheckBoxActionCommand);

            //  Unknown Case [Just in case purpose].
            if (tempSerialNumber == -1)
                System.out.println("Invalid Serial Number Encountered!");

            //  Decrement the serialNumber by 1.
            FileListElement.serialNumber--;

            System.out.println("Before");
            displayList();

            //  Fix the serial numbers of the List.
            fixList(currentCheckBoxActionCommand, tempSerialNumber);

            System.out.println("After");
            displayList();

        }

    }

    //  Display filesList.
    private void displayList() {
        for (FileListElement obj : LeftListPanel.filesList) {
            if (!obj.getCheckBox().getActionCommand().equals("null")) {
                System.out.println(obj);
            } else
                System.out.println("# : " + obj);
        }
    }

    //  Remove that Element whose checkBox has been de-selected.
    private void fixList(String currentCheckBoxActionCommand, int tempSerialNumber) {

        boolean nodeDeleted = false;

        /*
            currentCheckBoxActionCommand => actionCommand of that checkBox which is currently deselected.
            tempSerialNumber => integer value of the actionCommand of the node which needs to be deleted.
            Iterate through the filesList & remove the node whose checkBox's actionCommand
            is equal to the currentCheckBoxActionCommand.
            After removing the particular node, set the flag nodeDeleted to be true
            so that the Nodes ahead of the deleted node will be modified such that their serialNumber will be
            decremented by 1.
         */

        for (int i = 0; i < LeftListPanel.filesList.size(); i++) {

            //  Temporarily store the individual nodes of the filesList for each iteration in temp.
            FileListElement temp = LeftListPanel.filesList.get(i);

            //  If the checkBox has null value in its actionCommand that means it has not been selected yet,
            //  so return the control from the Loop.
            if (temp.getCheckBox().getActionCommand().equals("null")) {
                System.out.println("i: " + i);
                return;
            }

            /*
                If the Node is removed successfully & the value of tempSerialNumber ain't -1 then,
                Update the actionCommand & serialNumber in text field for all those Nodes whose actionCommand
                value is greater than the deleted Node.
             */
            if (nodeDeleted && tempSerialNumber != -1) {

                temp.getCheckBox().setActionCommand(tempSerialNumber + "");
                temp.getSerialNumberTextField().setText(tempSerialNumber + "");

                //  Increment the tempSerialNumber by 1.
                tempSerialNumber++;

//                System.out.println("! : " + temp.getCheckBox().getActionCommand());

                //  Continue the loop for the next Node to fix its actionCommand & serialNumber in text field.
                continue;
            }

            if (temp.checkBox.getActionCommand().equals(currentCheckBoxActionCommand)) {

                //  Remove the particular node.
                LeftListPanel.filesList.remove(temp);

                /*
                    After removing the Node, each successive node is automatically shifted 1 position to
                    the left, so explicitly decrementing the value of i by 1 to  reach the next node which
                    takes place of the deleted node as i will be incremented again in next iteration.
                 */
                i--;

                //  Set the Flag to true after removing the node.
                nodeDeleted = true;

            }
        }
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
