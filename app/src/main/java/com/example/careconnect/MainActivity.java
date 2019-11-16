package com.example.careconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText name,email,phonenumber,pass,retryemail,bloodgroup;
Button login;
String sname,semail,sphonenumber,spass,sretryemail,sbloodgroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.name);

      //  sname=name.
        login=(Button)findViewById(R.id.login);
        email=(EditText)findViewById(R.id.email);
        semail=email.getText().toString();

        pass=(EditText)findViewById(R.id.pass);
        spass=pass.getText().toString();

        phonenumber=(EditText)findViewById(R.id.phonenumber);

        retryemail=(EditText)findViewById(R.id.retryemail);
        sretryemail=retryemail.getText().toString();
        bloodgroup=(EditText)findViewById(R.id.bloodgroup);
        login.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
sname=name.getText().toString();
semail=email.getText().toString();
spass=pass.getText().toString();
sphonenumber=phonenumber.getText().toString();
sbloodgroup=bloodgroup.getText().toString();
                signinmodel s=new signinmodel(sname,semail,spass,sphonenumber,sbloodgroup);
                dbhelper dbhelper=new dbhelper(MainActivity.this);
int value=                dbhelper.insert(s);
if(value==1)
{

            Toast.makeText(MainActivity.this,"data entered successfully",Toast.LENGTH_SHORT).show();
    Intent intent=new Intent(MainActivity.this,loginactivity.class);
   startActivity(intent);
}
//        if(name.getText().toString().equals("")||pass.getText().toString().equals(""))
//        {
//            Toast.makeText(MainActivity.this,"name or password can't be emapty",Toast.LENGTH_SHORT).show();
//
//        }
//
//        else if(email.getText().toString().equals(retryemail.getText().toString()))
//        {
//            Toast.makeText(MainActivity.this,"data entered successfully",Toast.LENGTH_SHORT).show();
//
//        }
//                else
//        {
//            Toast.makeText(MainActivity.this,"email not type correctly",Toast.LENGTH_SHORT).show();
//        }
//        if(email.equals(retryemail)&& sum==0)
//        {
//            Toast.makeText(MainActivity.this,"data entered successfully",Toast.LENGTH_SHORT).show();
//
//        }


            }
        });
        //d.getWritableDatabase();
    }
}
