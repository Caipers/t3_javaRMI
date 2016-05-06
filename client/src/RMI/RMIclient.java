/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
//import java.lang.SecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samuel
 */
public class RMIclient {
    public static void main(String[] args) throws AlreadyBoundException, NotBoundException {
//        System.setSecurityManager(new SecurityManager());
        try {
            Registry SN = LocateRegistry.getRegistry(9099);      
            ImplemCli CI = new ImplemCli(SN);
        } catch (RemoteException ex) {
            Logger.getLogger(RMIclient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}