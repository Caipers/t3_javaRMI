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
                System.out.println("Press:");
                System.out.println("[1] to query Air Tickets");
                System.out.println("[2] to buy Air Tickets");
                System.out.println("[3] to query Hotel accommodation");
                System.out.println("[4] to buy Hotel accommodation");
                cmd = in.nextLine().trim();
                
                switch (cmd) {
                    case "1":
                        IF.queryAirTickets(this);
                        break;
                    
                    case "2":
                        int code;
                        int type;
                        String from;
                        String destination;
                        String beginDate;
                        String endDate;
                        int numberPerson;
                        int cardNumber;
                        int parts;
                        String dateValid;
                        int secretNumber;
                        int age[];
                        credicard card;
                        
                        System.out.println("List of flights:");
                        IF.queryAirTickets(this);
                        
                        System.out.println("Please press the code of the flight:");
                        code = Integer.parseInt(in.nextLine().trim());
                                          
                        System.out.println("Press 1 to One-Way Ticket or " + 
                                           "2 to Two-Way Ticket");
                        type = Integer.parseInt(in.nextLine().trim());
                        System.out.println(""+type);
//                        if ((type != 1) || (type != 2)) {
//                            System.out.println("Invalid type of ticket!");
//                            break;
//                        }
                        
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
                        
                        card = new credicard(cardNumber, dateValid, secretNumber);
                        
                        IF.buyAirTickets(this, code, type, from, destination,
                                           beginDate, endDate, numberPerson,
                                           age, card, parts);
                        
                        System.out.println("Do you wish to buy Accommodations? Y/N");
                        String acc = in.nextLine().trim();
                        
                        if (acc.equals("Y")) {
                            // TODO
                            // buy accommodation
                        }
                        break;
                    case "3":
                        IF.queryAccommodation(this);
                        
                        break;
                        
                    case "4":
                        System.out.println("Inform destination (Hotel or City)");
                        destination = in.nextLine().trim();
                        
                        System.out.println("Start date:");
                        beginDate = in.nextLine().trim();
                        
                        System.out.println("Final date:");
                        endDate = in.nextLine().trim();
                        
                        System.out.println("Inform number of people:");
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
                        
                        card = new credicard(cardNumber, dateValid, secretNumber);
                        
                        IF.buyAccommodation(this, destination,
                                           beginDate, endDate, numberPerson,
                                           age, card, parts);
                        
                        break;
                    
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
