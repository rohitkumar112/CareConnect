package com.example.careconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

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
                final signinmodel s=new signinmodel(sname,semail,spass,sphonenumber,sbloodgroup);
                //connection to api




                AndroidNetworking.post("http://192.168.137.1:8044/api/signin")
                        //.addBodyParameter(loginModel)

                        .addBodyParameter("id", String.valueOf(44))
                        .addBodyParameter("name",sname)
                        .addBodyParameter("pass",spass)
                        .addBodyParameter("phonenumer",sphonenumber)
                        .addBodyParameter("bloodgroup",sbloodgroup)
                        .setTag("test")
                        .setPriority(Priority.MEDIUM)
                        .build()
                        .getAsObject(Signinverify.class, new ParsedRequestListener<Signinverify>() {

//                            @Override
//                            public void onResponse(Loginapi response) {
//
//                                if(response.isIsSuccess()) {
//                                    String s = response.getData().getStatus().toString();
//                                    if (s.equals("Successful")) {
//                                        final Intent i=new Intent(InfoEmail.this,JaibNavigation.class);
//
////                                            Toast.makeText(InfoEmail.this, "jaj", Toast.LENGTH_LONG).show();
//
//                                        UserInfoModel userInfoModel = new UserInfoModel(response.getData().getId(),firstname,lastname,dob,gender,country,lang,num,password.getText().toString(),0);
//                                        // UserInfoDAO userInfoDAO = new UserInfoDAO(InfoEmail.this).;
//                                        UserInfoDAO userInfoDAO;
//                                        userInfoDAO = new UserInfoDAO(InfoEmail.this);
//                                        userInfoDAO.openWrite();
//                                        userInfoDAO.insert(userInfoModel);
//                                        userInfoDAO.close();
//                                        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(InfoEmail.this);
//                                        SharedPreferences.Editor editor = sharedPref.edit();
//                                        editor.putBoolean("is_remember", true);
//                                        editor.putInt("user_id", response.getData().getId());
//                                        editor.apply();
//
//
//                                        startActivity(i);
//                                    }
//                                }else
//                                {
//                                    System.out.println("*******************++++++++++++++++++++**********************---------------"+response.getErrors());
//                                    //    Toast.makeText(InfoEmail.this, response.getErrors().toString(), Toast.LENGTH_LONG).show();
//                                }
//                            }

                            @Override
                            public void onResponse(Signinverify response) {
                                                dbhelper dbhelper=new dbhelper(MainActivity.this);
int value=dbhelper.insert(s);
if(value==1)
{
    Toast.makeText(MainActivity.this,"data entered successfully",Toast.LENGTH_SHORT).show();
    Intent intent=new Intent(MainActivity.this,loginactivity.class);
   startActivity(intent);
}
                            }

                            @Override
                            public void onError(ANError error) {
                                Toast.makeText(MainActivity.this, "Error : "+error.getMessage(), Toast.LENGTH_LONG).show();
                                // handle error
                            }
                        });


//                dbhelper dbhelper=new dbhelper(MainActivity.this);
//int value=dbhelper.insert(s);
//if(value==1)
//{
//    Toast.makeText(MainActivity.this,"data entered successfully",Toast.LENGTH_SHORT).show();
//    Intent intent=new Intent(MainActivity.this,loginactivity.class);
//   startActivity(intent);
//}
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
