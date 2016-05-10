package RMI;

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
    
    public String toString() {
        String aux;
        aux = "Name: " + name +
              " City: " + city + 
              " Room Capacity: " + roomCapacity +
              " Room Available: " + roomAvailable + 
              " Price: " + price + "\n";
              
        return aux;
    }
    // return 0 to OK
    // return 1 to error
    public int booking(int number) {
        if (number < roomAvailable) {
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
    
    public String getName() {
        return name;
    }
    
    public String getCity() {
        return city;
    }
    
    public int getRoomCapacity() {
        return roomCapacity;
    }
    
    public int getRoomAvailable() {
        return roomAvailable;
    }
    
    public float getPrice() {
        return price;
    }
}