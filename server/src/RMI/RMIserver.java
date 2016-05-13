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
            // Creates and exports a Registry instance on the local host that 
            // accepts requests on the 9099 port.
            Registry SN = LocateRegistry.createRegistry(9099);            
            ImplemServer SI = new ImplemServer(listOfFlights, listOfHotels);
            
            // Replaces the binding for the specified name in this registry
            // with the supplied remote reference.
            SN.rebind("ImplemServer", SI);
            
            String cmd;
            String from;
            String destination;
            String name;
            String city;
            int roomCapacity;      
            int count;
            int index;
            int maxCapacity;
            float price;
            Iterator<flight> fitr;
            Iterator<hotel> hitr;
            flight fl;
            
            while (true) {
                System.out.println("\nSelect the event you want:");
                System.out.println("[1] Event - New Flight");
                System.out.println("[2] Event - New Hotels");
                System.out.println("[3] Event - Change Flight's price");
                System.out.println("[4] Event - Change Hotel's price");
                System.out.println("[5] Event - Flight Availability");
                System.out.println("[6] Event - Hotel Availability");
                System.out.println("[7] List of Tickets Booked");
                System.out.println("[8] List of Accommodation Booked");
                System.out.println("[9] List of Recorded Events");
                
                cmd = in.nextLine().trim();
                switch (cmd) {
                    case "1":
                        System.out.println("\nPlease inform from:");
                        from = in.nextLine().trim();
                        
                        System.out.println("\nPlease inform destination:");
                        destination = in.nextLine().trim();
                        
                        System.out.println("\nPlease inform the price:");
                        price = Float.parseFloat(in.nextLine().trim());
                        
                        System.out.println("\nPlease inform the flight's max capacity:");
                        maxCapacity = Integer.parseInt(in.nextLine().trim());
                        
                        fl = new flight(from, destination, maxCapacity, price);
                        listOfFlights.add(fl);
                        
                        count = SI.listOfEvents.size();
                        for(int i = 0; i < count; i++) {
                            event ev = SI.listOfEvents.get(i);
                            if (ev.getEventCode() == 1) {
                                ev.getInterCli().echo("\nNew Flight is available!");
                                ev.getInterCli().echo(fl.toString());
                            }
                        }
                        break;

                    case "2":
                        System.out.println("\nPlease inform Hotel's name:");
                        name = in.nextLine().trim();
                        
                        System.out.println("\nPlease inform Hotel's city:");
                        city = in.nextLine().trim();
                        
                        System.out.println("\nPlease inform the room capacity:");
                        roomCapacity = Integer.parseInt(in.nextLine().trim());
                        
                        System.out.println("\nPlease inform the price:");
                        price = Float.parseFloat(in.nextLine().trim());
                        
                        hotel ho = new hotel(name, city, roomCapacity, price);
                        listOfHotels.add(ho);
                        
                        count = SI.listOfEvents.size();                        
                        for(int i = 0; i < count; i++) {
                            event ev = SI.listOfEvents.get(i);
                            if (ev.getEventCode() == 2) {
                                ev.getInterCli().echo("\nNew Hotel is available!");
                                ev.getInterCli().echo(ho.toString());
                            }
                        }
                        break;
                    
                    case "3":
                        System.out.println("\nList of flights:");
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
                        
                        System.out.println("\nWhich one would you "
                                + "like to change price");
                        index = Integer.parseInt(in.nextLine().trim());
                        
                        if (index > listOfFlights.size() - 1) {
                            System.out.println("\nInvalid index");
                            break;
                        }
                        
                        System.out.println("\nInform the new price");
                        price = Float.parseFloat(in.nextLine().trim());
                        
                        listOfFlights.get(index).setPrice(price);
                        
                        count = SI.listOfEvents.size();
                        for(int i = 0; i < count; i++) {
                            event ev = SI.listOfEvents.get(i);
                            if (ev.getEventCode() == 3 && ev.getIndex() == index) {
                                ev.getInterCli().echo("\nFlight price has changed!");
                                ev.getInterCli().echo(listOfFlights.get(index).toString());
                            }
                        }
                        break;
                        
                    case "4":
                        System.out.println("\nList of hotels:");
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
                        
                        System.out.println("\nWhich one would you "
                                + "like to change price");
                        index = Integer.parseInt(in.nextLine().trim());
                        
                        if (index > listOfHotels.size() - 1) {
                            System.out.println("Invalid index");
                            break;
                        }
                        
                        System.out.println("\nInform the new price");
                        price = Float.parseFloat(in.nextLine().trim());
                        
                        listOfHotels.get(index).setPrice(price);
                        
                        count = SI.listOfEvents.size();
                        for(int i = 0; i < count; i++) {
                            event ev = SI.listOfEvents.get(i);
                            if (ev.getEventCode() == 4 && ev.getIndex() == index) {
                                ev.getInterCli().echo("\nHotel price has changed!");
                                ev.getInterCli().echo(listOfHotels.get(index).toString());
                            }
                        }
                        break;
                        
                    case "5":
                        // FLIGHT AVAILABILITY
                        System.out.println("\nList of flights:");
                        
                        fitr = listOfFlights.iterator();
                        count = 0;
                        while (fitr.hasNext()) {
                            flight elem = fitr.next();
                            String aux = "\nIndex: " + count +
                                         " From: " + elem.getFrom() +
                                         " Destination: " + elem.getDestination() +
                                         " Price: " + elem.getPrice();
                            System.out.println(aux);
                            count++;
                        }
                        
                        System.out.println("\nWhich one would you "
                                + "like to notify availability");
                        index = Integer.parseInt(in.nextLine().trim());
                        
                        if (index > listOfFlights.size() - 1) {
                            System.out.println("Invalid index");
                            break;
                        }
                        
                        fl = listOfFlights.get(index);
                        count = SI.listOfEvents.size();
                        for(int i = 0; i < count; i++) {
                            event ev = SI.listOfEvents.get(i);
                            if (ev.getEventCode() == 5 && ev.getIndex() == index) {
                                ev.getInterCli().echo("\nFlight has become available!");
                                ev.getInterCli().echo(fl.toString());
                            }
                        }
                        break;

                    case "6":
                        // HOTEL AVAILABILITY
                        System.out.println("\nList of hotels:");
                        
                        hitr = listOfHotels.iterator();
                        count = 0;
                        while (hitr.hasNext()) {
                            hotel elem = hitr.next();
                            String aux = "\nIndex: " + count +
                                         " Name: " + elem.getName() +
                                         " City: " + elem.getCity() +
                                         " Price: " + elem.getPrice();
                            System.out.println(aux);
                            count++;
                        }
                        System.out.println("\nWhich one would you "
                                + "like to notify availability");
                        
                        index = Integer.parseInt(in.nextLine().trim());
                        if (index > listOfHotels.size() - 1) {
                            System.out.println("Invalid index");
                            break;
                        }
                       
                        count = SI.listOfEvents.size();
                        for(int i = 0; i < count; i++) {
                            event ev = SI.listOfEvents.get(i);
                            if (ev.getEventCode() == 6 && ev.getIndex() == index) {
                                ev.getInterCli().echo("\nHotel has become available!");
                                ev.getInterCli().echo(listOfHotels.get(index).toString());
                            }
                        }
                        break;

                    case "7":
                        System.out.println("\nList of Tickets:");
                        
                        count = SI.listOfTickets.size();
                        for (int i = 0; i < count; i++) {
                            System.out.println("Index: " + i);
                            System.out.println(SI.listOfTickets.get(i).toString());
                            System.out.println("");
                        }
                        break;
                        
                    case "8":
                        System.out.println("\nList of Accommodation:");
                        
                        count = SI.listOfAccommodation.size();
                        for (int i = 0; i < count; i++) {
                            System.out.println("Index: " + i);
                            System.out.println(SI.listOfAccommodation.get(i).toString());
                            System.out.println("");
                        }
                        break;
                        
                    case "9":
                        System.out.println("\nList of Recorded Events:");
                        
                        count = SI.listOfEvents.size();
                        for (int i = 0; i < count; i++) {
                            System.out.println("Index: " + i);
                            System.out.println(SI.listOfEvents.get(i).toString());
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
    
    public static void init() {
        listOfFlights.add(new flight("Curitiba", "São Paulo", 100, 130));
        listOfFlights.add(new flight("São Paulo", "Curitiba", 50, 100));
        listOfFlights.add(new flight("Curitiba", "Rio de Janeiro", 200, 160));
        listOfFlights.add(new flight("Rio de Janeiro", "Curitiba", 250, 150));
        
        listOfHotels.add(new hotel("ABC", "Curitiba", 50, 50));
        listOfHotels.add(new hotel("XYZ", "São Paulo", 70, 80));
        listOfHotels.add(new hotel("POI", "São Paulo", 30, 150));
        listOfHotels.add(new hotel("QWE", "Rio de Janeiro", 100, 30));
    }
}