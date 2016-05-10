package RMI;

public class event {
    private InterCli    IC;
    private int         eventCode;
    private int         index;
    private String      endDate;
    
    public event(InterCli IC, int eventCode, int index, String endDate) {
        this.IC         = IC;
        this.eventCode  = eventCode;
        this.index      = index;
        this.endDate    = endDate;
    }
    
    public InterCli getInterCli() {
        return IC;
    }
    
    public int getEventCode() {
        return eventCode;
    }
    
    public String getEndDate() {
        return endDate;
    }
    
    public int getIndex() {
        return index;
    }
    
    @Override
    public String toString() {
        String aux;
        aux = "InterCli: "       + IC.toString() + 
              " Event Code: "    + eventCode +
              " Index: "         + index +
              " End Date: "      + endDate + "\n";
        
        return aux;
    }
}