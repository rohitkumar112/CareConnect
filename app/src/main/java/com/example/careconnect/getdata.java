package com.example.careconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

import static android.widget.Toast.LENGTH_SHORT;

public class getdata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getdata);


        AndroidNetworking.get("http://192.168.137.1:8044/api/department")
                .addQueryParameter("syncDateTime",null)
                .setTag("test")
                .setPriority(Priority.LOW)
                .build()
                .getAsObject(userdepartment.class, new ParsedRequestListener<userdepartment>() {


                    @Override
                    public void onResponse(userdepartment response) {

                        int k=0;
                        if(response!=null)
                        {

for(int i=0;i<response.getData().size();i++)
{

    dbhelper db=new dbhelper(getdata.this);
    db.getWritableDatabase();
                        userdepartmentmodel u=new userdepartmentmodel(response.getData().get(i).getDepartmentid(),response.getData().get(i).getDepartmentname());
                        db.userdepartment(u);
//                        db.insert()
//
//                        if(response.getMessage().equals("nonsuccessfull"))
//                        {
//                            Toast.makeText(getdata.this,"no not working",LENGTH_SHORT).show();
//                        }
//                        else
//                        {
//                            Toast.makeText(getdata.this,"working",LENGTH_SHORT).show();
//                        }

                        }
                        Toast.makeText(getdata.this,"data inserted", LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(getdata.this,anError.getMessage(),LENGTH_SHORT).show();
                        System.out.println(anError.getMessage());
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
}



