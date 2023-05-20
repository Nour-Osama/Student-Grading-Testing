package Gradingsys;

public class Validation {
    public static boolean isAlpha(String Name) {
        if(Name.isEmpty() || Name.isBlank()){
            return false;
        }
//        return Name.matches("[a-zA-Z ]*");
        return Name.matches("^[^-\\s][a-zA-Z\\s-]+$");
    }
    public static boolean isNumeric(String Number) {
        if(Number.isEmpty() || Number.isBlank()){
            return false;
        }
        try {
            double d = Double.parseDouble(Number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    public static boolean isAlphaNumeric(String Name){
        if(Name.isEmpty() || Name.isBlank()){
            return false;
        }
        return Name.matches("^[^-\\s][a-zA-Z0-9_\\s-]+$");
    }
}
