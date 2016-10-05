package net.example.pro;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

//import android.content.Intent;
//import com.parse.ParseQuery;
//import java.util.ArrayList;
//import com.parse.ParseQuery;
//import android.app.Activity;
//import android.os.Bundle;
//import android.app.Activity;
//import android.os.Bundle;
//import android.widget.Spinner;
//import com.parse.ParseQuery;  


public class OtherItems extends Activity {

    //Initialize objects
    ListView listview;
    List<ParseObject> ob;
    ProgressDialog mProgressDialog;
    ArrayAdapter<String> adapter;

    //Method to run when class is called
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Parse.initialize(this, "Dz3FMHXFQ0XzRS98PGv4TmAjDLasPvohYpQRhPzH", "fRjyTWPlYLuAbPIaO46plxiSy5JHErPHUrklE5vS");
        ParseAnalytics.trackAppOpened(getIntent());


        setContentView(R.layout.listview_main);
        //Spinner spin=new Spinner(getApplicationContext());
        //spin.setId(1);
        // Execute RemoteDataTask AsyncTask
        new RemoteDataTask().execute();
    }

    // RemoteDataTask AsyncTask
    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {

        protected Void doInBackground(Void... params) {
            // Locate the class table named "Country" in Parse.com
            //  ParseObject testObj1 = new ParseObject("TesOb3");

            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("TesObo");
            // Spinner spin=new Spinner(getApplicationContext());

            {
                query.orderByDescending("_created_at");
                try {
                    ob = query.find();
                } catch (ParseException e) {
                    Log.e("Error", e.getMessage());
                    e.printStackTrace();
                }
                return null;
            }

        }

        //Get values from database to show the results
        @Override
        protected void onPostExecute(Void result) {
            //int[] list = null;
            //int[] list2 = list;
            //for(R.array.list = list2[Electronics];;)
            //{
            // Locate the listview in listview_main.xml


            listview = (ListView) findViewById(R.id.listview); //listview
            // Pass the results into an ArrayAdapter
            adapter = new ArrayAdapter<String>(OtherItems.this, R.layout.listview_item);
            // int index;
            // Retrieve object "name" from Parse.com database
            for (ParseObject ItemName : ob) {
                adapter.add((String) ItemName.get("ItemName"));
            }             // Binds the Adapter to the ListView
            listview.setAdapter(adapter);             // Close the progressdialog
            // mProgressDialog.dismiss();
            // Capture button clicks on ListView items
            listview.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // Send single item click data to SingleItemView Class
                    Intent i = new Intent(OtherItems.this,
                            SingleItemView.class);
                    // Pass data "name" followed by the position
                    i.putExtra("ItemName", ob.get(position).getString("ItemName")
                            .toString());
                    i.putExtra("ItemDescription", ob.get(position).getString("ItemDescription")
                            .toString());
                    i.putExtra("SellerName", ob.get(position).getString("SellerName")
                            .toString());
                    i.putExtra("SellerEmailId", ob.get(position).getString("SellerEmailId")
                            .toString());
                    i.putExtra("PhoneNumberSeller", ob.get(position).getString("PhoneNumberSeller")
                            .toString());
                    // Open SingleItemView.java Activity

                    startActivity(i);
                }
            });

            //  mProgressDialog.dismiss();

        }
    }
}

	
	
	
	
		 
