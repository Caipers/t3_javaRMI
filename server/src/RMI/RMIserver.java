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
            while (true) {
                System.out.println("Select the event you want:");
                System.out.println("[1] New Flight");
                System.out.println("[2] New Hotels");
                System.out.println("[3] Hotel Room Availability");
                System.out.println("[4] Cheaper Flight");
                System.out.println("[5] Cheaper Hotel");
                
                cmd = in.nextLine().trim();
                
                switch (cmd) {
                    case "1":
                        
                        break;
                    case "2":
                        
                        break;
                    case "3":
                        
                        break;
                    case "4":
                        
                        break;
                        
                    case "5":
                        
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
