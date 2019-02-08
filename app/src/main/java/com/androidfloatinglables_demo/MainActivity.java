package com.androidfloatinglables_demo;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static EditText name, email, number, location;
    private static TextInputLayout nameLayout, emailLayout, numberLayout, locationLayout;

    private static Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }


    //Initiate all views
    private void initViews() {
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        number = (EditText) findViewById(R.id.number);
        location = (EditText) findViewById(R.id.location);

        nameLayout = (TextInputLayout) findViewById(R.id.nameLayout);
        emailLayout = (TextInputLayout) findViewById(R.id.emailLayout);
        numberLayout = (TextInputLayout) findViewById(R.id.numberLayout);
        locationLayout = (TextInputLayout) findViewById(R.id.locationLayout);

        submit = (Button) findViewById(R.id.submit);


        //Implement click listener over button
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkValidation();//Call check validation method

            }
        });
    }

    //Check Validation Method will check if all fields are filled or not
    private void checkValidation() {
        String getName = name.getText().toString();
        String getEmail = email.getText().toString();
        String getNumber = number.getText().toString();
        String getLocation = location.getText().toString();


        //If fields are empty then set error over TextInputLayout over their corresponding EditText
        if (getName.equals("") || getName.length() == 0)
            nameLayout.setError("Enter your full name.");
        else if (getEmail.equals("") || getEmail.length() == 0)
            emailLayout.setError("Enter your email id.");
        else if (getNumber.equals("") || getNumber.length() == 0)
            numberLayout.setError("Enter your contact number.");
        else if (getLocation.equals("") || getLocation.length() == 0)
            locationLayout.setError("Enter your location.");
        else
        //If all fields are filled then do your stuff
            Toast.makeText(MainActivity.this, "All fields are filled.", Toast.LENGTH_SHORT).show();

    }


}
