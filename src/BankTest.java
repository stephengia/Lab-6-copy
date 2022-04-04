/** This class calls methods from other classes to bring user experience to the project. 
 * It has on object of Bank class and has this method as a middle man to call specific method depending on user option
 *
 * @author Gia Bao Tran
 * @version 1.0
 * @since 15.0.2
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class BankTest{
    public static void main(String[] args){
/**A variable containing user option in number */
        int option=0;
        Scanner keyboard = new Scanner(System.in);
        
        /**Let user input bank name and size */
        System.out.printf("Enter the name of the bank: ");
        String name = keyboard.next();
        int size=0;

        /**Let user enter the name of the array list size */
        do{
            try{
                keyboard.nextLine();
                System.out.printf("How many account holders do you have: ");
                 size =keyboard.nextInt();
                 if(size < 1){
                     System.out.println("Invalid enter... please try again!");
                 }

            }
            catch(InputMismatchException e){
                System.out.println("Invalid... please try again!");
            }
        }while(size < 1);

        Bank account = new Bank(name,size);
        
        /** Print a table and let user decide what they want to do */
        do{
            try{
                keyboard.nextLine();
                System.out.printf("1. Read account\n2. Monthly Process\n3. Print All Account \n4. Read data from a file\n5. Write data from a file\n6. Exit\nEnter your option: ");
                option = keyboard.nextInt();
                if(option ==1){
                    account.readAccount(keyboard);
                }
                
                else if(option ==2){
                    account.monthlyProcess();
                }
                
                else if(option ==3){  
                    account.printAccount();
                }

                else if(option ==4){
                    account.readAccountFromFile();
                }

                else if(option == 5){
                    account.writeToAFile();
                }
                
                else if(option ==6){
                    System.out.println("Goodbye... Have a nice day!");
                    System.out.println("Program developed by Gia Bao Tran");
                }
                
                else{  
                    System.out.println("Invalid option ... try again!");
                }
                
                
            }catch(InputMismatchException e){
                System.out.println("Invalid option ... try again!\n");
        }
        
        
    }while(option != 6);
    
    keyboard.close();
}
}