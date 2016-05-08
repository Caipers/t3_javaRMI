/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

/**
 *
 * @author root
 */
public class event {
    private InterCli    IC;
    private int         eventCode;
    private String      endDate;
    
    
    public event(InterCli IC, int eventCode, String endDate) {
        this.IC         = IC;
        this.eventCode  = eventCode;
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
    
    @Override
    public String toString() {
        String aux;
        aux = "InterCli: "      + IC.toString() + 
              " Event Code: "    + eventCode + 
              " End Date: "      + endDate;
        
        return aux;
    }
    
}
