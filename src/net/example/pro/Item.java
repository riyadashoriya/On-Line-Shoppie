package net.example.pro;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.app.Activity;
import android.content.Intent;
public class Item extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onClick1(View v)
	{
		Intent i=new Intent(Item.this,Item.class);
		startActivity(i);
		//finish();
	}
	public void onClick2(View v)
	{
		
		Intent i=new Intent(Item.this,User.class);
		startActivity(i);
	//	finish();
	}
	public void onClick7(View v)
	{
		
		Intent i=new Intent(Item.this,Electronics.class);
		startActivity(i);
		//finish();
	}
	public void onClick8(View v)
	{
		
		Intent i=new Intent(Item.this,Books.class);
		startActivity(i);
	//	finish();
	}public void onClick9(View v)
	{
		
		Intent i=new Intent(Item.this,Vehicles.class);
		startActivity(i);
		//finish();
	}public void onClick10(View v)
	{
		
		Intent i=new Intent(Item.this,OtherItems.class);
		startActivity(i);
		//finish();
	}
	
}
