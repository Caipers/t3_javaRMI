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

/**
 *
 * @author samuel
 */
public class RMIserver {
    static ArrayList<flight> listOfFlights = new ArrayList<>();
    
    public static void main(String[] args) {
        init();
        try {
            Registry SN = LocateRegistry.createRegistry(9099);
            ImplemServer SI = new ImplemServer(listOfFlights);
            SN.rebind("ImplemServer", SI);
                    
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
    }
}
