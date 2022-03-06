import java.util.Scanner;
public class BankTest{
    public static void main(String[] args){

        
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the name of the bank: ");
        String name = keyboard.next();
        System.out.println("How many account holder do you have: ");
        int size =keyboard.nextInt();
        Bank account = new Bank(name,size);




        keyboard.close();
    }
}