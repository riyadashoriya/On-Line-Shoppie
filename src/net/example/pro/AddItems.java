package net.example.pro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.regex.Pattern;

//import android.graphics.Bitmap;
//import android.widget.Button;
//import android.widget.TextView;

public class AddItems extends Activity {
    //Regex expressions for security purpose of input fields
    final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
    );
    final Pattern ITEMDESCRIPTION_PATTERN = Pattern.compile(

            "^[A-Za-z0-9_-]{0,300}$"
    );
    final Pattern NAME_PATTERN = Pattern.compile(

            "[a-zA-Z ]{7,30}"

    );
    final Pattern ITEMNAME_PATTERN = Pattern.compile(
            "[a-zA-z0-9]{4,50}"
    );

    //Initialize variables and objects
    String[] list;
    int index;
    private EditText aEdit;
    private EditText bEdit;
    private EditText cEdit;
    private EditText dEdit;
    private EditText eEdit;
    private Spinner fspin;
    private CheckBox cb;

    //Method to run when class is called
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser == null) {
            Intent intent = new Intent(this, User.class);
            startActivity(intent);
            finish();
        }

        //Set the layout of the screen
        setContentView(R.layout.additems);
        list = getResources().getStringArray(R.array.list);
        Spinner s1 = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        s1.setAdapter(adapter);
        s1.setOnItemSelectedListener(new OnItemSelectedListener() {
                                         @Override
                                         public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                                             index = arg0.getSelectedItemPosition();
                                             Toast.makeText(getBaseContext(), "You have selected item:" + list[index], Toast.LENGTH_SHORT).show();
                                         }

                                         @Override
                                         public void onNothingSelected(AdapterView<?> arg0) {
                                             // TODO Auto-generated method stub

                                         }
                                     }
        );
    }

    //Method to call when 'Add Items' button is clicked
    //Takes the input value from the fields, sanitize and validate it, store in database and return the result
    public void onClick13(View v) throws ParseException {

        aEdit = (EditText) findViewById(R.id.item_name_value);
        final String a = aEdit.getText().toString();
        bEdit = (EditText) findViewById(R.id.item_description_value);
        final String b = bEdit.getText().toString();
        cEdit = (EditText) findViewById(R.id.signup_item_person_name);
        final String c = cEdit.getText().toString();
        dEdit = (EditText) findViewById(R.id.emailid_seller_value);
        final String d = dEdit.getText().toString();
        eEdit = (EditText) findViewById(R.id.phone_number_seller_value);
        final String e = eEdit.getText().toString();
        fspin = (Spinner) findViewById(R.id.spinner);
        final String f = fspin.getContext().toString();
        cb = (CheckBox) findViewById(R.id.are_you_sure);


        if (a.equals("") || b.equals("") || c.equals("") || d.equals("")
                || e.equals("") || f.equals("")) {
            Toast.makeText(getApplicationContext(),
                    "Please complete the Item Description",
                    Toast.LENGTH_LONG).show();
        } else {
            if (cb.isChecked()) {
                if (a.length() > 3 && a.length() < 51 && checkItemName(a)) {
                    if (b.length() > 24 && b.length() < 301 && checkItemDescription(b)) {
                        if (c.length() > 7 && c.length() < 30 && checkName(c)) {
                            if (e.length() >= 10 && e.length() < 12) {
                                if (checkEmail(d)) {
                                    ParseObject testObj1;
                                    String m = "Electronics";
                                    String n = "Vehicles";
                                    String o = "Other";
                                    //String p="Books";
                                    if (list[index].matches(m)) {

                                        testObj1 = new ParseObject("TesObe");
                                    } else if (list[index].matches(n)) {
                                        testObj1 = new ParseObject("TesObv");


                                    } else if (list[index].matches(o)) {
                                        testObj1 = new ParseObject("TesObo");
                                    } else {
                                        testObj1 = new ParseObject("TesObb");
                                    }


                                    testObj1.put("ItemName", a);
                                    testObj1.put("ItemDescription", b);
                                    testObj1.put("SellerName", c);
                                    testObj1.put("SellerEmailId", d);
                                    testObj1.put("PhoneNumberSeller", e);
                                    testObj1.put("Category", list[index]);


                                    testObj1.save();


                                    Intent i = new Intent(AddItems.this, Login.class);
                                    startActivity(i);
                                    Toast.makeText(getApplicationContext(),
                                            "Congratulations! Your item has been put on sale under its specified category",
                                            Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(getApplicationContext(),
                                            "Email is not in correct format. It should be in the form my@example.com", Toast.LENGTH_LONG).show();
                                }
                            } else {

                                Toast.makeText(getApplicationContext(),
                                        "Phone number is not in correct format. ", Toast.LENGTH_LONG).show();

                            }
                        } else {

                            Toast.makeText(getApplicationContext(),
                                    "Your name is not valid. It must contain only character from " +
                                            "A-Z, a-z or white space and can be 8 to 30 characters long ", Toast.LENGTH_LONG).show();

                        }
                    } else {

                        Toast.makeText(getApplicationContext(),
                                "Item Description is not valid. It must contain 25-" +
                                        "300 characters ranging from A-Z, a-z, 0-9 and special characters like - and _", Toast.LENGTH_LONG).show();

                    }
                } else {


                    Toast.makeText(getApplicationContext(),
                            "Item name should be between 4 to 50 characters long and can contain only A-Z, a-z and 0-9", Toast.LENGTH_LONG).show();

                }

            } else {
                Toast.makeText(getApplicationContext(),
                        "Check if the information is correct", Toast.LENGTH_LONG).show();
            }
        }
    }

    //Methods for sanitization and validation
    private boolean checkEmail(String d) {
        return EMAIL_ADDRESS_PATTERN.matcher(d).matches();

    }

    private boolean checkItemDescription(String b) {
        return ITEMDESCRIPTION_PATTERN.matcher(b).matches();

    }

    private boolean checkName(String c) {
        return NAME_PATTERN.matcher(c).matches();
    }

    private boolean checkItemName(String a) {
        return ITEMNAME_PATTERN.matcher(a).matches();
    }
}