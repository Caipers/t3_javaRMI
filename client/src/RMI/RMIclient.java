package RMI;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
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
        try {
            // Returns a reference to the the remote object Registry for the local host on the 9099 port.
            Registry SN = LocateRegistry.getRegistry(9099);
            ImplemCli CI = new ImplemCli(SN);
        } catch (RemoteException ex) {
            Logger.getLogger(RMIclient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}