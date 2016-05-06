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
    
    public flight(String from, String destination, float price) {
        this.from        = from;
        this.destination = destination;
        this.price       = price;
    }
    
    public void setPrice(float price) {
        this.price = price;
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
}
