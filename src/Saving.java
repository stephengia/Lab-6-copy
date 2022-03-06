/** This class is a blue print to build a Saving account, it contains overridden version of updateBalance
 * @author Gia Bao Tran
 * @version 1.0
 * @since 15.0.2 
 */

public class Saving extends Account implements Policies{

/** Each time this method is called , it adds user's balance a saving interest amount */
    @Override
    public void updateBalance() {
        accountBalance = accountBalance + accountBalance*interestFee;
        
    }

}