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
            int maxCapacity;
            //int aux;
            float price;
            Iterator<flight> fitr;
            Iterator<hotel> hitr;
            
            flight fl;
            
            while (true) {
                System.out.println("Select the event you want:");
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
                        System.out.println("Please inform from:");
                        from = in.nextLine().trim();
                        
                        System.out.println("Please inform destination:");
                        destination = in.nextLine().trim();
                        
                        System.out.println("Please inform the price:");
                        price = Float.parseFloat(in.nextLine().trim());
                        
                        System.out.println("Please inform the flight's max capacity:");
                        maxCapacity = Integer.parseInt(in.nextLine().trim());
                        
                        fl = new flight(from, destination, maxCapacity, price);
                        listOfFlights.add(fl);
                        
                        count = SI.listOfEvents.size();
                        
                        for(int i = 0; i < count; i++) {
                            event ev = SI.listOfEvents.get(i);
                            if (ev.getEventCode() == 1) {
                                ev.getInterCli().echo("New Flight is available!");
                                ev.getInterCli().echo(fl.toString());
                            }
                        }
                        
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
                        
                        hotel ho = new hotel(name, city, roomCapacity, price);
                        
                        listOfHotels.add(ho);
                        
                        count = SI.listOfEvents.size();
                        
                        for(int i = 0; i < count; i++) {
                            event ev = SI.listOfEvents.get(i);
                            if (ev.getEventCode() == 2) {
                                ev.getInterCli().echo("New Hotel is available!");
                                ev.getInterCli().echo(ho.toString());
                            }
                        }
                        
                        break;
                    
                    case "3":
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
                        
                        if (index > listOfFlights.size() - 1) {
                            System.out.println("Invalid index");
                            break;
                        }
                        
                        System.out.println("Inform the new price");
                        price = Float.parseFloat(in.nextLine().trim());
                        
                        listOfFlights.get(index).setPrice(price);
                        
                        count = SI.listOfEvents.size();
                        
                        for(int i = 0; i < count; i++) {
                            event ev = SI.listOfEvents.get(i);
                            if (ev.getEventCode() == 3) {
                                ev.getInterCli().echo("Price has changed!");
                                ev.getInterCli().echo(listOfFlights.get(index).toString());
                            }
                        }
                        
                        
                        break;
                        
                    case "4":
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
                        
                        if (index > listOfHotels.size() - 1) {
                            System.out.println("Invalid index");
                            break;
                        }
                        
                        System.out.println("Inform the new price");
                        price = Float.parseFloat(in.nextLine().trim());
                        
                        listOfHotels.get(index).setPrice(price);
                        
                        count = SI.listOfEvents.size();
                        
                        for(int i = 0; i < count; i++) {
                            event ev = SI.listOfEvents.get(i);
                            if (ev.getEventCode() == 4) {
                                ev.getInterCli().echo("Price has changed!");
                                ev.getInterCli().echo(listOfHotels.get(index).toString());
                            }
                        }
                        
                        break;
                        
                    case "5":
                        // FLIGHT AVAILABILITY
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
                            if (ev.getEventCode() == 5) {
                                ev.getInterCli().echo("Flight has become available!");
                                ev.getInterCli().echo(fl.toString());
                            }
                        }
                        
                        break;
                    case "6":
                        // HOTEL AVAILABILITY
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
                                + "like to notify availability");
                        
                        index = Integer.parseInt(in.nextLine().trim());
                        if (index > listOfHotels.size() - 1) {
                            System.out.println("Invalid index");
                            break;
                        }
                       
                        count = SI.listOfEvents.size();
                        
                        for(int i = 0; i < count; i++) {
                            event ev = SI.listOfEvents.get(i);
                            if (ev.getEventCode() == 6) {
                                ev.getInterCli().echo("Hotel has become available!");
                                ev.getInterCli().echo(listOfHotels.get(index).toString());
                            }
                        }
                        
                        break;
                    case "7":
                        count = SI.listOfTickets.size();
                        
                        System.out.println("List of Tickets:");
                        for (int i = 0; i < count; i++) {
                            System.out.println("Index: " + i);
                            System.out.println(SI.listOfTickets.get(i).toString());
                            System.out.println("");
                        }
                        
                        
                        break;
                        
                    case "8":
                        count = SI.listOfAccommodation.size();
                        
                        System.out.println("List of Accommodation:");
                        for (int i = 0; i < count; i++) {
                            System.out.println("Index: " + i);
                            System.out.println(SI.listOfAccommodation.get(i).toString());
                            System.out.println("");
                        }
                        
                        break;
                        
                    case "9":
                        count = SI.listOfEvents.size();
                        
                        System.out.println("List of Recorded Events:");
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
    
    /**
     *
     */
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
