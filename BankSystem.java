
package com.mycompany.bank;
import javax.swing.JOptionPane;

public class BankSystem {
    
    private double balance;
    private int pinNum;
    
    public BankSystem(double balance, int pin){
        this.balance = balance;
        this.pinNum = pin;
    }

    public double updateBalance(double amount){
       return balance += amount;
    }
    
    public boolean pinValidation(int inputPin){
        return this.pinNum == inputPin;
    }
    public double withdraw(double amount){
        return balance -= amount;
    }
    
    public double showBalance(){
        return balance;
    }
   
    public static void main(String[] args) {
        BankSystem myAccount = new BankSystem(0.0, 1234);
        String[] options = {"1 - Deposit", "2 - Withaw", "3 - Check Balance", "4 - Exit"};
        
        
        while (true) {
          String inputPin = JOptionPane.showInputDialog("Enter your PIN");   
          int userPin = Integer.parseInt(inputPin);

          if (!myAccount.pinValidation(userPin)) {
                JOptionPane.showMessageDialog(null, "Incorrect PIN. Try again.");
            } else {
                break;
            }
        }
 
        while (true) {
        
        String showOption = String.join("\n", options);
        int userOptions = Integer.parseInt(JOptionPane.showInputDialog(null,showOption, "Options",JOptionPane.INFORMATION_MESSAGE));
        
        switch (userOptions) {
            case 1:
                String enterDeposit = JOptionPane.showInputDialog("Enter money");
                double moneyDeposited = Double.parseDouble(enterDeposit);
                myAccount.updateBalance(moneyDeposited);
                break;
            case 2:
                String enterWithdraw = JOptionPane.showInputDialog("How much would you like to withdraw");
                double moneyWithdraw = Double.parseDouble(enterWithdraw);
                
                if(moneyWithdraw > myAccount.balance){
                    JOptionPane.showMessageDialog(null,"Not enough money.");
                    continue;
                    
                }else{
                    myAccount.withdraw(moneyWithdraw);
                    JOptionPane.showMessageDialog(null, "Transaction Success!");
                    break;
                }
                
            case 3:
                JOptionPane.showMessageDialog(null, "Current Balance: " + myAccount.showBalance());
                break;
            case 4:
                System.exit(0);
                break;
            default:
                throw new AssertionError();
        }
    }
 }
}
