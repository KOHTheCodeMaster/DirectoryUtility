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
 *  Last Modified: 30th December 2K18, 03:41 PM..!!
 *
 *  Latest Update:
 *  Commit 3rd:
 *      1. Cards Layout added to MainFrame.
 *      2. DirectoryOrganiser, DirectoryChooserPanel Classes added.
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
 *  Code Developed By,
 *  ~K.O.H..!! ^__^
 */