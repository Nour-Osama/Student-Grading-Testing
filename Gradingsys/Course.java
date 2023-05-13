package Gradingsys;

public class Course {
    private String name;
    private String code;
    private int total;
    private boolean valid;
    private boolean validateName(String name){
        boolean isValid = true;
        try {
            if (!Validation.isAlpha(name)) {
                System.out.println("Error with course name: " + this.name);
                valid = false;
                isValid = false;
            }
        }
        catch(StringIndexOutOfBoundsException e){
            valid = false;
            isValid = false;
            return isValid;
        }
        return isValid;
    }
    private boolean validateCode(String code){
        boolean isValid = true;
        try {
            if ((code.length() < 6) || (code.length() > 7)) {
                isValid = false;
                valid = false;
            }
            if (!Validation.isAlpha(code.substring(0, 3)) || !Validation.isNumeric(code.substring(3, 6))) {
                System.out.println("Error with the course code");
                isValid = false;
                valid = false;
            }
            if(code.charAt(5) == 'F' || code.charAt(5) == 'f'){
                isValid = false;
                valid = false;
            }
            if(code.length() == 7){
                if(code.charAt(6) != 's'){
                    isValid = false;
                    valid = false;
                }
            }
        }
        catch(StringIndexOutOfBoundsException e){
            isValid = false;
            valid = false;
        }
        return isValid;
    }
    private boolean validateTotal(String total){
        boolean isValid = true;
        try {
            if (Integer.parseInt(total) != 100) {
                valid = false;
            }
        }
        catch(Exception e){
            System.out.println("Invalid Full mark, Should be 100");
            valid = false;
            isValid = false;
            return isValid;
        }
        return isValid;
    }
    public Course(String[] info) {
        if(info.length != 3){
            this.valid = false;
            this.name = "INVALID FORMAT";
            this.code = "INVALID FORMAT";
            this.total = -1;
        }
        else{
            this.valid = true;
            this.name = (validateName(info[0])) ? info[0] : "Invalid Name";
            this.code = (validateCode(info[1])) ? info[1] : "Invalid Code";
            this.total = (validateTotal(info[2])) ? Integer.parseInt(info[2] ) : -1;
        }
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getTotal() {
        return total;
    }

    public boolean isValid() {
        return valid;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", total=" + total +
                ", valid=" + valid +
                '}';
    }
}
