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
    ArrayList<flight> listOfFlight;
    ArrayList<tickets> listOfTickets = new ArrayList<>();
    
    
    public ImplemServer(ArrayList<flight> listOfFlight) throws RemoteException {
        super();
        this.listOfFlight = listOfFlight;
    }

//    @Override
//    public void chamar(String nome, InterCli interCli) throws RemoteException {
//        interCli.echo("Olá " + nome) ;
//    }
    
    @Override
    public void queryAirTickets(InterCli interCli) throws RemoteException {
        interCli.echo("Air Flights:");
        Iterator<flight> itr = listOfFlight.iterator();
        int count = 0;
        while (itr.hasNext()) {
            flight elem = itr.next();
            String aux = "Index: " + count +
                         " From: " + elem.getFrom() +
                         " Destination: " + elem.getDestination() +
                         " Price: " + elem.getPrice();
            interCli.echo(aux);
            
            //System.out.println(listOfFlight.get(count).getFrom());
            count++;
        }
    }
    
    @Override
    public void buyAirTickets(InterCli interCli, int code, int type, String from, 
                              String departure, String beginDate, String endDate, 
                              int numberOfPeople, int age[], int cardNumber,
                              String dateValid, int secretNumber, int parts) throws RemoteException {
        
        tickets tick = new tickets(code, type, from, departure,
                                 beginDate, endDate, numberOfPeople,
                                 age, cardNumber, dateValid, 
                                 secretNumber, parts);
        listOfTickets.add(tick);
        interCli.echo("Ticket has been processed");
        
        
        
    }
}