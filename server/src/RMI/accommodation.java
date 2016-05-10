package RMI;

public class accommodation {
    private hotel Hotel;
    private String beginDate;
    private String endDate;
    private int rooms;
    private int age[];
    private credicard card;
    private int parts;
    
    public accommodation(hotel Hotel, String beginDate, String endDate, 
                         int rooms, int age[], credicard card,
                         int parts) {
        this.Hotel = Hotel;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.rooms = rooms;
        this.age = age;
        this.card = card;
        this.parts = parts;
    }
    
    @Override
    public String toString() {
        String aux;
        
        aux = "Hotel's name: " + Hotel.getName() + 
              " Begin Date: " + beginDate +
              " End Date: " + endDate +
              " Ages: [ ";
            for(int i = 0; i < rooms; i++) {
                aux += age[i];
                aux += " ";
            }
            aux += "]";
            aux += " Card Number: " + card.getNumber() +
                   " Parts: " + parts + "\n";
            
        return aux;
    }
}