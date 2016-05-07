/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

/**
 *
 * @author samuel
 */
public class RMIserver {
    static ArrayList<flight> listOfFlights = new ArrayList<>();
    static ArrayList<hotel> listOfHotels = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        init();
        try {
            Registry SN = LocateRegistry.createRegistry(9099);
            ImplemServer SI = new ImplemServer(listOfFlights, listOfHotels);
            SN.rebind("ImplemServer", SI);
            
            String cmd;
            String from;
            String destination;
            String name;
            String city;
            int roomCapacity;      
            int count;
            int index;
            //int aux;
            float price;
            Iterator<flight> fitr;
            Iterator<hotel> hitr;
            
            while (true) {
                System.out.println("Select the event you want:");
                System.out.println("[1] New Flight");
                System.out.println("[2] New Hotels");
                System.out.println("[3] Hotel Room Availability");
                System.out.println("[4] Change Flight's price");
                System.out.println("[5] Change Hotel's price");
                System.out.println("[6] List of Tickets Booked");
                System.out.println("[7] List of Accommodation Booked");
                
                cmd = in.nextLine().trim();
                
                
                switch (cmd) {
                    case "1":
                        System.out.println("Please inform from:");
                        from = in.nextLine().trim();
                        
                        System.out.println("Please inform destination:");
                        destination = in.nextLine().trim();
                        
                        System.out.println("Please inform the price:");
                        price = Float.parseFloat(in.nextLine().trim());
                        
                        listOfFlights.add(new flight(from, destination, price));
                        break;
                    case "2":
                        System.out.println("Please inform Hotel's name:");
                        name = in.nextLine().trim();
                        
                        System.out.println("Please inform Hotel's city:");
                        city = in.nextLine().trim();
                        
                        System.out.println("Please inform the room capacity:");
                        roomCapacity = Integer.parseInt(in.nextLine().trim());
                        
                        System.out.println("Please inform the price:");
                        price = Float.parseFloat(in.nextLine().trim());
                        
                        listOfHotels.add(new hotel(name, city, roomCapacity, price));
                        break;
                    case "3":
                        System.out.println("List of hotels:");
                        hitr = listOfHotels.iterator();
                        count = 0;
                        while (hitr.hasNext()) {
                            hotel elem = hitr.next();
                            String aux = "Index: " + count +
                                         " Name: " + elem.getName() +
                                         " City: " + elem.getCity() +
                                         " Price: " + elem.getPrice();
                            System.out.println(aux);
                            count++;
                        }
                        
                        // TODO
                        
                        break;
                    case "4":
                        System.out.println("List of flights:");
                        fitr = listOfFlights.iterator();
                        count = 0;
                        while (fitr.hasNext()) {
                            flight elem = fitr.next();
                            String aux = "Index: " + count +
                                         " From: " + elem.getFrom() +
                                         " Destination: " + elem.getDestination() +
                                         " Price: " + elem.getPrice();
                            System.out.println(aux);
                            count++;
                        }
                        
                        System.out.println("Which one would you "
                                + "like to change price");
                        index = Integer.parseInt(in.nextLine().trim());
                        
                        System.out.println("Inform the new price");
                        price = Float.parseFloat(in.nextLine().trim());
                        
                        listOfFlights.get(index).setPrice(price);                                         
                        break;
                        
                    case "5":
                        System.out.println("List of hotels:");
                        hitr = listOfHotels.iterator();
                        count = 0;
                        while (hitr.hasNext()) {
                            hotel elem = hitr.next();
                            String aux = "Index: " + count +
                                         " Name: " + elem.getName() +
                                         " City: " + elem.getCity() +
                                         " Price: " + elem.getPrice();
                            System.out.println(aux);
                            count++;
                        }
                        
                        System.out.println("Which one would you "
                                + "like to change price");
                        index = Integer.parseInt(in.nextLine().trim());
                        
                        System.out.println("Inform the new price");
                        price = Float.parseFloat(in.nextLine().trim());
                        
                        listOfHotels.get(index).setPrice(price);
                        break;
                    case "6":
                        count = SI.listOfTickets.size();
                        
                        System.out.println("List of Tickets:");
                        for (int i = 0; i < count; i++) {
                            System.out.println("Index: " + i);
                            System.out.println(SI.listOfTickets.get(i).toStr());
                            System.out.println("");
                        }
                        
                        
                        break;
                        
                    case "7":
                        count = SI.listOfAccommodation.size();
                        
                        System.out.println("List of Accommodation:");
                        for (int i = 0; i < count; i++) {
                            System.out.println("Index: " + i);
                            System.out.println(SI.listOfAccommodation.get(i).toStr());
                            System.out.println("");
                        }
                        
                        break;
                    default:
                        System.out.println("Invalid operation!");
                        
                }
                
                
                
            }
                    
        } catch (RemoteException ex) {
            Logger.getLogger(RMIserver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     */
    public static void init() {
        listOfFlights.add(new flight("Curitiba", "São Paulo", 130));
        listOfFlights.add(new flight("São Paulo", "Curitiba", 100));
        listOfFlights.add(new flight("Curitiba", "Rio de Janeiro", 160));
        listOfFlights.add(new flight("Rio de Janeiro", "Curitiba", 150));
        
        listOfHotels.add(new hotel("ABC", "Curitiba", 50, 50));
        listOfHotels.add(new hotel("XYZ", "São Paulo", 70, 80));
        listOfHotels.add(new hotel("POI", "São Paulo", 30, 150));
        listOfHotels.add(new hotel("QWE", "Rio de Janeiro", 100, 30));
    }
}
