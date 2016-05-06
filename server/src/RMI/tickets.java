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
public class tickets {
    private int code;
    private int type;
    private String from;
    private String depature;
    private String beginDate;
    private String endDate;
    private int numberOfPeople;
    private int age[];
    private int cardNumber;
    private String dateValid;
    private int secretNumber;
    private int parts;
    
    public tickets(int code, int type, String from, 
                   String departure, String beginDate, String endDate, 
                   int numberOfPeople, int age[], int cardNumber,
                   String dateValid, int secretNumber, int parts) {
        this.code = code;
        this.type = type;
        this.from = from;
        this.depature = departure;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.numberOfPeople = numberOfPeople;
        this.age = age;
        this.cardNumber = cardNumber;
        this.dateValid = dateValid;
        this.secretNumber = secretNumber;
        this.parts = parts;
    }
}
