package com.mail.secure.securemail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class Registry extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry);

        getSupportActionBar().hide();  // hide top bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //full screen

        final EditText email = (EditText)findViewById(R.id.email_edt);
        final EditText pass = (EditText)findViewById(R.id.pass_edt);
        final EditText phone = (EditText)findViewById(R.id.phone_edt);

        Button btrRegister = (Button) findViewById(R.id.btrRegister);
        btrRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getEmail = email.getText().toString();
                String getPass = pass.getText().toString();
                String getPhone = phone.getText().toString();
                userInfo userinfo  = new userInfo();
                userinfo.pushInfoEmailServer(getEmail,getPass,Registry.this);
                userinfo.pushInfo(getEmail,getPass,getPhone,Registry.this);

                Toast.makeText(Registry.this, getString(R.string.registration_done), Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
