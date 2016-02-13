package ibmeister.com.piggybank;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.stripe.android.model.Card;


/**
 * Created by Ibrahim on 1/23/2016.
 */
public class PaymentActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
    }

    public void onClickChoosePaymentMethod (View view){

    }


   Card card = new Card("4242-4242-4242-4242", 12, 2017, "123");
   boolean numberValidation = card.validateNumber();
   boolean cvcValidation = card.validateCVC();


}
