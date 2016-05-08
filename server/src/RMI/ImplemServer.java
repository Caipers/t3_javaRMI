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
    ArrayList<tickets> listOfTickets                = new ArrayList<>();
    ArrayList<accommodation> listOfAccommodation    = new ArrayList<>();
    ArrayList<event> listOfEvents                   = new ArrayList<>();
    
    
    public ImplemServer(ArrayList<flight> listOfFlights, ArrayList<hotel> listOfHotels) 
            throws RemoteException {
        super();
        this.listOfFlights = listOfFlights;
        this.listOfHotels = listOfHotels;
    }
    
    /**
     *
     * @param interCli
     * @throws RemoteException
     */
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
    public synchronized void buyAirTickets(InterCli interCli, int code, int type, String from, 
                              String departure, String beginDate, String endDate, 
                              int numberOfPeople, int age[], int cardNumber, 
                              String dateValid, int secretNumber, int parts) 
                              throws RemoteException {
        
        flight fl = listOfFlights.get(code);
        int ret = fl.booking(numberOfPeople);
        
        if (ret == 1) {
            interCli.echo("Seats not available at the moment");
            interCli.echo("Request has not been processed!");
        } else {
            credicard card = new credicard(cardNumber, dateValid, secretNumber);
            tickets tick = new tickets(code, type, from, departure,
                                 beginDate, endDate, numberOfPeople,
                                 age, card, parts);
            listOfTickets.add(tick);
            interCli.echo("Ticket has been processed!");
            interCli.echo(tick.toString());
        }
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
    
    /**
     *
     * @param interCli
     * @param code
     * @param destination
     * @param beginDate
     * @param endDate
     * @param numberPerson
     * @param age
     * @param cardNumber
     * @param dateValid
     * @param secretNumber
     * @param parts
     * @throws RemoteException
     */
    @Override
    public synchronized void buyAccommodation(InterCli interCli, int code, String destination,
                                String beginDate, String endDate, int numberPerson,
                                int age[], int cardNumber, String dateValid, 
                                int secretNumber, int parts) 
                                throws RemoteException {
        
        hotel ho = listOfHotels.get(code);
        int ret = ho.booking(numberPerson);
        if (ret == 1) {
            interCli.echo("Room(s) not available at the moment");
            interCli.echo("Request has not been processed!");
        } else {
            credicard card = new credicard(cardNumber, dateValid, secretNumber);
            accommodation acc = new accommodation(ho, beginDate,
                endDate, numberPerson, age, card, parts);
            listOfAccommodation.add(acc);
            interCli.echo("Accommodation book has been processed");
            interCli.echo(acc.toString());
        }
    }
    
    /**
     *
     * @param interCli
     * @param codeEvent
     * @param endDate
     * @throws RemoteException
     */
    @Override
    public void events(InterCli interCli, int event, int index, String endDate) 
                                throws RemoteException {
        
        listOfEvents.add(new event(interCli, event, index, endDate));
        interCli.echo("Event has been recorded!");
    }
}