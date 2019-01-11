package dev.koh.untitled;

import javax.swing.*;

public class App {

    //  Time Stamp: 30th December 2K18, 08:49 PM..!!
    public static void main(String[] args) {

        System.out.println("Begin.");

        //  Using Lambda Expression for instantiating Runnable Interface.
        Runnable runnable = () -> new MainFrame("Untitled..!!");

        //  Launching App while handling the Multi-threaded Events using SwingUtilities.invokeLater method
        //  which takes in an instance of Runnable Interface.
        SwingUtilities.invokeLater(runnable);

        System.out.println("\nEnd.");
    }
}

/*
 *  Date Created: 30th December 2K18, 08:49 PM..!!
 *  Last Modified: 11th January 2K19, 09:10 PM..!!
 *
 *  Latest Update:
 *  Commit 11th:
 *      1. Updated directoryPathTextField such that if any invalid directory is provided explicitly
 *         then it'll simply set the currentDirectory to null & no processing will start.
 *      2. Updated the Minimum Width of the LeftListPanel to 640.
 *
 *  Change Log:
 *  Init Commit:
 *      1. Controller with the Blank MainFrame Added.
 *
 *  Commit 2nd:
 *      1. MainFrame turned into Controller.
 *      2. StartPanel added with Test Label & Button.
 *      3. TextPanel created.
 *
 *  Commit 3rd:
 *      1. Cards Layout added to MainFrame.
 *      2. DirectoryOrganiser, DirectoryChooserPanel Classes added.
 *
 *  Commit 4th:
 *      1. Image Icon added to the JButton btn1.
 *      2. Size set for the DirectoryChooserPanel.
 *
 *  Commit 5th:
 *      1. Encapsulated the DirectoryOrganiser & DirectoryChooserPanel Classes.
 *
 *  Commit 6th:
 *      1. Classes Added: Utils, FileExtensionUtility, Extension (Enum).
 *      2. Btn Action Performed Modified to handle the file Extension.
 *
 *  Commit 7th:
 *      1. Setup directoryChooser & updated directoryPathTextField successfully.
 *      2. DirectoryFilter class added.
 *
 *  Commit 8th:
 *      1. Start Button added with currentStatus emitted to the DirectoryOrganiser
 *         via CurrentDirectoryListener Functional Interface.
 *
 *  Commit 9th:
 *      1. JSplitPane added to the DirectoryOrganiser.
 *
 *  Commit 10th:
 *      1. LeftListPanel String attribute replaced with JLabel.
 *      2. Displaying currentDirectory in LeftListPanel.
 *      3. Return type for validateChosenDirectory method of DirectoryChooserPanel
 *         updated to boolean & fixed the Bug of Exception when no directory is selected.
 *      4. CurrentStatusListener refactored to CurrentDirectoryListener & changed its parameter
 *         from boolean to currentDirectory selected by DirectoryChooserPanel.
 *
 *  Code Developed By,
 *  ~K.O.H..!! ^__^
 */