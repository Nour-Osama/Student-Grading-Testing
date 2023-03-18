package Gradingsys;

public class Validation {
    public static boolean isAlpha(String Name) {
        return Name.matches("[a-zA-Z ]*");
    }
    public static boolean isNumeric(String Number) {
        if (Number == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(Number);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static boolean isAlphaNumeric(String Name){
        return Name.matches("[a-zA-Z0-9 ]*");
    }
}
