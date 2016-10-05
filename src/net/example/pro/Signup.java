package net.example.pro;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.regex.Pattern;

public class Signup extends Activity {

    //Regex expressions for validation and sanitization
    final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"

    );

    final Pattern USERNAME_PATTERN = Pattern.compile(
            "^[A-Za-z0-9_-]{3,15}$"
    );

    final Pattern NAME_PATTERN = Pattern.compile(
            "[a-zA-Z ]{3,25}"

    );

    //Initialize objects
    private EditText aEdit;
    private EditText bEdit;
    private EditText cEdit;
    private EditText dEdit;
    private EditText eEdit;
    private EditText fEdit;
    private EditText gEdit;
    private CheckBox chk;

    //Method to run when class is called
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Parse.initialize(this, "Dz3FMHXFQ0XzRS98PGv4TmAjDLasPvohYpQRhPzH", "fRjyTWPlYLuAbPIaO46plxiSy5JHErPHUrklE5vS");
        setContentView(R.layout.signup);
    }

    //Button to direct to item class
    public void onClick1(View v) {
        Intent i = new Intent(Signup.this, Item.class);
        startActivity(i);
        //finish();
    }

    //Button to direct to User class
    public void onClick2(View v) {
        Intent i = new Intent(Signup.this, User.class);
        startActivity(i);
        //finish();
    }

    //Form for sign up, user enter value, after sanitization and validation, data is saved to database. User is created.
    public void onClick5(View v) throws ParseException {

        chk = (CheckBox) findViewById(R.id.signup_agree);
        aEdit = (EditText) findViewById(R.id.signup_name_value);
        final String a = aEdit.getText().toString();
        bEdit = (EditText) findViewById(R.id.signup_email);
        final String b = bEdit.getText().toString();
        cEdit = (EditText) findViewById(R.id.signup_username_value);
        final String c = cEdit.getText().toString();
        dEdit = (EditText) findViewById(R.id.signup_password_value);
        final String d = dEdit.getText().toString();
        eEdit = (EditText) findViewById(R.id.signup_address_value);
        final String e = eEdit.getText().toString();
        fEdit = (EditText) findViewById(R.id.signup_phonenumber_value);
        final String f = fEdit.getText().toString();
        gEdit = (EditText) findViewById(R.id.signup_retype_password_value);
        final String g = gEdit.getText().toString();
        final int fl = f.length();
        final int a1 = a.length();
        final int c1 = c.length();

        if (a.equals("") || b.equals("") || c.equals("") || d.equals("")
                || e.equals("") || f.equals("")) {
            Toast.makeText(getApplicationContext(),
                    "Please complete the sign up form",
                    Toast.LENGTH_LONG).show();
        } else {
            if (d.equals(g)) {
                if (checkName(a) && (a1 > 3) && (a1 < 26)) {
                    if (checkEmail(b)) {
                        if (checkUsername(c) && (c1 > 3) && (c1 < 16)) {
                            if (fl >= 10 && fl < 12) {
                                if (chk.isChecked()) {
                                    final ParseObject testObj1 = new ParseObject("TesOb1");
                                    testObj1.put("name", a);
                                    testObj1.put("EmailAddress", b);
                                    testObj1.put("Username", c);
                                    testObj1.put("Password", d);
                                    testObj1.put("Address", e);
                                    testObj1.put("PhoneNumber", f);

                                    final ParseUser user = new ParseUser();
                                    user.setUsername(c);
                                    user.setPassword(d);
                                    user.setEmail(b);

                                    user.signUpInBackground(new SignUpCallback() {

                                        public void done(ParseException e1) {
                                            if (e1 == null) {

                                                try {
                                                    testObj1.save();
                                                    //finish();
                                                } catch (ParseException e2) {
                                                    e2.printStackTrace();
                                                }

                                                // Show a simple Toast message upon successful registration
                                                Intent i = new Intent(Signup.this, Login.class);  //Login.class
                                                startActivity(i);
                                                //finish();
                                                Toast.makeText(getApplicationContext(),
                                                        "Successfully Signed Up! Welcome.",
                                                        Toast.LENGTH_LONG).show();

                                            } else {

                                                switch (e1.getCode()) {

                                                    case ParseException.ACCOUNT_ALREADY_LINKED:
                                                        Toast.makeText(getApplicationContext(), "Account is already taken", Toast.LENGTH_LONG).show();
                                                        break;


                                                    case ParseException.EMAIL_TAKEN:
                                                        Toast.makeText(getApplicationContext(), "Account is already taken", Toast.LENGTH_LONG).show();

                                                        break;

                                                    case ParseException.INVALID_EMAIL_ADDRESS:

                                                        Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_LONG).show();
                                                        break;


                                                    case ParseException.DUPLICATE_VALUE:

                                                        Toast.makeText(getApplicationContext(), "Already Taken", Toast.LENGTH_LONG).show();

                                                        break;

                                                    case ParseException.EMAIL_NOT_FOUND:

                                                        Toast.makeText(getApplicationContext(), "Email is not found", Toast.LENGTH_LONG).show();

                                                        break;

                                                    case ParseException.VALIDATION_ERROR:
                                                        Toast.makeText(getApplicationContext(), "eMAIL ID IS NOT VALIDATED", Toast.LENGTH_LONG).show();


                                                    case ParseException.LINKED_ID_MISSING:
                                                        Toast.makeText(getApplicationContext(), "Account id is not found", Toast.LENGTH_LONG).show();

                                                        break;

                                                    case ParseException.USERNAME_TAKEN:
                                                        Toast.makeText(getApplicationContext(), "Username is already Taken", Toast.LENGTH_LONG).show();

                                                        break;

                                                }


                                            }
                                        }

                                    });

                                } else {

                                    Toast.makeText(getApplicationContext(),
                                            "Select checkbox and agree for terms and conditions",
                                            Toast.LENGTH_LONG).show();
                                }

                            } else {
                                Toast.makeText(getApplicationContext(),
                                        "Phone number is not valid",
                                        Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(),
                                    "Username is not valid. It can contain 4-" +
                                            "15 characters ranging from A-Z, a-z, 0-9 and special characters like - and _",
                                    Toast.LENGTH_LONG).show();

                        }

                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Email address is not valid. It should be in the form my@example.com",
                                Toast.LENGTH_LONG).show();

                    }
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Your name is not valid. It must contain only character from " +
                                    "A-Z, a-z or white space and can be 4 to 25 character long ",
                            Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getApplicationContext(),
                        "Both Passwords dont match",
                        Toast.LENGTH_LONG).show();

            }
        }
    }

    //Validation and sanitization methods
    private boolean checkEmail(String b) {
        return EMAIL_ADDRESS_PATTERN.matcher(b).matches();

    }

    private boolean checkUsername(String d) {
        return USERNAME_PATTERN.matcher(d).matches();

    }

    private boolean checkName(String d) {
        return NAME_PATTERN.matcher(d).matches();
    }

}
