/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

/**
 *
 * @author Samuel P. Caipers
 *   1) Voos
 *    Methods:
 *        Constructor (Origem, Destino, Preço)
 *        setPrice(Price);
 *
 */
public class flight {
    private String from;
    private String destination;
    private float price;
    private int maxCapacity;
    private int seatsAvailable;
    
    public flight(String from, String destination, int maxCapacity, float price) {
        this.from           = from;
        this.destination    = destination;
        this.price          = price;
        this.maxCapacity    = maxCapacity;
        this.seatsAvailable = maxCapacity;
    }
    
    public void setFrom(String from) {
        this.from = from;
    }
    
    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }
    
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
    
    // 0 if OK
    // 1 if NOK
    public int booking(int tickets) {
        if (tickets < seatsAvailable) {
            seatsAvailable -= tickets;
            return 0;
        } else {
            System.out.println("There is no enough seats available!");
            return 1;
        }
    }
    
    // 0 if OK
    // 1 if NOK
    public int free(int number) {
        if (seatsAvailable + number > maxCapacity) {
            System.out.println("Invalid free value!");
            return 1;
        } else {
            System.out.println("Seats has been freed");
            return 0;
        }
    }
    
    public String getFrom() {
        return from;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public float getPrice() {
        return price;
    }
    
    public int getMaxCapacity() {
        return maxCapacity;
    }
    
    public int getSeatsAvailable() {
        return seatsAvailable;
    }
    
    @Override
    public String toString() {
        String aux;
        aux = "From: " + from + 
              " Destination: " + destination +
              " Price: " + price +
              " Max Capacity: " + maxCapacity +
              " Seats Available: " + seatsAvailable;
        
        return aux;
    }
}
