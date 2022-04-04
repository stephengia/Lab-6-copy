/**
 * The purpose of this class is to set account holder's basic infomation and output them in a table format
 * @author Gia Bao Tran
 * @version 1.0
 * @since 15.0.2
 */



import java.util.Scanner;

public class Person {
    /** account holder first name */
    protected String firstName
    /** account holder last name */;
    protected String lastName;
    /** account holder email */
    protected String email;
    /** account holder phone number */
    protected long phoneNumber;

    /**
     * this method take will use keyboard Scanner object to set values for the fields.
     * @param keyboard
     * @return nothing
     */
    public void readInfo(Scanner keyboard){
        System.out.println("Enter account holder first name: ");
        firstName=keyboard.next();
        System.out.println("Enter account holder last name: ");
        lastName=keyboard.next();
        System.out.println("Enter account holder email: ");
        email = keyboard.next();
        System.out.println("Enter account holder phone number: ");
        phoneNumber=keyboard.nextLong();
    }

    /**
     * This method print out account holder basic infomation in table format
     * @param nothing
     * @return nothing
     */
    public void printInfo(){
        System.out.printf("%17s|%16s|%21s|", firstName+" "+lastName, email, phoneNumber);
    }
}
