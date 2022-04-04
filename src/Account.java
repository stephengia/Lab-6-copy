/**
 * The purpose of this class is to set account holder's basic infomation and output them in a table format. 
 * Also provide a method to let user update their account balance later on
 * @author Gia Bao Tran
 * @version 1.0
 * @since 15.0.2
 */

import java.util.Scanner;
public abstract class Account{
    /**This is account holder specific ID */
    protected int accountNumber;
    /**This variable represents the balance in account */
    protected double accountBalance;
    /** Person obj to get accessed to Person class */
    Person accountHolder=new Person();


    /**This method will call readInfo from Person class to aid it read user's information, prevent user from entering negative balance
     * @param keyboard
     * @return nothing
     */
    public void readInfo(Scanner keyboard){
        System.out.println("Enter account number: ");
        accountNumber= keyboard.nextInt();
        accountHolder.readInfo(keyboard);
        System.out.println("Enter account balance: ");
        accountBalance=keyboard.nextDouble();
        while(accountBalance < 0 ){
            System.out.println("Invalid!!! Please try again");
            System.out.println("Enter account balance: ");
            accountBalance=keyboard.nextDouble();
        }
    }


    /** This method will have the same-named method from Person class help it print out account holder infomation in table format
     * @param nothing
     * @return nothing
     */
    public void printInfo(){
        System.out.printf("%17o|",accountNumber);
        accountHolder.printInfo();
        System.out.printf("%20.2f\n",accountBalance);
    }


    /** This method let user update their balance depending on their account type; therefore, set to be abstract */
    public abstract void updateBalance();




}