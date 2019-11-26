package com.example.careconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class nomeshactivity extends AppCompatActivity {
RecyclerView recyclerview;
EditText credit,debit;
Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nomeshactivity);
     final List<Integer> creditlist=new ArrayList<Integer>();
        final List<Integer> debitlist=new ArrayList<Integer>();
        recyclerview=(RecyclerView)findViewById(R.id.recyclerview);
credit=(EditText)findViewById(R.id.credit);
debit=(EditText)findViewById(R.id.debit);

        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        submit=(Button)findViewById(R.id.submit);
submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final String creditt=credit.getText().toString();
        final String debitt=debit.getText().toString();
        final int debitint=Integer.parseInt(debitt);
        final int creditint=Integer.parseInt(creditt);
        creditlist.add(creditint);
        debitlist.add(debitint);
        recyclerview.setAdapter(new recyceleradapter(creditlist,debitlist,getApplicationContext()));

    }
});
    }
}
