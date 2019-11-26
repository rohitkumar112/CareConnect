package com.example.careconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adddepartment extends AppCompatActivity {
EditText name,id;
Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddepartment);
 name=(EditText)findViewById(R.id.departmentname);
 id=(EditText)findViewById(R.id.departmentid);
 add=(Button)findViewById(R.id.add);
 add.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         dbhelper db=new dbhelper(adddepartment.this);
         adddepartmentmodel adddepartmentmodel;
         String no=id.getText().toString();       //this will get a string
         int no2=Integer.parseInt(no);
         adddepartmentmodel = new adddepartmentmodel(no2,name.getText().toString());
       int num=  db.adddepartment(adddepartmentmodel);
       if(num>0)
       {
           Toast.makeText(adddepartment.this,"department successfully added",Toast.LENGTH_SHORT).show();
       }
       else
       {
           Toast.makeText(adddepartment.this,"some error",Toast.LENGTH_SHORT).show();
       }
     }
 });
    }
}
