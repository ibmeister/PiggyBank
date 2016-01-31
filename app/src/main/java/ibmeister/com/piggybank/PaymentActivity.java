package ibmeister.com.piggybank;


import com.stripe.android.model.*;


/**
 * Created by Ibrahim on 1/23/2016.
 */
public class PaymentActivity{

    Card card = new Card("4242-4242-4242-4242", 12, 2017, "123");


   boolean numberValidation = card.validateNumber();
   boolean cvcValidation = card.validateCVC();
}
