/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samuel
 */
public class ImplemCli extends UnicastRemoteObject implements InterCli {
    Scanner in = new Scanner(System.in);
    
    public ImplemCli(Registry refSN) throws RemoteException, NotBoundException {
        InterServer IF;
        try {
            IF = (InterServer) refSN.lookup("ImplemServer");
            /* 
            COMMANDS:
            queryAirTickets()
            buyAirTickets()
            queryAccommodation()
            rentAccommodation()
            TODO Records...
            
            */
            String cmd;
            while (true) {
                System.out.println("");
                System.out.println("Press:");
                System.out.println("[1] to query Air Tickets");
                System.out.println("[2] to buy Air Tickets");
                System.out.println("[3] to query Hotel accommodation");
                System.out.println("[4] to buy Hotel accommodation");
                System.out.println("[5] to register an event");
                cmd = in.nextLine().trim();
                
                switch (cmd) {
                    case "1":
                        IF.queryAirTickets(this);
                        break;
                    
                    case "2":
                        int code;
                        int type;
                        int numberPerson;
                        int cardNumber;
                        int parts;
                        int secretNumber;
                        int age[];
                        String from;
                        String destination;
                        String beginDate;
                        String endDate;
                        String dateValid;
                        
                        System.out.println("List of flights:");
                        IF.queryAirTickets(this);
                        
                        System.out.println("Please press the code of the flight:");
                        code = Integer.parseInt(in.nextLine().trim());
                                          
                        System.out.println("Press 1 to One-Way Ticket or " + 
                                           "2 to Two-Way Ticket");
                        type = Integer.parseInt(in.nextLine().trim());
                        
                        System.out.println("Inform from:");
                        from = in.nextLine().trim();
                        
                        System.out.println("Inform destination:");
                        destination = in.nextLine().trim();
                        
                        System.out.println("Date of parture:");
                        beginDate = in.nextLine().trim();
                        
                        System.out.println("Date of return:");
                        endDate = in.nextLine().trim();
                        
                        System.out.println("Inform the number of tickets:");
                        numberPerson = Integer.parseInt(in.nextLine().trim());
                        
                        age = new int[numberPerson];
                        for(int i = 0; i < numberPerson; i++) {
                            System.out.println("Inform the age of client #" + i);
                            age[i] = Integer.parseInt(in.nextLine().trim());
                        }
                        
                        System.out.println("Inform the credicard information:");
                        System.out.println("Credicard number:");
                        cardNumber = Integer.parseInt(in.nextLine().trim());
                        
                        System.out.println("Validity:");
                        dateValid = in.nextLine().trim();
                        
                        System.out.println("Inform the secret number:");
                        secretNumber = Integer.parseInt(in.nextLine().trim());
                        
                        System.out.println("Inform how many months of paying:");
                        parts = Integer.parseInt(in.nextLine().trim());
                        
                        IF.buyAirTickets(this, code, type, from, destination,
                                           beginDate, endDate, numberPerson,
                                           age, cardNumber, dateValid, 
                                           secretNumber, parts);
                        
                        break;
                    case "3":
                        IF.queryAccommodation(this);
                        
                        break;
                        
                    case "4":
                        System.out.println("List of Hotels:");
                        IF.queryAccommodation(this);
                        
                        System.out.println("Please press the code of the Hotel:");
                        code = Integer.parseInt(in.nextLine().trim());
                        
                        System.out.println("Inform destination (Hotel or City)");
                        destination = in.nextLine().trim();
                        
                        System.out.println("Start date:");
                        beginDate = in.nextLine().trim();
                        
                        System.out.println("Final date:");
                        endDate = in.nextLine().trim();
                        
                        System.out.println("Inform number of rooms:");
                        numberPerson = Integer.parseInt(in.nextLine().trim());
                        
                        age = new int[numberPerson];
                        for(int i = 0; i < numberPerson; i++) {
                            System.out.println("Inform the age of client #" + i);
                            age[i] = Integer.parseInt(in.nextLine().trim());
                        }
                        
                        System.out.println("Inform the credicard information:");
                        System.out.println("Credicard number:");
                        cardNumber = Integer.parseInt(in.nextLine().trim());
                        
                        System.out.println("Validity:");
                        dateValid = in.nextLine().trim();
                        
                        System.out.println("Inform the secret number:");
                        secretNumber = Integer.parseInt(in.nextLine().trim());
                        
                        System.out.println("Inform how many months of paying:");
                        parts = Integer.parseInt(in.nextLine().trim());
                        
                        //card = new credicard(cardNumber, dateValid, secretNumber);
                        
                        IF.buyAccommodation(this, code, destination,
                                           beginDate, endDate, numberPerson,
                                           age, cardNumber, dateValid, 
                                           secretNumber, parts);
                        
                        break;
                        
                    case "5":
                        System.out.println("");
                        System.out.println("Press:");
                        System.out.println("[1] to New Flights");
                        System.out.println("[2] to New Hotels");
                        System.out.println("[3] to change of Flight's prices");
                        System.out.println("[4] to change of Hotel's prices");
                        System.out.println("[5] to Flight Availability");
                        System.out.println("[6] to Hotel Availability");
                        cmd = in.nextLine().trim();
                        int int_cmd = Integer.parseInt(cmd);
                        
                        if (int_cmd > 6) {
                            System.out.println("Invalid option!");
                            break;
                        }
                        
                        System.out.println("Inform the end date of interest");
                        endDate = in.nextLine().trim();
                        if (cmd.equals("1") || cmd.equals("2")) {
                            IF.events(this, int_cmd, 0, endDate);
                        } else if (cmd.equals("3") || cmd.equals("5")) {
                            IF.queryAirTickets(this);
                            
                            System.out.println("Inform the code of Flight");
                            code = Integer.parseInt(in.nextLine().trim());
                            
                            IF.events(this, int_cmd, code, endDate);
                        } else if (cmd.equals("4") || cmd.equals("6")) {
                            IF.queryAccommodation(this);
                            
                            System.out.println("Inform the code of Hotel");
                            code = Integer.parseInt(in.nextLine().trim());
                            IF.events(this, int_cmd, code, endDate);
                        }
                        break;
                    default:
                        System.out.println("Invalid operation! Try again...");
                    
                }
                
            }
               
        } catch (NotBoundException ex) {
            Logger.getLogger(ImplemCli.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AccessException ex) {
            Logger.getLogger(ImplemCli.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
    /*
     Criar a classe servente do cliente - ImplemCli - que implementa a interface
     InterCli.
     Quando um servidor invocar o método echo(), o cliente apenas mostrará a 
     string recebida na tela. Nessa classe o cliente deve ter a referência do 
     servidor e com esta ele poderá chamar o método chamar() do servidor e 
     passará seu nome e sua referência (estando em ImplemCli, basta passar this);
     */
    
    @Override
    public void echo(String str) throws RemoteException {
        System.out.println(str);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
