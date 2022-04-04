/** This class calls methods from other class to work properly. 
 * It makes use of multiple methods from other classes also override them. 
 * Has methed to read/print user info. Print table header
 *
 * @author Gia Bao Tran
 * @version 1.0
 * @since 15.0.2
 */
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Bank{
    private int count=0;
    private String name;
    private int size;
    private ArrayList<Account> accounts;
    
    /** Constructor to set size and name o the bank 
     * @param String name
     * @param int size
    */
    public Bank(String name, int size){
         this.name = name;
         accounts = new ArrayList<Account>(size);
     }


     /**This method lets user define their account type and input their account
      * @return nothing
      * @param Scanner keyboard
     */
    public void readAccount(Scanner keyboard){
        int option=0;

        do{
            try{
                System.out.printf("1.Chequing\n2.Saving\nEnter your option: ");
                keyboard.nextLine();
                option = keyboard.nextInt();
                if(option != 1 && option != 2){
                    System.out.println("Invalid account type... please try again!\n");
                 }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid account type... please try again!\n");
            }
            
        }while(option != 1 && option != 2);

        if(option == 1 ){
            accounts.add(new Chequing());
            accounts.get(count).readInfo(keyboard);
            
        }
        else if(option == 2){
            accounts.add(new Saving());
            accounts.get(count).readInfo(keyboard);
        }
        count++;
    }

    /**Print all account information 
     * @return nothing
     * @param nothing
    */    
    public void printAccount(){
        if(count==0){
            System.out.println("No account to print! \n");
        }

        else{
            printTitle();
            for(int i=0; i< accounts.size(); i++){
                accounts.get(i).printInfo();
            }
        }
    }

    /**If this method is ever called, it will update account balance depending on account type
     * @return nothing
     * @param nothing
    */
    public void monthlyProcess(){
        if(count > 0){
            for (int i = 0; i < accounts.size(); i++){
                if(accounts.get(i) instanceof Chequing){
                    accounts.get(i).updateBalance();
                }
    
                else if(accounts.get(i) instanceof Saving){
                    accounts.get(i).updateBalance();
                }
            }
            System.out.println("Updated sucessfully!");

        }
        else{
            System.out.println("No account to process!\n");
        }
  
        
    }

    /**Print star to support table printing 
     * @param nothing
     * @return nothing
    */
    public void printStar(){
        System.out.printf("***********************************************************************************************\n");
    }

    /**Print table header 
     * @param nothing
     * @return nothing
    */
    public void printTitle(){
        printStar();
        System.out.printf("%45s BANK\n", name);
        printStar();
        System.out.printf("%15s  |%15s  |%15s |%20s |%20s \n","Account number","Name","Email","Phone number","Account Balance");
        printStar();
    }

     /**Read data from a file 
      * @param nothing
      * @return nothing
     */
     public void readAccountFromFile(){
         try {
            String accountType;
            File file = new File("/Users/transtephen/Desktop/Java/Lab 6/src/AccountsSource.txt");
            Scanner reader = new Scanner(file);
             
            //this loop will create new object of the people in the given source
            for(int i =1; i <=4; i++){
                
                //check for account type
                accountType = reader.next();

                //read account with Chequing type
                if(accountType.equals("C")){
                    accounts.add(new Chequing());
                    accounts.get(count).accountNumber =reader.nextInt();
                    accounts.get(count).accountHolder.firstName = reader.next();
                    accounts.get(count).accountHolder.lastName = reader.next();
                    accounts.get(count).accountHolder.email = reader.next();
                    accounts.get(count).accountHolder.phoneNumber=reader.nextLong();
                    accounts.get(count).accountBalance=reader.nextDouble();
                    count++;
                }

                //read account with Saving type
                else if(accountType.equals("S")){
                    accounts.add(new Saving());
                    accounts.get(count).accountNumber =reader.nextInt();
                    accounts.get(count).accountHolder.firstName = reader.next();
                    accounts.get(count).accountHolder.lastName = reader.next();
                    accounts.get(count).accountHolder.email = reader.next();
                    accounts.get(count).accountHolder.phoneNumber=reader.nextLong();
                    accounts.get(count).accountBalance=reader.nextDouble();
                    count++;
                }
            }
            reader.close();
            
            

        }
        catch (FileNotFoundException e) {
            System.out.println("File not found ");
        }

     }

     /**This method will produce all accounts' information to a text file
      * @return accounts' attributes to a text file
      * @param nothing
      */
     public void writeToAFile(){
         
         try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/transtephen/Desktop/Java/Lab 6/src/AccountsOutput.txt"));
            for(int i = 0; i < accounts.size(); i++){
                if(accounts.get(i) instanceof Chequing){
                    writer.write("C ");
                    writer.write(accounts.get(i).accountNumber+ " ");
                    writer.write(accounts.get(i).accountHolder.firstName+ " ");
                    writer.write(accounts.get(i).accountHolder.lastName+ " ");
                    writer.write(accounts.get(i).accountHolder.email+ " ");
                    writer.write(accounts.get(i).accountHolder.phoneNumber+ " ");
                    writer.write(accounts.get(i).accountBalance+ " ");
                    writer.write("\n");

                }

                else if(accounts.get(i) instanceof Saving){
                    writer.write("S ");
                    writer.write(accounts.get(i).accountNumber+ " ");
                    writer.write(accounts.get(i).accountHolder.firstName+ " ");
                    writer.write(accounts.get(i).accountHolder.lastName+ " ");
                    writer.write(accounts.get(i).accountHolder.email+ " ");
                    writer.write(accounts.get(i).accountHolder.phoneNumber+ " ");
                    writer.write(accounts.get(i).accountBalance+ " ");
                    writer.write("\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
     }


}