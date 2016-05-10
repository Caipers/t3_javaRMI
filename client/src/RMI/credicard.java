
package RMI;

import java.io.Serializable;

public class credicard implements Serializable {
    private int number;
    private String dateValid;
    private int secretNumber;
    
    public credicard(int number, String dateValid, int secretNumber) {
        this.number = number;
        this.dateValid = dateValid;
        this.secretNumber = secretNumber;
    }
}
