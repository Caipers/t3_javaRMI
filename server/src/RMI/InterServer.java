package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author samuel
*/ 

public interface InterServer extends Remote {
    public void queryAirTickets(InterCli interCli) throws RemoteException;
    public void buyAirTickets(InterCli interCli, int code, int type, String from, 
                              String departure, String beginDate, String endDate, 
                              int numberOfPeople, int age[], int cardNumber, 
                              String dateValid, int secretNumber, 
                              int parts) throws RemoteException;
    public void queryAccommodation(InterCli interCli) throws RemoteException;
    public void buyAccommodation(InterCli interCli, int code, String destination,
                                String beginDate, String endDate, int numberPerson,
                                int age[], int cardNumber, String dateValid, 
                                int secretNumber, int parts) 
                                throws RemoteException;
    public void events(InterCli interCli, int event, int index, String endDate) 
                                throws RemoteException;
}
