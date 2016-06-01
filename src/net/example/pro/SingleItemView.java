package net.example.pro;


import android.app.Activity; 
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView; 

public class SingleItemView extends Activity {   
	// Declare Variables   
	TextView txtname;   
	TextView txtname1;   
	TextView txtname2;   
	TextView txtname3;
	TextView txtname4;
	
	
	String itemname;     
	
	String itemdescription;
	String sellername;
	String selleremail;
	String sellerphone;
	
	@Override   
	public void onCreate(Bundle savedInstanceState) {     
		super.onCreate(savedInstanceState);     
		// Get the view from singleitemview.xml         
		setContentView(R.layout.singleitemview);       
		// Retrieve data from MainActivity on item click event        
		Intent i = getIntent();           // Get the name   
		itemname = i.getStringExtra("ItemName");
		itemdescription=i.getStringExtra("ItemDescription");
		sellername=i.getStringExtra("SellerName");
		selleremail=i.getStringExtra("SellerEmailId");
		sellerphone=i.getStringExtra("PhoneNumberSeller");
		// Locate the TextView in singleitemview.xml      
		txtname = (TextView) findViewById(R.id.item_name_value); 
		txtname1=(TextView)findViewById(R.id.item_description_value);
		txtname2 = (TextView) findViewById(R.id.signup_item_person_name); 
		
		txtname3=(TextView)findViewById(R.id.emailid_seller_value);
		txtname4=(TextView)findViewById(R.id.phone_number_seller_value);
// Load the text into the TextView    
		
		
	txtname.setText(itemname);  
	txtname1.setText(itemdescription);
	txtname2.setText(sellername);
	txtname3.setText(selleremail);
	txtname4.setText(sellerphone);
	} 
}