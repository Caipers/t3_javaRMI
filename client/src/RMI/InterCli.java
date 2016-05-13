package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author samuel
 */
public interface InterCli extends Remote {
    public void echo(String str) throws RemoteException;
}