package service;

public class StringUtil {
    public static boolean isEmptyString(String filename){
        return filename == null || filename.trim().equals("");
    }
}