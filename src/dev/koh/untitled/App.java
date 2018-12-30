package dev.koh.untitled;

import javax.swing.*;

public class App {

    //  Time Stamp: 30th December 2K18, 08:49 PM..!!
    public static void main(String[] args) {

        System.out.println("Begin.");

        //  Using Lambda Expression for instantiating Runnable Interface.
        Runnable runnable = Controller::new;

        //  Launching App while handling the Multi-threaded Events using SwingUtilities.invokeLater method
        //  which takes in an instance of Runnable Interface.
        SwingUtilities.invokeLater(runnable);

        System.out.println("\nEnd.");
    }
}

/*
 *  Date Created: 30th December 2K18, 08:49 PM..!!
 *  Last Modified: 30th December 2K18, 09:22 PM..!!
 *
 *  Latest Update:
 *      1. Controller with the Blank MainFrame Added.
 *
 *  Code Developed By,
 *  ~K.O.H..!! ^__^
 */