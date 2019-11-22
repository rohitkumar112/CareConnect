package com.example.careconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;

import org.json.JSONArray;

import static android.widget.Toast.LENGTH_SHORT;

public class loginactivity extends AppCompatActivity {
EditText name,pass;
Button login,signin;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";
    public static final String MyPREFERENCES = "MyPrefs" ;
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        final SharedPreferences sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        if (sharedPreferences.getString("logged", "").toString().equals("logged")) {
            Intent intent = new Intent(loginactivity.this, sidenavigation.class);
            startActivity(intent);
        }
        name=(EditText)findViewById(R.id.name);
        //  sname=name.
        login=(Button)findViewById(R.id.login);
        pass=(EditText)findViewById(R.id.pass);
        signin=(Button)findViewById(R.id.create);
       // sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
dbhelper d=new dbhelper(loginactivity.this);
String sname=name.getText().toString();
String spass=pass.getText().toString();
verifymodel v=new verifymodel(sname,spass);
int count=d.verifyuser(v);

    //SharedPreferences.Editor editor = sharedPreferences.edit();
//    SharedPreferences settings = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE );
//    SharedPreferences.Editor editor = settings.edit();
//    editor.putString("logged", "logged");
//    editor.commit();
//    Toast.makeText(getApplicationContext(), "Successfull Login", Toast.LENGTH_SHORT).show();
//    //storing the username and password
//    Toast.makeText(loginactivity.this,"Login Successfully",Toast.LENGTH_SHORT).show();
             //   http://192.168.137.1:8044/api/signin
                AndroidNetworking.get(literals.baseurl)
                        .addQueryParameter("name",sname)
                        .addQueryParameter("pass",spass)
            .addQueryParameter("syncDateTime",null)
            .setTag("test")
            .setPriority(Priority.LOW)
            .build()
            .getAsObject(checkuser.class, new ParsedRequestListener<checkuser>() {
                @Override
                public void onResponse(checkuser response) {
                    if(response.getMessage().equals("nonsuccessfull"))
                    {
                        Toast.makeText(loginactivity.this,"no not working",LENGTH_SHORT).show();
                    }
                    else
                    {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
    SharedPreferences settings = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE );
                        editor = settings.edit();
    editor.putString("logged", "logged");
    editor.commit();
    Toast.makeText(getApplicationContext(), "Successfull Login", Toast.LENGTH_SHORT).show();
    //storing the username and password
    Toast.makeText(loginactivity.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(loginactivity.this,getdata.class);
                startActivity(intent);
                        Toast.makeText(loginactivity.this,"working",LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onError(ANError anError) {
                    System.out.println(anError.getMessage());
                    Toast.makeText(loginactivity.this,anError.getMessage(),LENGTH_SHORT).show();
                }
            });
//    Intent intent=new Intent(loginactivity.this,sidenavigation.class);
//startActivity(intent);
//}
//else
//{
//    Toast.makeText(loginactivity.this,"username or password is incorrect",Toast.LENGTH_SHORT).show();
//
//}
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(loginactivity.this,MainActivity.class);
                startActivity(intent);
                //code for logout
//                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
//                SharedPreferences.Editor editor = settings.edit();
//                editor.remove("logged");
//                editor.commit();
//                finish();
            }
        });

    }
}
