package dev.koh.untitled.organiser.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    static Extension getExtension(File file) {

        FileExtensionUtility fileExtensionUtility = new FileExtensionUtility(file);

        return fileExtensionUtility.getExtension();

    }

    static boolean isVideoFile(File file) {

        FileExtensionUtility fileExtensionUtility = new FileExtensionUtility(file);

        return fileExtensionUtility.getVideoExtensions().contains(fileExtensionUtility.getExtension());

    }
}

class FileExtensionUtility {

    private Extension extension;
    private String fileName;

    private static List<Extension> videoExtensions;

    static {
        init();
    }

    FileExtensionUtility(File file) {
        this.fileName = file.getName();
        this.extension = obtainExtension();
    }

    private static void init() {
        videoExtensions = new ArrayList<>();

        videoExtensions.add(Extension.MP4);
        videoExtensions.add(Extension.MKV);
        videoExtensions.add(Extension.AVI);
        videoExtensions.add(Extension.THREE_GP);

    }

    private Extension obtainExtension() {

        //  Obtain the last index position of the period character i.e. '.' in the fileName.
        int index = fileName.lastIndexOf(".");

        //  Assign the remaining characters after the last period of the fileName to the extension.
        //  NOTE: If fileName doesn't contains any period character then index will be -1.
        String temp = "";
        if (index < fileName.length() && index != -1) {
            temp = (fileName.substring(index + 1).toLowerCase());

            switch (temp) {
                case "mkv":
                    return extension = Extension.MKV;

                case "mp4":
                    return extension = Extension.MP4;

                case "avi":
                    return extension = Extension.AVI;

                case "m2ts":
                    return extension = Extension.M2TS;

                case "mts":
                    return extension = Extension.MTS;

                case "qt":
                    return extension = Extension.QT;

                case "3gp":
                    return extension = Extension.THREE_GP;

                case "flv":
                    return extension = Extension.FLV;

                case "wmv":
                    return extension = Extension.WMV;

                case "mov":
                    return extension = Extension.MOV;

                default:
                    return null;
            }

        }

//          Return the null value if the extension is not a valid.
        return extension;
    }

    Extension getExtension() {
        return extension;
    }

    List<Extension> getVideoExtensions() {
        return videoExtensions;
    }
}