/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author samuel
 */
public class ImplemServer extends UnicastRemoteObject implements InterServer {
    ArrayList<flight> listOfFlights;
    ArrayList<hotel> listOfHotels;
    ArrayList<tickets> listOfTickets = new ArrayList<>();
    
    
    public ImplemServer(ArrayList<flight> listOfFlights, ArrayList<hotel> listOfHotels) 
            throws RemoteException {
        super();
        this.listOfFlights = listOfFlights;
        this.listOfHotels = listOfHotels;
    }
    
    @Override
    public void queryAirTickets(InterCli interCli) throws RemoteException {
        interCli.echo("Air Flights:");
        Iterator<flight> itr = listOfFlights.iterator();
        int count = 0;
        while (itr.hasNext()) {
            flight elem = itr.next();
            String aux = "Index: " + count +
                         " From: " + elem.getFrom() +
                         " Destination: " + elem.getDestination() +
                         " Price: " + elem.getPrice();
            interCli.echo(aux);
            count++;
        }
    }
    
    @Override
    public void buyAirTickets(InterCli interCli, int code, int type, String from, 
                              String departure, String beginDate, String endDate, 
                              int numberOfPeople, int age[],
                              credicard card, int parts) throws RemoteException {
        
        tickets tick = new tickets(code, type, from, departure,
                                 beginDate, endDate, numberOfPeople,
                                 age, card, parts);
        
        listOfTickets.add(tick);
        interCli.echo("Ticket has been processed");
        interCli.echo(tick.toStr());
    }
    
    @Override
    public void queryAccommodation(InterCli interCli) throws RemoteException {
        Iterator<hotel> itr = listOfHotels.iterator();
        int count = 0;
        while (itr.hasNext()) {
            hotel elem = itr.next();
            String aux = "Index: " + count +
                         " Name: " + elem.getName() +
                         " City: " + elem.getCity() +
                         " Price: " + elem.getPrice();
            interCli.echo(aux);
            count++;
        }
    }
    
    @Override
    public void buyAccommodation(InterCli interCli, String destination,
                                String beginDate, String endDate, int numberPerson,
                                int age[], credicard card, int parts) 
                                throws RemoteException {
        
        interCli.echo("buyAccommodation has been processed");
        
    }
}