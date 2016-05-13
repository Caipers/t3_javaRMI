
package RMI;

import java.io.Serializable;

public class credicard implements Serializable {
    private final int number;
    private final String dateValid;
    private final int secretNumber;
    
    public credicard(int number, String dateValid, int secretNumber) {
        this.number = number;
        this.dateValid = dateValid;
        this.secretNumber = secretNumber;
    }
}
