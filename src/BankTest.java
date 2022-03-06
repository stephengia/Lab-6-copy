/** This class calls methods from other classes to bring user experience to the project. 
 * It has on object of Bank class and has this method as a middle man to call specific method depending on user option
 *
 * @author Gia Bao Tran
 * @version 1.0
 * @since 15.0.2
 */
import java.util.Scanner;
public class BankTest{
    public static void main(String[] args){
/**A variable containing user option in number */
        int option=0;
        Scanner keyboard = new Scanner(System.in);

        /**Let user input bank name and size */
        System.out.printf("Enter the name of the bank: ");
        String name = keyboard.next();
        System.out.printf("How many account holder do you have: ");
        int size =keyboard.nextInt();
        Bank account = new Bank(name,size);

        /** Print a table and let user decide what they want to do */
        do{
            System.out.printf("1. Read account\n2. Monthly Process\n3. Print All Account \n4. Exit\nEnter your option: ");
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
				System.out.println("Goodbye... Have a nice day");
				System.out.println("Program developed by Gia Bao Tran");
			}
            
            else{  
                System.out.println("Invalid option ... try again");
            }
        
        }while(option != 4);

        keyboard.close();
    }
}