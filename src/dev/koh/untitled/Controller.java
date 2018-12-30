package dev.koh.untitled;

public class Controller {
//    Time Stamp: 30th December 2K18, 08:53 PM..!!

    private MainFrame mainFrame;

    //  Instantiation Block.
    {
        fireStartApp();
    }

    //  Time Stamp: 30th December 2K18, 09:15 PM..!!
    Controller() {

        //  Instantiating the mainFrame with the title "Untitled..!!"
        mainFrame = new MainFrame("Untitled..!!");

    }


    //  Display the message in the Console during Startup of the App.
    private void fireStartApp() {
        System.out.println("Launching the App2!");
    }


}
