/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

/**
 *
 * @author root
 *  2) Hotel
 *    Methods:
 *        Constructor (Nome, Cidade, Numero de Quartos, Preco)
 *        rent(number);
 *        free(number);
 *        setPrice(Price);
 */
public class hotel {
    private String name;
    private String city;
    private int roomCapacity;
    private float price;
    
    private int roomAvailable;
    
    public hotel(String name, String city, int roomCapacity, float price) {
        this.name = name;
        this.city = city;
        this.roomCapacity = roomCapacity;
        this.roomAvailable = roomCapacity;
        this.price = price;
    }
    
    // return 0 to OK
    // return 1 to error
    public int rent(int number) {
        if (number > roomAvailable) {
            roomAvailable -= number;
            return 0;
        } else {
            return 1;
        }
    }
    
    // return 0 to OK
    // return 1 to error
    public int free(int number) {
        if (roomAvailable + number < roomCapacity) {
            roomAvailable += number;
            return 0;
        } else {
            return 1;
        }   
    }
    
    public void setPrice(float price) {
        this.price = price;
    }
}
