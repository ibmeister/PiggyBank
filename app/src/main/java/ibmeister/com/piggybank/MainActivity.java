package ibmeister.com.piggybank;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseObject;
import com.stripe.android.model.Card;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Parse.enableLocalDatastore(this);
        Parse.initialize(this);

        ParseObject testClass = new ParseObject("testClass");
        testClass.put("foo", "bar");
        testClass.put("moo", "bar");
        testClass.put("foo", "lar");
        testClass.put("get", "rekt");
        testClass.put("foo", "foo bar");

        testClass.saveInBackground();
    }

    public void onClickChoosePaymentMethod (View view){
        //Get reference to Text View
        TextView cards = (TextView) findViewById(R.id.cards);

        //Get reference to Spinner
        Spinner paymentMethods = (Spinner) findViewById(R.id.payment_method);

        //Get selected item in tSpinner
        String cardSelection = String.valueOf(paymentMethods.getSelectedItem());

        //Display selected item
        cards.setText(cardSelection);
    }


    Card card = new Card("4242-4242-4242-4242", 12, 2017, "123");
    boolean numberValidation = card.validateNumber();
    boolean cvcValidation = card.validateCVC();



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
