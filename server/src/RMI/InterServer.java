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
 * 
 * Main methods:
 * 1) Consultar passagens aereas disponíveis
 *    Constructor (Tipo, Origem, Destino, Ida, Volta, ListaDePessoas).      
 * 2) Comprar passagens aereas
 *    Constructor (Tipo, Origem, Destino, Ida, Volta, ListaDePessoas, Cartao, 
 *                Parcelamento).
 * 3) Consultar hospedagem
 *    Constructor: (Destino (Cidade ou Hotel), Entrada, Saida, Numero de 
 *                 quartos, ListadePessoas)
 * 4) Comprar hospedagem
 *    Constructor: (Destino (Cidade ou Hotel), Entrada, Saida, Numero de 
 *                 quartos, ListadePessoas, Cartao, Parcelamento).
 * 5) Registro de interesse
 * 
 * 6) Adicionar novo voo
 * 7) Adicionar novas vagas hoteis
 * 
 * Supporting classes:
 *    
 *      
 *    
 * 
 *  
 *
 *   
 *        
 */


public interface InterServer extends Remote {
    public void queryAirTickets(InterCli interCli) throws RemoteException;
    public void buyAirTickets(InterCli interCli, int code, int type, String from, 
                              String departure, String beginDate, String endDate, 
                              int numberOfPeople, int age[], credicard card, 
                              int parts) throws RemoteException;
    public void queryAccommodation(InterCli interCli) throws RemoteException;
    public void buyAccommodation(InterCli interCli, String destination,
                                String beginDate, String endDate, int numberPerson,
                                int age[], credicard card, int parts) 
                                throws RemoteException;
}
