/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author samuel
 */
public interface InterServer extends Remote {

    public void queryAirTickets(InterCli interCli) throws RemoteException;
    public void buyAirTickets(InterCli interCli, int code, int type, String from, 
                              String departure, String beginDate, String endDate, 
                              int numberOfPeople, int age[], int cardNumber,
                              String dateValid, int secretNumber, int parts)
                              throws RemoteException;
}
