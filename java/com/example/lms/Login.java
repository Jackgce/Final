package com.example.lms;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        final EditText memname = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);
        Button login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pDialog.setMessage("Logging in ...");
                pDialog.show();

                String uname = memname.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if (!uname.isEmpty() && !pass.isEmpty()) {
                    if(uname.equals("admin") && pass.equals("pass")){
                        pDialog.hide();
                        Toast.makeText(getApplicationContext(),"Loggedin Successfully", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                        finish();
                    }else{
                        pDialog.hide();
                        Toast.makeText(getApplicationContext(),"Username or Password Incorrect"+uname+pass, Toast.LENGTH_LONG).show();
                    }
                }else{
                    pDialog.hide();
                    Toast.makeText(getApplicationContext(),"Please enter the credentials!", Toast.LENGTH_LONG).show();
                }


            }
        });

    }
}
