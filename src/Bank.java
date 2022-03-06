/** This class calls methods from other class to work properly. 
 * It makes use of multiple methods from other classes also override them. 
 * Has methed to read/print user info. Print table header
 *
 * @author Gia Bao Tran
 * @version 1.0
 * @since 15.0.2
 */

import java.util.ArrayList;
import java.util.Scanner;
public class Bank{
    int count=0;
    private String name;
    private int size;
    private ArrayList<Account> accounts;
    
    /** Constructor to set size and name o the bank */
    public Bank(String name, int size){
         this.name = name;
         accounts = new ArrayList<Account>(size);
     }


     /**This method lets user define their account type and input their account*/
    public void readAccount(Scanner keyboard){
        int option=0;

        do{
            System.out.printf("1.Chequing\n2.Saving\nEnter your option: ");
            option = keyboard.nextInt();
            if(option != 1 && option != 2){
                System.out.println("Invalid option... please try again");
            }
        }while(option != 1 && option != 2);

        if(option == 1 ){
            accounts.add(new Chequing());
            accounts.get(count).readInfo(keyboard);
            System.out.println("press anykey to continnue");
        }
        else if(option == 2){
            accounts.add(new Saving());
            accounts.get(count).readInfo(keyboard);
        }
        count++;
    }

    /**Print all account information */    
    public void printAccount(){
        if(count==0){
            System.out.println("No account in system \n");
        }

        else{
            printTitle();
            for(int i=0; i< accounts.size(); i++){
                accounts.get(i).printInfo();
            }
        }
    }

    /**If this method is ever called, it will update account balance */
    public void monthlyProcess(){
        for (int i = 0; i < accounts.size(); i++){
            if(accounts.get(i) instanceof Chequing){
                accounts.get(i).updateBalance();
            }

            else if(accounts.get(i) instanceof Saving){
                accounts.get(i).updateBalance();
            }
        }
        System.out.println("Updated sucessfully");
  
        
    }

    /**Print star to support table printing */
    public void printStar(){
        System.out.printf("***********************************************************************************************\n");
    }

    /**Print table header */
    public void printTitle(){
        printStar();
        System.out.printf("%45s BANK\n", name);
        printStar();
        System.out.printf("%15s  |%15s  |%15s |%20s |%20s \n","Account number","Name","Email","Phone number","Account Balance");
        printStar();
    }

     


}