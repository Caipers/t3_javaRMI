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
public class accommodation {
    private hotel Hotel;
    private String beginDate;
    private String endDate;
    private String rooms;
    private int age[];
    private credicard card;
    private int parts;
    
    
    public accommodation(hotel Hotel, String beginDate, String endDate, 
                         String rooms, String number, int age[], credicard card,
                         int parts) {
        this.Hotel = Hotel;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.rooms = rooms;
        this.age = age;
        this.card = card;
        this.parts = parts;
    }
    
    
}
