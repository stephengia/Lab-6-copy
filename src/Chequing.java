/** This class is a blue print to build a Chequing account, it contains overridden version of updateBalance
 * @author Gia Bao Tran
 * @version 1.0
 * @since 15.0.2
 */

public class Chequing extends Account implements Policies{

    /** Each time this method is callled, it automatically deduct an amount from the balance */
    @Override
    public void updateBalance() {
        accountBalance = accountBalance -checquingFee;
        
    }
    

}