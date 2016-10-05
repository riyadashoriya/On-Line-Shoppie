package net.example.pro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class Item extends Activity {

    //Method to run when class is called
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);
    }

    //Create a menu bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //Button for directing to item class
    public void onClick1(View v) {
        Intent i = new Intent(Item.this, Item.class);
        startActivity(i);
        //finish();
    }

    //Button for directing to User class
    public void onClick2(View v) {

        Intent i = new Intent(Item.this, User.class);
        startActivity(i);
        //	finish();
    }

    //Button for directing to Electronics class
    public void onClick7(View v) {

        Intent i = new Intent(Item.this, Electronics.class);
        startActivity(i);
        //finish();
    }

    //Button for directing to Books class
    public void onClick8(View v) {

        Intent i = new Intent(Item.this, Books.class);
        startActivity(i);
        //	finish();
    }


    //Button for directing to Vehicle class
    public void onClick9(View v) {

        Intent i = new Intent(Item.this, Vehicles.class);
        startActivity(i);
        //finish();
    }


    //Button for directing to Other Items class
    public void onClick10(View v) {

        Intent i = new Intent(Item.this, OtherItems.class);
        startActivity(i);
        //finish();
    }

}
