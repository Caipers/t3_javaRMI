package RMI;

public class credicard {
    private int number;
    private String dateValid;
    private int secretNumber;
    
    public credicard(int number, String dateValid, int secretNumber) {
        this.number = number;
        this.dateValid = dateValid;
        this.secretNumber = secretNumber;
    }
    
    public int getNumber() {
        return number;
    }
}
