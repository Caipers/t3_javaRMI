/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

/**
 *
 * @author root
 * 1) Cartão
 *    Methods:
 *        Constructor: (Numero Cartao, Bandeira, Emissao Cartao, Vencimento
 *                     Cartao, Valor Verificador)
 */
public class credicard {
    private int number;
    private String issuer;
    private String dateBegin;
    private String dateValid;
    private int secretNumber;
    
    
    public credicard(int number, String issuer, String dateBegin, 
                     String dateValid, int secretNumber) {
        this.number = number;
        this.issuer = issuer;
        this.dateBegin = dateBegin;
        this.dateValid = dateValid;
        this.secretNumber = secretNumber;
    }
}
