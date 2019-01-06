package dev.koh.untitled.organiser.utils;

import dev.koh.untitled.MainFrame;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class DirectoryChooserPanel extends JPanel {

    private JButton directoryChooserBtn;
    //    private JButton fileChooserBtn;
    private JLabel directoryPathLabel;
    private JFileChooser directoryChooser;
    private JTextField directoryPathTextField;

    private File currentDirectory;

    {
        init();
        initializeEventListeners();
    }

    public DirectoryChooserPanel() {

        //  Setup Flow Layout.
        setupLayoutManager();

    }

    private void setupLayoutManager() {

        setLayout(new FlowLayout(FlowLayout.CENTER));

        add(directoryPathLabel);
        add(directoryPathTextField);
        add(directoryChooserBtn);

    }

    private void init() {

        //  Setup the Size for the DirectoryChooserPanel.
        setupPanelSize();

        //  Instantiating the Components of the Directory Organiser.
        directoryChooserBtn = new JButton();
        directoryPathLabel = new JLabel("Directory Path:");
        directoryPathTextField = new JTextField(40);

        directoryChooser = new JFileChooser();

        //  Initialize & Set the font for the components including directoryPathLabel & directoryPathTextField.
        setupFont();

        //  Set Image Icon to directoryChooserBtn.
        setupImageIcon();

    }

    private void setupDirectoryChooser() {
        //  Instantiate the directoryChooser such that it displays only Directories.
        directoryChooser.setFileFilter(new DirectoryFilter());

        //  Allow directoryChooser to select only Directory.
        directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    }

    private void setupPanelSize() {

        //  setPreferredSize sets the Size for the layout manager.
        //  setSize sets the size for the individual component.

        //  Divide the HEIGHT of the MainFrame by number of Rows in DirectoryOrganiser i.e. 7.
        int height = MainFrame.getHEIGHT() / 7;

        setPreferredSize(new Dimension(200, height));

    }

    private void setupFont() {

        //  Instantiating the font component.
        Font font = new Font("Verdana", Font.BOLD, 24);

        //  Apply font to directoryPathLabel & directoryPathTextField.
        directoryPathLabel.setFont(font);
        directoryPathTextField.setFont(font);

    }

    //  Set the Image Icon for the directoryChooserBtn.
    private void setupImageIcon() {

        ImageIcon imageIcon = new ImageIcon("res/Icons/directory_icon2.png");
        Image img = imageIcon.getImage();
        Image newImage = img.getScaledInstance(imageIcon.getIconWidth(), imageIcon.getIconHeight(), Image.SCALE_SMOOTH);

        directoryChooserBtn.setIcon(new ImageIcon(newImage));

    }

    private void initializeEventListeners() {

        //  Handle the Actions to be performed when directoryChooserBtn is clicked.
        directoryChooserBtn.addActionListener(this::directoryChooserBtnActionPerformed);

    }

    private void directoryChooserBtnActionPerformed(ActionEvent event) {

        //  Setup directoryChooser.
        setupDirectoryChooser();

        //  Open Dialog Box for Directory Selection.
        int selectedValue = directoryChooser.showOpenDialog(getParent());

        //  Ensure the selected file is a Directory & Update the currentDirectory attribute.
        validateChosenDirectory(selectedValue);

        //  Update the Directory Path Text Field.
        directoryPathTextField.setText(this.getCurrentDirectory().getAbsolutePath());

    }

    private void validateChosenDirectory(int selectedValue) {

        //  Temporary variable for the selected directory.
        File selectedDirectory = null;

        //  Get the Selected Directory from the directoryChooser.
        if (selectedValue == JFileChooser.APPROVE_OPTION)
            selectedDirectory = directoryChooser.getSelectedFile();

        //  Ensure that the selectedDirectory is not null.
        assert selectedDirectory != null;

        //  Update the currentDirectory attribute of the DirectoryChooserPanel to the selectedDirectory.
        if (selectedDirectory.isDirectory())
            this.setCurrentDirectory(selectedDirectory);

    }

    /*
    //  2 Methods used to adjust the image icon to the size of the JButton directoryChooserBtn.
    void updateIcon2() {
        //  Image Centered in the Btn.
        ImageIcon icon = new ImageIcon("res/Icons/directory_icon2.png");
        Image img = icon.getImage();
        BufferedImage bi = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.createGraphics();
        g.drawImage(img, 0, 0, null);
        icon = new ImageIcon(bi);
        directoryChooserBtn.setIcon(icon);
    }

    void updateIcon1() {
        //  Image Centered in the Btn.
        ImageIcon icon = new ImageIcon("res/Icons/directory_icon.png");
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(90, 30, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        directoryChooserBtn.setIcon(icon);
    }
    */

    //      ||  Getters & Setters  ||


    File getCurrentDirectory() {
        return currentDirectory;
    }

    void setCurrentDirectory(File currentDirectory) {
        this.currentDirectory = currentDirectory;
    }
}

class DirectoryFilter extends FileFilter {

    static final String approveBtnText;

    static {
        approveBtnText = "Select Directory";
    }

    @Override
    public boolean accept(File f) {
        //  Allow only the Directories to be shown in the FileChooser.
        return f.isDirectory();
    }

    @Override
    public String getDescription() {
        return "Only Directory";
    }
}

class VideoFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {

        //  Allow the Directories to be shown in the FileChooser.
        if (f.isDirectory())
            return true;

        return (Utils.isVideoFile(f));
    }

    @Override
    public String getDescription() {
        return "Video Files";
    }
}
