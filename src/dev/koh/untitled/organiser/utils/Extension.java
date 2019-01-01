package dev.koh.untitled.organiser.utils;

public enum Extension {

    MP4("mp4"), AVI("avi"), MKV("mkv"), THREE_GP("3gp"), FLV("flv"), WMV("wmv"), MOV("mov"), QT("qt"),
    MTS("mts"), M2TS("m2ts");

    private String extensionName;
    private String extensionType;

    Extension(String extension) {
        this.extensionName = extension.toLowerCase();
    }

    @Override
    public String toString() {
        return extensionName;
    }

    public String getExtensionName() {
        return extensionName;
    }

    public void setExtensionName(String extensionName) {
        this.extensionName = extensionName;
    }

    public String getExtensionType() {
        return extensionType;
    }

    public void setExtensionType(String extensionType) {
        this.extensionType = extensionType;
    }
}
